package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Controller.SubjectController;
import Model.Profesor;
import Model.ProfessorDatabase;

public class ChooseProfessorDialog extends JDialog{
	
	private static ChooseProfessorDialog chooseProfessorDialog = null;
	
	private JList<String> list;
	private DefaultListModel<String> listModel;
	private JScrollPane scrollPane;
	private JPanel south;
	
	private static JButton confirm;
	private static JButton cancel;
	
	public ChooseProfessorDialog() {
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width*1/3, height*2/5);
		ImageIcon img = new ImageIcon("images" + File.separator + "Plus-icon.png");
		setIconImage(img.getImage());
		setTitle("Odaberi profesora");
		setResizable(false);
		
		ArrayList<Profesor> professorList = ProfessorDatabase.getDatabase().getProfessors();
		listModel = new DefaultListModel<String>();
		for(Profesor p: professorList) {
			String professor = p.getName() + " " + p.getSurname();
			listModel.addElement(professor);
		}
		
		list = new JList<String>(listModel);
		list.setFixedCellWidth(width*1/7);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane = new JScrollPane(list);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(30,20,20,20));
		
		confirm = new JButton("Potvrdi");
		if(professorList.isEmpty()) {
			confirm.setEnabled(false);
		}
		
		SubjectController.professorChoosen = false;
		
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = list.getSelectedIndex(); 
				if(selectedRow == - 1) {
					JOptionPane.showMessageDialog(null, "Niste izabrali profesora");
					return;
				}
				Profesor professor = ProfessorDatabase.getDatabase().getProfessorFromRow(selectedRow);
				SubjectController subjectController = SubjectController.getSubjectController();
				subjectController.chooseProfessor(EditSubjectInformationTab.subject, professor);
				
				if(SubjectController.professorChoosen == true) {
					String professorString = professor.getName() + " " + professor.getSurname();
					EditSubjectInformationTab.getProfessorField().setText(professorString);
					EditSubjectInformationTab.getPlus().setEnabled(false);
					EditSubjectInformationTab.getMinus().setEnabled(true);
					EditSubjectInformationTab.getConfirm().setEnabled(true);
					dispose();
					chooseProfessorDialog = null;
				}
			}

		});
		
		
		cancel = new JButton("Odustani");
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				chooseProfessorDialog = null;
				
			}

		});
		
		south = new JPanel();
		south.add(confirm);
		south.add(cancel);
		
		add(scrollPane, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				chooseProfessorDialog = null;
			}
		});
		
		revalidate();
		repaint();
	}
	
	public static ChooseProfessorDialog getChooseProfessorDialog() {
		
		if (chooseProfessorDialog == null) {
			chooseProfessorDialog = new ChooseProfessorDialog();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();;
		}
		
		return chooseProfessorDialog;
	}
	
    
    public static void initComponents() {
		
    	chooseProfessorDialog.setTitle(MainFrame.getMainFrame().getResourceBundle().getString("chooseProfessorDialogTitle"));
    	
    	confirm.setText(MainFrame.getMainFrame().getResourceBundle().getString("confirmBtn"));
		cancel.setText(MainFrame.getMainFrame().getResourceBundle().getString("cancelBtn"));
		
	}
    
	
}
