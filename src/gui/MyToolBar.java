package gui;

import java.awt.Dimension;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class MyToolBar extends JToolBar {
	
	public MyToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		JButton btnCreate = new JButton();
		btnCreate.setToolTipText("Create entity");
		btnCreate.setIcon(new ImageIcon("images/Plus-icon.png"));
		add(btnCreate);

		addSeparator();

		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit entity");
		btnEdit.setIcon(new ImageIcon("images/Pen-5-icon.png"));
		add(btnEdit);

		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete entity");
		btnDelete.setIcon(new ImageIcon("images/Recycle-Bin-icon.png"));
		add(btnDelete);
		
		//addSeparator();
		add(Box.createGlue());
		
		Dimension dim = new Dimension(150,20);
		
		JTextField textField = new JTextField();
		textField.setPreferredSize(dim);
		textField.setMaximumSize(textField.getPreferredSize());
		textField.setToolTipText("Type entity");
		add(textField);
		
		addSeparator();
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search entity");
		btnSearch.setIcon(new ImageIcon("images/search-icon.png"));
		add(btnSearch);
				
		btnCreate.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				CentralPanel centralPanel = CentralPanel.createCentralPanel();
				switch(centralPanel.getSelectedIndex()) {
				
				case 0:
					//AddStudentDialog
					AddStudentDialog addStudDialog = new AddStudentDialog();
					addStudDialog.setLocationRelativeTo(MainFrame.getMainFrame());
					break;
				case 1:
					AddProfessorDialog addProfessorDialog = new AddProfessorDialog();
					addProfessorDialog.setLocationRelativeTo(MainFrame.getMainFrame());
					break;
				case 2:
					//AddSubjectDialog
				    break;

				}
			}
			
		});
		
		
		btnEdit.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				CentralPanel centralPanel = CentralPanel.createCentralPanel();
				switch(centralPanel.getSelectedIndex()) {
				
				case 0:
					//EditStudentDialog
					break;
				case 1:
					EditProfessorDialog editProfessorDialog = new EditProfessorDialog();
					editProfessorDialog.setLocationRelativeTo(MainFrame.getMainFrame());
					EditProfessorDialog.setDialog(editProfessorDialog);
					break;
				case 2:
					//EditSubjectDialog
				    break;

				}
			}
			
		});
		
		btnDelete.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				CentralPanel centralPanel = CentralPanel.createCentralPanel();
				switch(centralPanel.getSelectedIndex()) {
				
				case 0:
					//DeleteStudentDialog
					break;
				case 1:
					DeleteProfessorDialog deleteProfessorDialog = new DeleteProfessorDialog();
					deleteProfessorDialog.setLocationRelativeTo(MainFrame.getMainFrame());
					//EditProfessorDialog.setDialog(editProfessorDialog);
					break;
				case 2:
					//DeleteSubjectDialog
				    break;

				}
			}
			
		});
		
	}

}
