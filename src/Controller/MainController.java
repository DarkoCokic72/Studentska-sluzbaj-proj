package Controller;

import gui.AddProfessorDialog;
import gui.AddStudentDialog;
import gui.CentralPanel;
import gui.DeleteProfessorDialog;
import gui.EditProfessorDialog;
import gui.MainFrame;

public class MainController {
	
	public static void add() {
		
		CentralPanel centralPanel = CentralPanel.getCentralPanel();
		switch(centralPanel.getSelectedIndex()) {
		
		case 0:
			//AddStudentDialog
			AddStudentDialog addStudentDialog = new AddStudentDialog();
			addStudentDialog.setLocationRelativeTo(MainFrame.getMainFrame());
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
	
	public static void edit() {
		
		CentralPanel centralPanel = CentralPanel.getCentralPanel();
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
	
	public static void delete() {
		
		CentralPanel centralPanel = CentralPanel.getCentralPanel();
		switch(centralPanel.getSelectedIndex()) {
		
		case 0:
			//DeleteStudentDialog
			break;
		case 1:
			DeleteProfessorDialog deleteProfessorDialog = new DeleteProfessorDialog();
			deleteProfessorDialog.setLocationRelativeTo(MainFrame.getMainFrame());
			break;
		case 2:
			//DeleteSubjectDialog
		    break;

		}
	}

}
