package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CentralPanel extends JTabbedPane {
	
	private static CentralPanel centralPanel = null;
	private static JPanel students;
	
	private CentralPanel() {
		
		students = new JPanel();
		addTab("Studenti", students);
		students.setLayout(new BorderLayout());
		students.add(new StudentTab());
		
		JPanel professors = new JPanel();
		addTab("Profesori", professors);
		professors.setLayout(new BorderLayout());
		professors.add(new ProfessorTab());
		
		JPanel subjects = new JPanel();
		addTab("Predmeti", subjects);
		subjects.setLayout(new BorderLayout());
		subjects.add(new SubjectTab());
		
		
	}
	
	public static CentralPanel getCentralPanel() {
		
		if(centralPanel == null) {
			centralPanel = new CentralPanel();
		}
		
		return centralPanel;
		
	}
	
	public static void initComponents() {
		
		centralPanel.setTitleAt(0, MainFrame.getMainFrame().getResourceBundle().getString("studentTab"));
		centralPanel.setTitleAt(1, MainFrame.getMainFrame().getResourceBundle().getString("professorsTab"));
		centralPanel.setTitleAt(2, MainFrame.getMainFrame().getResourceBundle().getString("subjectsTab"));
		
		StudentTable.initComponents();
		SubjectJTable.initComponents();
		ProfessorJTable.initComponents();
	}
	

}
