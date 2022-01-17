package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EditStudentPanel extends JTabbedPane{
	private static EditStudentPanel editStudPanel = null;
	
	public EditStudentPanel() {
		JPanel info = new JPanel();
		addTab("Informacije", info);
		info.setLayout(new BorderLayout());
		info.add(EditStudentInformationTab.getEditStudentInformationTab());
		
		JPanel passed = new JPanel();
		addTab("Položeni", passed);
		passed.setLayout(new BorderLayout());
		passed.add(PassedExamsTab.getPassedExamsTab());
		
		JPanel unpassed = new JPanel();
		addTab("Neploženi", unpassed);
		unpassed.setLayout(new BorderLayout());
		unpassed.add(UnpassedExamsTab.getUnpassedExamsTab());
	}
	
	public static EditStudentPanel getEditStudentPanel() {
		if(editStudPanel == null) {
			editStudPanel = new EditStudentPanel();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();;
		}
		
		return editStudPanel;
	}
	
	public static void deleteEditStudPanel() {
		editStudPanel = null;
	}
	
	public static void initComponents() {
		
		editStudPanel.setTitleAt(0, MainFrame.getMainFrame().getResourceBundle().getString("informationTab"));
		editStudPanel.setTitleAt(1, MainFrame.getMainFrame().getResourceBundle().getString("passedSubjectsTab"));
		editStudPanel.setTitleAt(2, MainFrame.getMainFrame().getResourceBundle().getString("unpassedSubjectsTab"));
	
	}
}

