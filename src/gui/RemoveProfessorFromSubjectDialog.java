package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.SubjectController;

public class RemoveProfessorFromSubjectDialog extends JDialog{
	
	JPanel northPanel;
	JPanel southPanel;
	private static JLabel areYouSureLab;
	private static JButton yes;
	private static JButton no ;
		
	public RemoveProfessorFromSubjectDialog() {
		
		northPanel = new JPanel();
		southPanel = new JPanel();
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width*1/4, height*1/5);
		ImageIcon img = new ImageIcon("images" + File.separator + "Recycle-Bin-icon.png");
		setIconImage(img.getImage());
		setTitle("Ukloni profesora");
		setResizable(false);
		
		areYouSureLab = new JLabel();
		areYouSureLab.setText("Da li ste sigurni?");
		northPanel.add(areYouSureLab);
		
		yes = new JButton("Potvrdi");
		yes.setPreferredSize(new Dimension(100,30));
		southPanel.add(yes);
		
		
		SubjectController.professorRemoved = false;
		yes.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				SubjectController subjectController = SubjectController.getSubjectController();
				subjectController.removeProfessor();
				if(SubjectController.professorRemoved) {
					
					EditSubjectInformationTab.getProfessorField().setText("");
					EditSubjectInformationTab.getPlus().setEnabled(true);
					EditSubjectInformationTab.getMinus().setEnabled(false);
					EditSubjectInformationTab.getConfirm().setEnabled(true);
					dispose();
				}
				
			}
	
		});
		
		southPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		
		no = new JButton("Odustani");
		no.setPreferredSize(new Dimension(100,30));
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
