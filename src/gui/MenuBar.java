package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.event.MenuKeyEvent;
import javax.swing.event.MenuKeyListener;

import Controller.MainController;
import persistence.Serialization;

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
		
		miStudent.setMnemonic('t');
		miProfesor.setMnemonic('P');
		miSubject.setMnemonic('r');
		miChair.setMnemonic('K');
		
		miStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_0, ActionEvent.CTRL_MASK));
		miProfesor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
		miSubject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
		miChair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
		
		miOpen.add(miStudent);
		miOpen.add(miSubject);
		miOpen.add(miProfesor);
		miOpen.add(miChair);
		
		JMenuItem miClose = new JMenuItem("Close");
		
		miNew.setIcon(new ImageIcon("images/new-file-icon.png"));
		miSave.setIcon(new ImageIcon("images/Save-as-icon.png"));
		miOpen.setIcon(new ImageIcon("images/open-file-icon.png"));
		miClose.setIcon(new ImageIcon("images/Close-2-icon.png"));
		
		miNew.setMnemonic('N');
		miSave.setMnemonic('S');
		miOpen.setMnemonic('O');
		miClose.setMnemonic('C');
		
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
		
		miEdit.setMnemonic('d');
		miDelete.setMnemonic('e');
		
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
		
		miHelp.setIcon(new ImageIcon("images/Help-icon.png"));
		miAbout.setIcon(new ImageIcon("images/icons8-about-32.png"));
		
		miHelp.setMnemonic('H');
		miAbout.setMnemonic('A');
		
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, (int) ActionEvent.KEY_EVENT_MASK));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
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
				MainController.add();
			}

			
			
		});
		
		miEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				MainController.edit();
			
			}
		});
		
		
		miDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			MainController.delete();
			
			}
		});
		
		miClose.addActionListener(new ActionListener() {
			
			@Override
			// https://coderanch.com/t/650766/java/Mnemonic-shortcuts-consumed
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Serialization.serialization();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.exit(0);
			}
			
		});
		
		miStudent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CentralPanel.getCentralPanel().setSelectedIndex(0);
			}
		});
		
		miProfesor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CentralPanel.getCentralPanel().setSelectedIndex(1);
			}
		});
		
		miSubject.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CentralPanel.getCentralPanel().setSelectedIndex(2);
			}
		});
	}
}
