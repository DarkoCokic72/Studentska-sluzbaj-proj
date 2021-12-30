package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class UnpassedExamsTab extends JPanel{
	
	private JButton btnDelete;
	private JButton btnAdd;
	private JButton btnPassExam;
	
	
	public UnpassedExamsTab() {
		
		btnAdd = new JButton("Dodaj");
		btnAdd.setPreferredSize(new Dimension(100,25));
		
		btnDelete = new JButton("Obrisi");
		btnDelete.setPreferredSize(new Dimension(100,25));;
		
		btnPassExam = new JButton("Polaganje");
		btnPassExam.setPreferredSize(new Dimension(100,25));
		
		JPanel northPanel = new JPanel();
		northPanel.add(btnAdd);
		northPanel.add(btnDelete);
		northPanel.add(btnPassExam);
		northPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane(new UnpassedExamsTable());
		scrollPane.setPreferredSize(new Dimension(600,300));
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 50, 30, 80));
		
		add(northPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
			
		
	}

}
