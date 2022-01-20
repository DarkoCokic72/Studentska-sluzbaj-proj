package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AboutDialog extends JDialog{
	
	private static AboutDialog aboutDialog = null;
	private static JTextArea text;
	private static JLabel student1Lab;
	private static JLabel student2Lab;
	private static JTextArea student1;
	private static JTextArea student2;
	
	
	public AboutDialog() {
		
		setVisible(true);
		setTitle("About");
		setSize(600,500);
		setResizable(false);
		ImageIcon img = new ImageIcon("images" + File.separator + "icons8-about-32.png");
		setIconImage(img.getImage());
		
		text = new JTextArea("\tAplikacija \"Studentska služba\" - manipulacija podacima o studentima,\n\tprofesorima i predmetima");
		text.setEditable(false);
		text.setFont(new Font("Arial",Font.BOLD, 13));
		add(text, BorderLayout.NORTH);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		student1Lab = new JLabel();
		student1Lab.setText("Student1:");
		
		student2Lab = new JLabel();
		student2Lab.setText("Student2:");
		
		student1 = new JTextArea("Darko Cokić RA72/2019, student 3. godine Računarstva i automatike");
		student2 = new JTextArea("Ana Vulin RA65/2019, student 3. godine Računarstva i automatike");
		
		panel1.add(student1Lab);
		panel1.add(student1);
		panel2.add(student2Lab);
		panel2.add(student2);
		
		JPanel center = new JPanel();		
		center.add(panel1, BorderLayout.NORTH);
		center.add(panel2, BorderLayout.SOUTH);
		
		add(center, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				aboutDialog = null;
			}
		});
		
	}
	
	public static AboutDialog getInstance() {
		
		if(aboutDialog == null) {
			aboutDialog = new AboutDialog();
		}
		
		if(MainFrame.languageChanged) {
			initComponents();
		}
		
		return aboutDialog;
		
	}
	
	public static void initComponents() {
		
	}
}
