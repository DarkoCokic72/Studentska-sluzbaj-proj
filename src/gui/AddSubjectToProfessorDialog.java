package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Model.ProfessorDatabase;

public class AddSubjectToProfessorDialog extends JDialog{
	private  static JButton confirm;
	private static JButton cancel;
	
	public AddSubjectToProfessorDialog() {
		setTitle("Dodavanje predmeta");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;
		setSize(width / 4 , height * 3/8);
		setLocationRelativeTo(EditProfessorDialog.getEditProfessorDialog());
		setResizable(false);
		setModal(true);
		setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		JPanel south = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		north.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		
		AddSubjectToProfessorTable.getInstance().updateTable();
		AddSubjectToProfessorTable table = AddSubjectToProfessorTable.getInstance();
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBorder(BorderFactory.createEmptyBorder(30,30,20,30));
		
		JLabel label = new JLabel("Predmeti: ");
		north.add(label);
		
		confirm = new JButton("Potvrdi");
		cancel = new JButton("Odustani");
		
		confirm.setPreferredSize(new Dimension(90, 30));
		cancel.setPreferredSize(new Dimension(90, 30));
		
		north.add(table);
		
		
		
		confirm.setEnabled(true);
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProfessorDatabase.getDatabase().addSubject();
				ProffesorTeachesSubjectTable.getInstance().updateTable();
				dispose();
				
			}
		});
		
		
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		south.add(confirm);
		south.add(Box.createRigidArea(new Dimension(30, 0)));
		south.add(cancel);
		
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		 
		
		
	}
	
}
