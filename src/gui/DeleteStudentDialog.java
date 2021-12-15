package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Controller.StudentController;
import Model.Student;
import Model.StudentDatabase;

public class DeleteStudentDialog extends JDialog {
	private JPanel northPanel;
	private JPanel southPanel;
	
	private static JLabel areYouSureLab;
	private static JButton yes;
	private static JButton no;
	
	public DeleteStudentDialog() {
		int selectedRow = StudentTable.getTable().convertRowIndexToModel(StudentTable.getTable().getSelectedRow());
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Selektujte vrstu koju zelite da izbrisete");
			return;
		}
		
		northPanel = new JPanel();
		southPanel = new JPanel();
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int heigth = d.height;
		int width = d.width;
		setSize(heigth/4, width/4);
		ImageIcon img = new ImageIcon("images/Recycle-Bin-icon.png");
		setIconImage(img.getImage());
		setTitle("Brisanje studenta");
		setResizable(false);
		
		areYouSureLab = new JLabel("Da li ste sigurni da zelita da obrisete studenta?");
		northPanel.add(areYouSureLab);
		
		yes = new JButton();
		yes.setText("Da");
		yes.setPreferredSize(new Dimension(80, 30));
		southPanel.add(yes);
		
		yes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Student student = StudentDatabase.getInstance().getStudentFromRow(selectedRow);
				StudentController controler = StudentController.getStudentConstroler();
				controler.delete(student);
				dispose();
			}
		});
		
		southPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		
		no = new JButton("Ne");
		no.setPreferredSize(new Dimension(80, 30));
		southPanel.add(no);
		
		no.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		northPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(northPanel, BorderLayout.CENTER);
		southPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(southPanel, BorderLayout.SOUTH);
		
		revalidate();
		repaint();
	}
}
