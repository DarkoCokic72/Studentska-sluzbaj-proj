package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EditProfessorPanel extends JTabbedPane {
	
	private static EditProfessorPanel editProfessorPanel = null;
	
	public EditProfessorPanel() {
		
		JPanel information = new JPanel();
		addTab("Informacije", information);
		information.setLayout(new BorderLayout());
		information.add(new EditProfessorInformationTab());
		
		JPanel subjects = new JPanel();
		addTab("Predmeti", subjects);
		subjects.setLayout(new BorderLayout());
				
	}
	
	public static EditProfessorPanel getEditProfessorPanel() {
		
		if(editProfessorPanel == null) {
			editProfessorPanel = new EditProfessorPanel();
		}
		
		return editProfessorPanel;
	}
	
	public static void deleteEditProfessorPanel() {
		editProfessorPanel = null;
		
	}
	
	

}
