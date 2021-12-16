package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.management.remote.TargetedNotification;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class EditStudentDialog extends JDialog{
	private static EditStudentDialog editStudentDialog = null;
	
	public EditStudentDialog() {
		int selectedRow = StudentTable.getTable().convertRowIndexToModel(StudentTable.getTable().getSelectedRow());
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Selektujte vrstu u kojoj se nalazi student kog zelite da izmenite.");
			return;
		}
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int heigth = d.height;
		int width = d.width;
		setSize(width * 3/8, heigth* 25/37);		
		ImageIcon img = new ImageIcon("images/Pen-5-icon.png");
		setIconImage(img.getImage());
		setTitle("Izmena Studenta");
		setResizable(false);
		
		EditStudentPanel editStudPanel = EditStudentPanel.getEditStudentPanel();
		editStudPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		add(editStudPanel, BorderLayout.CENTER);
		
		revalidate();
		repaint();

	}
	
	public static EditStudentDialog getEditStudentDialog() {
		if(editStudentDialog == null) {
			editStudentDialog = new EditStudentDialog();
		}
		
		return editStudentDialog;
	}

	public static void setEditStudentDialog(EditStudentDialog dialog) {
		editStudentDialog = dialog;
	}
	
	public static void deleteEditStudentDialog() {
		editStudentDialog = null;
	}
	
	
}
