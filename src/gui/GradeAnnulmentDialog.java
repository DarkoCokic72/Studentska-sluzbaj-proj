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

import Controller.GradeController;


public class GradeAnnulmentDialog extends JDialog {
	
	private static GradeAnnulmentDialog gradeAnnulmentDialog = null;
	
	JPanel northPanel;
	JPanel southPanel;
	private static JLabel areYouSureLab;
	private static JButton yes;
	private static JButton no ;
	public static int selectedRow;
	
	public GradeAnnulmentDialog() {
		
		selectedRow = PassedExamsTable.getInstance().getSelectedRow();
	
		northPanel = new JPanel();
		southPanel = new JPanel();
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width*1/4, height*1/5);
		ImageIcon img = new ImageIcon("images" + File.separator + "Recycle-Bin-icon.png");
		setIconImage(img.getImage());
		setTitle("Ponistavanje ocene");
		setResizable(false);
		
		areYouSureLab = new JLabel();
		areYouSureLab.setText("Da li ste sigurni da želite da poništite ocenu?");
		northPanel.add(areYouSureLab);
		
		yes = new JButton("Da");
		yes.setPreferredSize(new Dimension(100,30));
		southPanel.add(yes);
		yes.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				GradeController gradeController = GradeController.getGradeController();
				gradeController.annulment();
				
				if(GradeController.gradeAnnuled) {
					
					dispose();
					GradeController.gradeAnnuled = false;
					gradeAnnulmentDialog = null;
					GradeController.exists = false;
				}
				else if(GradeController.exists == false) {
					
					dispose();
					GradeController.gradeAnnuled = false;
					gradeAnnulmentDialog = null;
					GradeController.exists = false;
				}
			}
	
		});
		
		southPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		
		no = new JButton("Ne");
		no.setPreferredSize(new Dimension(100,30));
		southPanel.add(no);
		no.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				gradeAnnulmentDialog = null;
				
			}
	
		});
		
		northPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		add(northPanel,BorderLayout.CENTER);
		southPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		add(southPanel, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				gradeAnnulmentDialog = null;
			}
		});
		
		revalidate(); 
		repaint();
	}
	
	public static GradeAnnulmentDialog getGradeAnnulmentDialog() {
		
		if (gradeAnnulmentDialog == null) {
			gradeAnnulmentDialog = new GradeAnnulmentDialog();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();;
		}
		
		return gradeAnnulmentDialog;
	}
	
    public static void initComponents() {
		
    	gradeAnnulmentDialog.setTitle(MainFrame.getMainFrame().getResourceBundle().getString("gradeAnnulmentDialogTitle"));
		areYouSureLab.setText(MainFrame.getMainFrame().getResourceBundle().getString("areYouSureLabGradeAnnulment"));
		
		yes.setText(MainFrame.getMainFrame().getResourceBundle().getString("yesBtn"));
		no.setText(MainFrame.getMainFrame().getResourceBundle().getString("noBtn"));
		
	}

}
