package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Model.Profesor;

public class EditProfessorDialog extends JDialog {

	private static EditProfessorDialog editProfessorDialog = null;
	
	public EditProfessorDialog() {
		
		int selectedRow = ProfessorJTable.getTable().convertRowIndexToModel(ProfessorJTable.getTable().getSelectedRow());
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Selektujte vrstu u kojoj se nalazi profesor kog zelite da izmenite");
			return;
		}
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width*3/8, height*25/37); 
		ImageIcon img = new ImageIcon("images/Pen-5-icon.png");
		setIconImage(img.getImage());
		setTitle("Izmena profesora");
		setResizable(false);
		
		EditProfessorPanel editProfessorPanel = EditProfessorPanel.getEditProfessorPanel();
		editProfessorPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
		add(editProfessorPanel,BorderLayout.CENTER);
		
		revalidate(); 
		repaint();
		
	}
	
	public static EditProfessorDialog getEditProfessorDialog() {
		
		if (editProfessorDialog == null) {
			editProfessorDialog = new EditProfessorDialog();
		}
		
		return editProfessorDialog;
	}
	
	public static void setDialog(EditProfessorDialog dialog) {
		editProfessorDialog = dialog;
	}
	
	public static void deleteEditProfessorDialog() {
		editProfessorDialog = null;
	}
}
