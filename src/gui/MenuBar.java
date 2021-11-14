package gui;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	public MenuBar() {
		JMenu file = new JMenu("File");
		JMenuItem miNew = new JMenuItem("New");
		JMenuItem miSave = new JMenuItem("Save");
		JMenuItem miOpen = new JMenuItem("Open");
		
		JMenuItem miStudent = new JMenuItem("Studenti");
		JMenuItem miProfesor = new JMenuItem("Profesor");
		JMenuItem miSubject = new JMenuItem("Predmeti");
		JMenuItem miChair = new JMenuItem("Katedre");
		miOpen.add(miStudent);
		miOpen.add(miSubject);
		miOpen.add(miProfesor);
		miOpen.add(miChair);
		
		JMenuItem miClose = new JMenuItem("Close");
		
		miNew.setIcon(new ImageIcon("images/new-file-icon.png"));
		miSave.setIcon(new ImageIcon("images/Save-as-icon.png"));
		miOpen.setIcon(new ImageIcon("images/open-file-icon.png"));
		miClose.setIcon(new ImageIcon("images/Close-2-icon.png"));
		
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
		
		edit.add(miEdit);
		edit.add(miDelete);
		
		edit.setMnemonic('E');
		
		JMenu help = new JMenu("Help");
		JMenuItem miHelp = new JMenuItem("Help");
		JMenuItem miAbout = new JMenuItem("About");
		
		help.add(miHelp);
		help.add(miAbout);
		
		help.setMnemonic('H');
		
		add(file);
		add(edit);
		add(help);
		
		
	}
}
