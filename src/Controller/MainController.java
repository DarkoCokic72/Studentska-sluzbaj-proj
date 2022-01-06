package Controller;

import javax.swing.JTextField;

import gui.AddProfessorDialog;
import gui.AddStudentDialog;
import gui.AddSubjectDialog;
import gui.CentralPanel;
import gui.DeleteProfessorDialog;
import gui.DeleteStudentDialog;
import gui.DeleteSubjectDialog;
import gui.EditProfessorDialog;
import gui.EditStudentDialog;
import gui.MainFrame;
import gui.ProfessorJTable;
import gui.SubjectJTable;

public class MainController {
	
	public static void add() {
		
		CentralPanel centralPanel = CentralPanel.getCentralPanel();
		switch(centralPanel.getSelectedIndex()) {
		
		case 0:
			AddStudentDialog addStudentDialog = new AddStudentDialog();
			addStudentDialog.setLocationRelativeTo(MainFrame.getMainFrame());
			break;
		case 1:
			AddProfessorDialog addProfessorDialog = new AddProfessorDialog();
			addProfessorDialog.setLocationRelativeTo(MainFrame.getMainFrame());
			break;
		case 2:
			AddSubjectDialog addSubjectDialog = new AddSubjectDialog();
			addSubjectDialog.setLocationRelativeTo(MainFrame.getMainFrame());
		    break;

		}
	}
	
	public static void edit() {
		
		CentralPanel centralPanel = CentralPanel.getCentralPanel();
		switch(centralPanel.getSelectedIndex()) {
		
		case 0:
			EditStudentDialog editStudentDialog = new EditStudentDialog();
			editStudentDialog.setLocationRelativeTo(MainFrame.getMainFrame());
			EditStudentDialog.setEditStudentDialog(editStudentDialog);
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
	
	public static void delete() {
		
		CentralPanel centralPanel = CentralPanel.getCentralPanel();
		switch(centralPanel.getSelectedIndex()) {
		
		case 0:
			DeleteStudentDialog deleteStudDialog = new DeleteStudentDialog();
			deleteStudDialog.setLocationRelativeTo(MainFrame.getMainFrame());
			break;
		case 1:
			DeleteProfessorDialog deleteProfessorDialog = new DeleteProfessorDialog();
			deleteProfessorDialog.setLocationRelativeTo(MainFrame.getMainFrame());
			break;
		case 2:
			DeleteSubjectDialog deleteSubjectDialog = new DeleteSubjectDialog();
			deleteSubjectDialog.setLocationRelativeTo(MainFrame.getMainFrame());
			break;

		}
	}
		
	public static void search(JTextField searchField) {
		
		CentralPanel centralPanel = CentralPanel.getCentralPanel();
		switch(centralPanel.getSelectedIndex()) {
		
		case 0:
			
			break;
		case 1:
			ProfessorJTable.getTable().search(searchField.getText());
			break;
		case 2:
			SubjectJTable.getTable().search(searchField.getText());
		    break;
		
		
		}
	}

}
