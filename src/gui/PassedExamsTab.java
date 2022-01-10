package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Model.StudentDatabase;

public class PassedExamsTab extends JPanel{
	private JButton deleteGradeBtn;
	private static JLabel averageLabel;
	private static JLabel totalESPBLabel;
	
	public PassedExamsTab() {
		deleteGradeBtn = new JButton("Ponisti ocenu");
		deleteGradeBtn.setPreferredSize(new Dimension(150, 25));
		deleteGradeBtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Delete Grade
				
			}
		});
		
		double average = StudentDatabase.getInstance().getAverageMark(EditStudentInformationTab.getStudent().getIndexID());
		String averageTxt = String.format("Prosecna ocena: %.2f", average);
		averageLabel = new JLabel(averageTxt);
		
		int espb = StudentDatabase.getInstance().getTotalESPB(EditStudentInformationTab.getStudent().getIndexID());
		String espbTxt = String.format("Ukupno ESPB: %d", espb);
		totalESPBLabel = new JLabel(espbTxt);
		
		JPanel northPanel = new JPanel();
		northPanel.add(deleteGradeBtn, BorderLayout.WEST);
		northPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane(PassedExamsTable.getInstance());
		scrollPane.setPreferredSize(new Dimension(600, 300));
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 50, 30, 80));
		
		JPanel info = new JPanel();
		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
		info.add(averageLabel);
		info.add(Box.createRigidArea(new Dimension(0, 15)));
		info.add(totalESPBLabel);
		
		JPanel southPanel = new JPanel();
		southPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		southPanel.add(info, BorderLayout.EAST);
		
		add(northPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		
	}
	
	public static JLabel getAverageLabel() {
		return averageLabel;
	}
	
	public static JLabel getTotalESPBLabel() {
		return totalESPBLabel;
	}
	
}
