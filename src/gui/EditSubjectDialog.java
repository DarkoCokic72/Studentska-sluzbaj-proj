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
import javax.swing.JOptionPane;

public class EditSubjectDialog extends JDialog {
	private static EditSubjectDialog editSubjectDialog = null;
	public static int selectedRow;
	
	public EditSubjectDialog() {
		selectedRow = SubjectJTable.getTable().getSelectedRow();
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int heigth = d.height;
		int width = d.width;
		setSize(width * 3/8, heigth* 25/37);		
		ImageIcon img = new ImageIcon("images" + File.separator + "Pen-5-icon.png");
		setIconImage(img.getImage());
		setTitle("Izmena predmeta");
		setResizable(false);
		
		EditSubjectPanel editSubjectPanel = EditSubjectPanel.getInstance();
		editSubjectPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		add(editSubjectPanel, BorderLayout.CENTER);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {}
			
			@Override
			public void windowIconified(WindowEvent e) {}
			
			@Override
			public void windowDeiconified(WindowEvent e) {}
			
			@Override
			public void windowDeactivated(WindowEvent e) {}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				SubjectJTable.getTable().updateTable();
			}
			
			@Override
			public void windowClosed(WindowEvent e) {}
			
			@Override
			public void windowActivated(WindowEvent e) {}
		});
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				EditSubjectPanel.deleteInstance();
				editSubjectDialog = null;
				EditSubjectInformationTab.deleteEditSubjectInformationTab();
				PassedExamsTab.deletePassedExamsTab();
			}
		});
		
		
		revalidate();
		repaint();
	}
	
	public static EditSubjectDialog getInstance() {
		if(editSubjectDialog == null)
			editSubjectDialog = new EditSubjectDialog();
		
		if(MainFrame.languageChanged == true) {
			initComponents();
		}
		
		return editSubjectDialog;
	}
	
	public static void deleteInstance() {
		editSubjectDialog = null;
	}

	public static EditSubjectDialog getEditSubjectDialog() {
		if (editSubjectDialog == null) {
			editSubjectDialog = new EditSubjectDialog();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();
		}
		
		return editSubjectDialog;
	}

	public static void setEditSubjectDialog(EditSubjectDialog editSubjectDialog) {
		EditSubjectDialog.editSubjectDialog = editSubjectDialog;
	}
	
	public static void initComponents() {
		
		editSubjectDialog.setTitle(MainFrame.getMainFrame().getResourceBundle().getString("editSubjectDialogTitle"));
	}
}
