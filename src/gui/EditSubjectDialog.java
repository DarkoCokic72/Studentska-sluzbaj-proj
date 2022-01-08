package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class EditSubjectDialog extends JDialog {
	private static EditSubjectDialog editSubjectDialog = null;
	public static int selectedRow;
	
	public EditSubjectDialog() {
		selectedRow = SubjectJTable.getTable().convertRowIndexToModel(SubjectJTable.getTable().getSelectedRow());
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Selektujte vrstu u kojoj se nalazi predmet koji zelite da izmenite");
			return;
		}
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int heigth = d.height;
		int width = d.width;
		setSize(width * 3/8, heigth* 25/37);		
		ImageIcon img = new ImageIcon("images/Pen-5-icon.png");
		setIconImage(img.getImage());
		setTitle("Izmena predmeta");
		setResizable(false);
		
		EditSubjectPanel editSubjectPanel = EditSubjectPanel.getInstance();
		editSubjectPanel.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
		add(editSubjectPanel, BorderLayout.CENTER);
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				SubjectJTable.getTable().updateTable();
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
