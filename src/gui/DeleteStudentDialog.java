package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.StudentController;
import Model.Student;
import Model.StudentDatabase;

public class DeleteStudentDialog extends JDialog {
	
	private static DeleteStudentDialog deleteStudentDialog = null;
	
	private JPanel northPanel;
	private JPanel southPanel;
	
	private static JLabel areYouSureLab;
	private static JButton yes;
	private static JButton no;
	
	public DeleteStudentDialog() {
		int selectedRow = StudentTable.getTable().convertRowIndexToModel(StudentTable.getTable().getSelectedRow());
		
		northPanel = new JPanel();
		southPanel = new JPanel();
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int heigth = d.height;
		int width = d.width;
		setSize(width/4, heigth/4);
		ImageIcon img = new ImageIcon("images/Recycle-Bin-icon.png");
		setIconImage(img.getImage());
		setTitle("Brisanje studenta");
		setResizable(false);
		
		areYouSureLab = new JLabel("Da li ste sigurni da zelita da obrisete studenta?");
		northPanel.add(areYouSureLab);
		
		yes = new JButton();
		yes.setText("Da");
		yes.setPreferredSize(new Dimension(80, 30));
		southPanel.add(yes);
		
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Student student = StudentDatabase.getInstance().getStudentFromRow(selectedRow);
				StudentController controler = StudentController.getStudentConstroler();
				controler.delete(student);
				dispose();
				deleteStudentDialog = null;
			}
		});
		
		southPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		
		no = new JButton("Ne");
		no.setPreferredSize(new Dimension(80, 30));
		southPanel.add(no);
		
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				deleteStudentDialog = null;
			}
		});

		northPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(northPanel, BorderLayout.CENTER);
		southPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(southPanel, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				deleteStudentDialog = null;
			}
		});
		
		revalidate();
		repaint();
	}
	
	public static DeleteStudentDialog getDeleteStudentDialog() {
		
		if (deleteStudentDialog == null) {
			deleteStudentDialog = new DeleteStudentDialog();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();;
		}
		
		return deleteStudentDialog;
	}
	
	 public static void initComponents() {
	    	
		deleteStudentDialog.setTitle(MainFrame.getMainFrame().getResourceBundle().getString("deleteStudentDialogTitle"));
		areYouSureLab.setText(MainFrame.getMainFrame().getResourceBundle().getString("areYouSureLabStudent"));
			
		yes.setText(MainFrame.getMainFrame().getResourceBundle().getString("yesBtn"));
		no.setText(MainFrame.getMainFrame().getResourceBundle().getString("noBtn"));

	}
}
