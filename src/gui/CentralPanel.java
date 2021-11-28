package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CentralPanel extends JTabbedPane {
	
	public CentralPanel() {
		
		JPanel students = new JPanel();
		JPanel professors = new JPanel();
		JPanel subjects = new JPanel();
		
		addTab("Studenti", students);
		addTab("Profesori", professors);
		addTab("Predmeti", subjects);
		
	}

}
