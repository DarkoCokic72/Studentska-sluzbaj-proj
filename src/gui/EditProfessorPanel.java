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
		information.add(EditProfessorInformationTab.getEditProfessorInformationTab());
		
		JPanel subjects = new JPanel();
		addTab("Predmeti", subjects);
		subjects.setLayout(new BorderLayout());
				
	}
	
	public static EditProfessorPanel getEditProfessorPanel() {
		
		if(editProfessorPanel == null) {
			editProfessorPanel = new EditProfessorPanel();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();;
		}
		
		return editProfessorPanel;
	}
	
	public static void deleteEditProfessorPanel() {
		editProfessorPanel = null;
		
	}
	
	
	public static void initComponents() {
		
		editProfessorPanel.setTitleAt(0, MainFrame.getMainFrame().getResourceBundle().getString("informationTab"));
		editProfessorPanel.setTitleAt(1, MainFrame.getMainFrame().getResourceBundle().getString("subjectsTab"));
		
		
	}
	

}
