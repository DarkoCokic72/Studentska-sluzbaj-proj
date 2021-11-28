package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SubjectTab extends JPanel {
	
	public SubjectTab() {
		
		setLayout(new BorderLayout());
		SubjectJTable subTable = new SubjectJTable();
		JScrollPane scrollPane = new JScrollPane(subTable);
		
		scrollPane.setPreferredSize(new Dimension(800,400));
		scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 50, 30, 80));
		add(scrollPane, BorderLayout.CENTER);
		
	}
	
}
