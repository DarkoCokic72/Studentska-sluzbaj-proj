package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Model.Profesor;
import Model.ProfessorDatabase;

public class ChooseProfessorDialog extends JDialog{
	
	private JList<String> list;
	private DefaultListModel<String> listModel;
	private JScrollPane scrollPane;
	private JPanel south;
	
	private JButton confirm;
	private JButton cancel;
	
	public ChooseProfessorDialog() {
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width*1/3, height*2/5);
		ImageIcon img = new ImageIcon("images/Plus-icon.png");
		setIconImage(img.getImage());
		setTitle("Odaberi profesora");
		setResizable(false);
		
		ArrayList<Profesor> professorList = ProfessorDatabase.getDatabase().getProfessors();
		listModel = new DefaultListModel<String>();
		for(Profesor p: professorList) {
			String professor = p.getName() + " " + p.getSurname();
			listModel.addElement(professor);
		}
		
		list = new JList<String>(listModel);
		list.setFixedCellWidth(width*1/7);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane = new JScrollPane(list);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(30,20,20,20));
		
		confirm = new JButton("Potvrdi");
		if(professorList.isEmpty()) {
			confirm.setEnabled(false);
		}
		
		
		cancel = new JButton("Odustani");
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
			}

		});
		
		south = new JPanel();
		south.add(confirm);
		south.add(cancel);
		
		add(scrollPane, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		revalidate();
		repaint();
	}
	

}
