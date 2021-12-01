package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class StudentTab extends JPanel{
	public StudentTab() {
		setLayout(new BorderLayout());
		StudentTable stTable = StudentTable.getTable();
		JScrollPane scrPane = new JScrollPane(stTable);
		
		scrPane.setPreferredSize(new Dimension(800, 450));
		scrPane.setBorder(BorderFactory.createEmptyBorder(50, 50, 30, 80));
		add(scrPane,BorderLayout.CENTER);
	}
}
