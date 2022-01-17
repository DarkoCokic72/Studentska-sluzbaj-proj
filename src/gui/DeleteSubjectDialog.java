package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.SubjectController;
import Model.Subject;
import Model.SubjectDatabase;

public class DeleteSubjectDialog extends JDialog {
	
	private static DeleteSubjectDialog deleteSubjectDialog = null;
	
	JPanel northPanel;
	JPanel southPanel;
	private static JLabel areYouSureLab;
	private static JButton yes;
	private static JButton no ;
	
	public DeleteSubjectDialog() {
		
		int selectedRow = SubjectJTable.getTable().getSelectedRow();
		
		northPanel = new JPanel();
		southPanel = new JPanel();
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width*1/4, height*1/5);
		ImageIcon img = new ImageIcon("images" + File.separator +"Recycle-Bin-icon.png");
		setIconImage(img.getImage());
		setTitle("Brisanje profesora");
		setResizable(false);
		
		areYouSureLab = new JLabel();
		areYouSureLab.setText("Da li ste sigurni da želite da obrišete predmet?");
		northPanel.add(areYouSureLab);
		
		yes = new JButton("DA");
		yes.setPreferredSize(new Dimension(80,30));
		southPanel.add(yes);
		
		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				Subject subject = SubjectDatabase.getDatabase().getSubjectFromRow(selectedRow);
				SubjectController subjectContr = SubjectController.getSubjectController();
				subjectContr.delete(subject);
				dispose();
				deleteSubjectDialog = null;
				
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
				deleteSubjectDialog = null;
				
			}

		});
		
		northPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		add(northPanel,BorderLayout.CENTER);
		southPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(southPanel, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				deleteSubjectDialog = null;
			}
		});
		
		revalidate(); 
		repaint();
		
		
	}
	
	public static DeleteSubjectDialog getDeleteSubjectDialog() {
		
		if (deleteSubjectDialog == null) {
			deleteSubjectDialog = new DeleteSubjectDialog();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();;
		}
		
		return deleteSubjectDialog;
	}
	
	 public static void initComponents() {
	    	
		deleteSubjectDialog.setTitle(MainFrame.getMainFrame().getResourceBundle().getString("deleteSubjectDialogTitle"));
		areYouSureLab.setText(MainFrame.getMainFrame().getResourceBundle().getString("areYouSureLabSubject"));
			
		yes.setText(MainFrame.getMainFrame().getResourceBundle().getString("yesBtn"));
		no.setText(MainFrame.getMainFrame().getResourceBundle().getString("noBtn"));

	}

}