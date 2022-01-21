package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import Controller.MainController;
import persistence.Serialization;

public class MenuBar extends JMenuBar{
	
	private static JMenu file;
	private static JMenuItem miNew;
	private static JMenuItem miSave;
	private static JMenuItem miOpen;
	
	private static JMenuItem miStudent;
	private static JMenuItem miProfesor;
	private static JMenuItem miSubject;
	private static JMenuItem miChair;
	private static JMenuItem miClose;
	
	private static JMenu edit;
	private static JMenuItem miEdit;
	private static JMenuItem miDelete;
	
	private static JMenu help;
	private static JMenuItem miHelp;
	private static JMenuItem miAbout;
	private static JRadioButtonMenuItem miEnglish;
	private static JRadioButtonMenuItem miSerbian;
	
	public MenuBar() {
		
		file = new JMenu("File");
		miNew = new JMenuItem("New");
		miSave = new JMenuItem("Save");
		miOpen = new JMenu("Open");
		
		miStudent = new JMenuItem("Studenti");
		miProfesor = new JMenuItem("Profesor");
		miSubject = new JMenuItem("Predmeti");
		miChair = new JMenuItem("Katedre");
		
		miStudent.setIcon(new ImageIcon("images" + File.separator + "student.png"));
		miProfesor.setIcon(new ImageIcon("images" + File.separator + "teacher.png"));
		miSubject.setIcon(new ImageIcon("images" + File.separator + "books-icon.png"));
		miChair.setIcon(new ImageIcon("images" + File.separator + "university.png"));
		
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
		
		miClose = new JMenuItem("Close");
		
		miNew.setIcon(new ImageIcon("images" + File.separator + "new-file-icon.png"));
		miSave.setIcon(new ImageIcon("images" + File.separator + "Save-as-icon.png"));
		miOpen.setIcon(new ImageIcon("images" + File.separator + "open-file-icon.png"));
		miClose.setIcon(new ImageIcon("images" + File.separator + "Close-2-icon.png"));
		
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
		
		
		edit = new JMenu("Edit");
		miEdit = new JMenuItem("Edit");
		miDelete = new JMenuItem("Delete");
		
		miEdit.setMnemonic('E');
		miDelete.setMnemonic('D');
		
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.SHIFT_MASK));
		
		miEdit.setIcon(new ImageIcon("images" + File.separator + "edit-icon.png"));
		miDelete.setIcon(new ImageIcon("images" + File.separator + "trash-icon.png"));
		
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		edit.setMnemonic('E');
		
		help = new JMenu("Help");
		miHelp = new JMenuItem("Help");
		miAbout = new JMenuItem("About");
		
		miHelp.setIcon(new ImageIcon("images" + File.separator + "Help-icon.png"));
		miAbout.setIcon(new ImageIcon("images" + File.separator + "icons8-about-32.png"));
		
		miHelp.setMnemonic('H');
		miAbout.setMnemonic('A');
		
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, (int) ActionEvent.KEY_EVENT_MASK));
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		miAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				AboutDialog aboutDialog = AboutDialog.getInstance();
				aboutDialog.setLocationRelativeTo(MainFrame.getMainFrame());
			}
		});
		
		miHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HelpDialog help = HelpDialog.getInstance();
				help.setLocationRelativeTo(MainFrame.getMainFrame());
				
			}
		});
		
		miEnglish = new JRadioButtonMenuItem("English");
		miEnglish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Locale.setDefault(new Locale("en", "US"));
				MainFrame.englishLanguage = true;
				MainFrame.serbianLanguage = false;
				MainFrame.getMainFrame().changeLanguage();
			}
		});
		
		miSerbian = new JRadioButtonMenuItem("Serbian");
		miSerbian.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("sr", "RS"));
				MainFrame.englishLanguage = false;
				MainFrame.serbianLanguage = true;
				MainFrame.getMainFrame().changeLanguage();
			}
		});

		
		ButtonGroup group = new ButtonGroup();
		group.add(miEnglish);
		group.add(miSerbian);
		
		help.add(miEnglish);
		help.add(miSerbian);
		help.addSeparator();
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		help.setMnemonic('H');
		miEnglish.setMnemonic('n');
		miSerbian.setMnemonic('r');
		
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
		
		miChair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChairDialog chairDialog = ChairDialog.getInstance();
				chairDialog.setLocationRelativeTo(MainFrame.getMainFrame());
				
			}
		});
		
		miSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Serialization.serialization();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	public static void initComponents() {
		
		file.setText(MainFrame.getMainFrame().getResourceBundle().getString("file"));
		miNew.setText(MainFrame.getMainFrame().getResourceBundle().getString("miNew"));
		miSave.setText(MainFrame.getMainFrame().getResourceBundle().getString("miSave"));
		miOpen.setText(MainFrame.getMainFrame().getResourceBundle().getString("miOpen"));
		miClose.setText(MainFrame.getMainFrame().getResourceBundle().getString("miClose"));
		
		miStudent.setText(MainFrame.getMainFrame().getResourceBundle().getString("miStudent"));
		miProfesor.setText(MainFrame.getMainFrame().getResourceBundle().getString("miProfessor"));
		miSubject.setText(MainFrame.getMainFrame().getResourceBundle().getString("miSubject"));
		miChair.setText(MainFrame.getMainFrame().getResourceBundle().getString("miDepartments"));
		
		edit.setText(MainFrame.getMainFrame().getResourceBundle().getString("edit"));
		miEdit.setText(MainFrame.getMainFrame().getResourceBundle().getString("miEdit"));
		miDelete.setText(MainFrame.getMainFrame().getResourceBundle().getString("miDelete"));
		
		help.setText(MainFrame.getMainFrame().getResourceBundle().getString("help"));
		miHelp.setText(MainFrame.getMainFrame().getResourceBundle().getString("miHelp"));
		miAbout.setText(MainFrame.getMainFrame().getResourceBundle().getString("miAbout"));
		miEnglish.setText(MainFrame.getMainFrame().getResourceBundle().getString("miEnglish"));
		miSerbian.setText(MainFrame.getMainFrame().getResourceBundle().getString("miSerbian"));
		
		if(MainFrame.serbianLanguage) {
			
			file.setMnemonic('D');
			edit.setMnemonic('I');
			help.setMnemonic('P');
			miNew.setMnemonic('N');
			miOpen.setMnemonic('O');
			miClose.setMnemonic('Z');
			miStudent.setMnemonic('t');
			miProfesor.setMnemonic('P');
			miSubject.setMnemonic('r');
			miChair.setMnemonic('K');
			miEdit.setMnemonic('I');
			miDelete.setMnemonic('O');
			miHelp.setMnemonic('P');
			miAbout.setMnemonic('A');
			miEnglish.setMnemonic('n');
			miSerbian.setMnemonic('r');
			
		} else {
			
			file.setMnemonic('F');
			edit.setMnemonic('E');
			help.setMnemonic('H');
			miNew.setMnemonic('N');
			miOpen.setMnemonic('O');
			miClose.setMnemonic('C');
			miStudent.setMnemonic('t');
			miProfesor.setMnemonic('P');
			miSubject.setMnemonic('u');
			miChair.setMnemonic('D');
			miEdit.setMnemonic('E');
			miDelete.setMnemonic('D');
			miHelp.setMnemonic('H');
			miAbout.setMnemonic('A');
			miEnglish.setMnemonic('n');
			miSerbian.setMnemonic('r');
		}
		
	}
}
