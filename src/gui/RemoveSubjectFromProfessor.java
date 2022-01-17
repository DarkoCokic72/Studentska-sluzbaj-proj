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

public class RemoveSubjectFromProfessor extends JDialog{
	public RemoveSubjectFromProfessor() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		
		setSize(width /4, height /6);
		setModal(true);
		setResizable(false);
		setTitle("Ukloni predmet");
		setLocationRelativeTo(EditProfessorDialog.getEditProfessorDialog());
		setLayout(new BorderLayout());
		
		JPanel north= new JPanel();
		JPanel south = new JPanel();
		
		north.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		
		JLabel label = new JLabel("Da li ste sigurni?");
		JButton yes = new JButton("Da");
		JButton no = new JButton("Ne");
		
		north.add(label);
		
		yes.setPreferredSize(new Dimension(70, 30));
		no.setPreferredSize(new Dimension(70, 30));
		
		
		
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProfessorController.getProfessorController()
				.removeSubject(Integer.parseInt(EditProfessorInformationTab.getPersonalId().getText().trim()));
				validate();
				dispose();
				
			}
		});
		
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		south.add(yes);
		south.add(Box.createRigidArea(new Dimension(30, 0)));
		south.add(no);
		
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		
	}
}
