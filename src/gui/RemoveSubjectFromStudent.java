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

import Controller.StudentController;

public class RemoveSubjectFromStudent extends JDialog{
	
	public RemoveSubjectFromStudent(EditStudentDialog parent) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int heigth = d.height;
		
		setSize(width * 35/100, heigth * 1 /6);
		setModal(true);
		setResizable(false);
		setTitle("Uklanjanje predmeta");
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());
		
		JPanel central = new JPanel();
		JPanel south = new JPanel();
		
		JLabel tekst = new JLabel("Da li ste sigurni da želite da izvršite radnju uklanjanja predmeta sa studenta?");
		central.add(tekst);
		central.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
		
		JButton yesBtn = new JButton("Da");
		JButton noBtn = new JButton("Ne");
		
		yesBtn.setPreferredSize(new Dimension(60, 30));
		noBtn.setPreferredSize(new Dimension(60, 30));
		
		yesBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentController.getStudentConstroler().removeSubject(EditStudentInformationTab.getStudent().getIndexID());
				validate();
				dispose();
			}
		});
		
		
		noBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		south.add(yesBtn);
		south.add(Box.createRigidArea(new Dimension(20, 0)));
		south.add(noBtn);
		
		south.setBorder(BorderFactory.createEmptyBorder(11, 11 ,11 ,11));
		
		add(central, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
	}

}
