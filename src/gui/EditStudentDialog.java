package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

public class EditStudentDialog extends JDialog{
	private static EditStudentDialog editStudentDialog = null;
	public static int selectedRow;
	
	public EditStudentDialog() {
		
		selectedRow = StudentTable.getTable().getSelectedRow();
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int heigth = d.height;
		int width = d.width;
		setSize(width * 3/8, heigth* 25/37);		
		ImageIcon img = new ImageIcon("images" + File.separator + "Pen-5-icon.png");
		setIconImage(img.getImage());
		setTitle("Izmena Studenta");
		setResizable(false);
		
		EditStudentPanel editStudPanel = EditStudentPanel.getEditStudentPanel();
		editStudPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		add(editStudPanel, BorderLayout.CENTER);
		addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {}

			@Override
			public void windowClosed(WindowEvent arg0) {}

			@Override
			public void windowClosing(WindowEvent arg0) { //potrebno je da azuriramo tabelu ako zatvorimo Dialog na X
				StudentTable.getTable().updateTable();
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {}

			@Override
			public void windowDeiconified(WindowEvent arg0) {}

			@Override
			public void windowIconified(WindowEvent arg0) {}


			@Override
			public void windowOpened(WindowEvent e) {}
			
		});
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				EditStudentPanel.deleteEditStudPanel();
		    	EditStudentDialog.deleteEditStudentDialog();
				EditStudentInformationTab.deleteEditStudentInformationTab();
				StudentTable.getTable().updateTable();
			}
		});
		
		
		revalidate();
		repaint();

	}
	
	public static EditStudentDialog getEditStudentDialog() {
		if(editStudentDialog == null) {
			editStudentDialog = new EditStudentDialog();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();
		}
		
		return editStudentDialog;
	}

	
	public static void deleteEditStudentDialog() {
		editStudentDialog = null;
	}
	
	public static void initComponents() {
		
		editStudentDialog.setTitle(MainFrame.getMainFrame().getResourceBundle().getString("editStudentDialogTitle"));
		
	}
	
	
}
