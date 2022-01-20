package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class EditProfessorDialog extends JDialog {

	private static EditProfessorDialog editProfessorDialog = null;
	
	public EditProfessorDialog() {
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width*3/8, height*25/37); 
		ImageIcon img = new ImageIcon("images" + File.separator +"Pen-5-icon.png");
		setIconImage(img.getImage());
		setTitle("Izmena profesora");
		setResizable(false);
		
		EditProfessorPanel editProfessorPanel = EditProfessorPanel.getEditProfessorPanel();
		editProfessorPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		add(editProfessorPanel,BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				EditProfessorPanel.deleteEditProfessorPanel();
		    	EditProfessorDialog.deleteEditProfessorDialog();
				EditProfessorInformationTab.deleteEditProfessorInformationTab();
				ProfesorSubjectsPanel.deleteInstance();
			
			}
		});
		
		revalidate(); 
		repaint();
		
	}
	
	public static EditProfessorDialog getEditProfessorDialog() {
		
		if (editProfessorDialog == null) {
			editProfessorDialog = new EditProfessorDialog();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();
		}
		
		return editProfessorDialog;
	}
	
	public static void deleteEditProfessorDialog() {
		editProfessorDialog = null;
	}
	
	
	public static void initComponents() {
		
		editProfessorDialog.setTitle(MainFrame.getMainFrame().getResourceBundle().getString("editProfessorDialogTitle"));
		
	}
}
