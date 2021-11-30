package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar{
	public MenuBar() {
		JMenu file = new JMenu("File");
		JMenuItem miNew = new JMenuItem("New");
		JMenuItem miSave = new JMenuItem("Save");
		JMenu miOpen = new JMenu("Open");
		
		JMenuItem miStudent = new JMenuItem("Studenti");
		JMenuItem miProfesor = new JMenuItem("Profesor");
		JMenuItem miSubject = new JMenuItem("Predmeti");
		JMenuItem miChair = new JMenuItem("Katedre");
		
		miStudent.setIcon(new ImageIcon("images/student.png"));
		miProfesor.setIcon(new ImageIcon("images/teacher.png"));
		miSubject.setIcon(new ImageIcon("images/books-icon.png"));
		miChair.setIcon(new ImageIcon("images/university.png"));
		
		miOpen.add(miStudent);
		miOpen.add(miSubject);
		miOpen.add(miProfesor);
		miOpen.add(miChair);
		
		JMenuItem miClose = new JMenuItem("Close");
		
		miNew.setIcon(new ImageIcon("images/new-file-icon.png"));
		miSave.setIcon(new ImageIcon("images/Save-as-icon.png"));
		miOpen.setIcon(new ImageIcon("images/open-file-icon.png"));
		miClose.setIcon(new ImageIcon("images/Close-2-icon.png"));
		
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		// FIXME miOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		
		file.add(miNew);
		file.addSeparator();
		file.add(miSave);
		file.addSeparator();
		file.add(miOpen);
		file.addSeparator();
		file.add(miClose);
		
		file.setMnemonic('F');
		
		JMenu edit = new JMenu("Edit");
		JMenuItem miEdit = new JMenuItem("Edit");
		JMenuItem miDelete = new JMenuItem("Delete");
		
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.SHIFT_MASK));
		
		miEdit.setIcon(new ImageIcon("images/edit-icon.png"));
		miDelete.setIcon(new ImageIcon("images/trash-icon.png"));
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		edit.setMnemonic('E');
		
		JMenu help = new JMenu("Help");
		JMenuItem miHelp = new JMenuItem("Help");
		JMenuItem miAbout = new JMenuItem("About");
		
		//FIXME miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, ActionEvent.KEY_EVENT_MASK));
		
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		help.setMnemonic('H');
		
		add(file);
		add(edit);
		add(help);
		
        
		miNew.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				CentralPanel centralPanel = CentralPanel.createCentralPanel();
				switch(centralPanel.getSelectedIndex()) {
				
				case 0:
					//AddStudentDialog
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
		
		miEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
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
		
		
		
				
		
	}
}
