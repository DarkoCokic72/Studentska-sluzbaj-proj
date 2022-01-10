package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EditStudentPanel extends JTabbedPane{
	private static EditStudentPanel editStudPanel = null;
	
	public EditStudentPanel() {
		JPanel info = new JPanel();
		addTab("Informacije", info);
		info.setLayout(new BorderLayout());
		info.add(new EditStudentInformationTab());
		
		JPanel passed = new JPanel();
		addTab("Polozeni", passed);
		passed.setLayout(new BorderLayout());
		passed.add(new PassedExamsTab());
		
		JPanel unpassed = new JPanel();
		addTab("Neplozeni", unpassed);
		unpassed.setLayout(new BorderLayout());
		unpassed.add(new UnpassedExamsTab());
	}
	
	public static EditStudentPanel getEditStudentPanel() {
		if(editStudPanel == null) {
			editStudPanel = new EditStudentPanel();
		}
		
		return editStudPanel;
	}
	
	public static void deleteEditStudPanel() {
		editStudPanel = null;
	}
}
