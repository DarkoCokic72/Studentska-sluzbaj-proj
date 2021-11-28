package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProfessorTab extends JPanel {
	
    public ProfessorTab() {
		
		setLayout(new BorderLayout());
     	ProfessorJTable professorTable = new ProfessorJTable();
		JScrollPane scrollPane = new JScrollPane(professorTable);
		
		scrollPane.setPreferredSize(new Dimension(800,400));
		scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 50, 30, 80));
		add(scrollPane, BorderLayout.CENTER);
		
	}

}
