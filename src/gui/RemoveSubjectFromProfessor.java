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
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ProfessorController;

public class RemoveSubjectFromProfessor extends JDialog{
	
	private static RemoveSubjectFromProfessor removeSubjectFromProfessor = null;
	private static JLabel areYouSureLab;
	private static JButton yes;
	private static JButton no;
	
	public RemoveSubjectFromProfessor() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		
		setSize(width /4, height /6);
		setModal(true);
		setResizable(false);
		setTitle("Ukloni predmet");
		setLocationRelativeTo(EditProfessorDialog.getEditProfessorDialog());
		setLayout(new BorderLayout());
		
		JPanel north= new JPanel();
		JPanel south = new JPanel();
		
		north.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		
		areYouSureLab = new JLabel("Da li ste sigurni?");
		yes = new JButton("Da");
		no = new JButton("Ne");
		
		north.add(areYouSureLab);
		
		yes.setPreferredSize(new Dimension(70, 30));
		no.setPreferredSize(new Dimension(70, 30));
		
		
		
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProfessorController.getProfessorController()
				.removeSubject(Integer.parseInt(EditProfessorInformationTab.getPersonalId().getText().trim()));
				validate();
				dispose();
				removeSubjectFromProfessor = null;
				
			}
		});
		
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				removeSubjectFromProfessor = null;
			}
		});
		
		south.add(yes);
		south.add(Box.createRigidArea(new Dimension(30, 0)));
		south.add(no);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				removeSubjectFromProfessor = null;
			}
		});
		
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		
	}
	
	
	public static RemoveSubjectFromProfessor getRemoveSubjectFromProfessor() {
		
		if (removeSubjectFromProfessor == null) {
			removeSubjectFromProfessor= new RemoveSubjectFromProfessor();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();;
		}
		
		return removeSubjectFromProfessor;
	}
	
	public static void initComponents() {
		
    	removeSubjectFromProfessor.setTitle(MainFrame.getMainFrame().getResourceBundle().getString("removeSubjectFromSubjectDialogTitle"));
    	areYouSureLab.setText(MainFrame.getMainFrame().getResourceBundle().getString("areYouSureLab"));
    	
    	yes.setText(MainFrame.getMainFrame().getResourceBundle().getString("confirmBtn"));
		no.setText(MainFrame.getMainFrame().getResourceBundle().getString("cancelBtn"));
		
	}
}
