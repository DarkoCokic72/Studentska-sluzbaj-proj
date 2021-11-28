package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CentralPanel extends JTabbedPane {
	
	public CentralPanel() {
		
		JPanel students = new JPanel();
		addTab("Studenti", students);
		students.setLayout(new BorderLayout());
		
		JPanel professors = new JPanel();
		addTab("Profesori", professors);
		professors.setLayout(new BorderLayout());
		professors.add(new ProfessorTab());
		
		JPanel subjects = new JPanel();
		addTab("Predmeti", subjects);
		subjects.setLayout(new BorderLayout());
		subjects.add(new SubjectTab());
		
		
	}

}
