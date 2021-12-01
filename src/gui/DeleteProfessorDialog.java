package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.ProfessorController;

public class DeleteProfessorDialog extends JDialog {
	
	JPanel northPanel;
	JPanel southPanel;
	private static JLabel areYouSureLab;
	private static JButton yes;
	private static JButton no ;
	
	public DeleteProfessorDialog() {
		
		northPanel = new JPanel();
		southPanel = new JPanel();
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width*1/4, height*1/5); 
		setTitle("Brisanje profesora");
		setResizable(false);
		
		areYouSureLab = new JLabel();
		areYouSureLab.setText("Da li ste sigurni da �elite da obri�ete profesora?");
		northPanel.add(areYouSureLab);
		
		yes = new JButton("DA");
		yes.setPreferredSize(new Dimension(80,30));
		southPanel.add(yes);
		
		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				//ProfessorController professorContr = ProfessorController.getProfessorController();
				//professorContr.delete();
				dispose();
				
			}

		});
		
		southPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		
		no = new JButton("NE");
		no.setPreferredSize(new Dimension(80,30));
		southPanel.add(no);
		
		no.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}

		});
		
		northPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		add(northPanel,BorderLayout.CENTER);
		southPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(southPanel, BorderLayout.SOUTH);
		
		revalidate(); 
		repaint();
		
		
	}

}