package Controller;

import javax.swing.JOptionPane;
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
import gui.EditSubjectDialog;
import gui.MainFrame;
import gui.ProfessorJTable;
import gui.StudentTable;
import gui.SubjectJTable;

public class MainController {
	
	public static void add() {
		
		CentralPanel centralPanel = CentralPanel.getCentralPanel();
		switch(centralPanel.getSelectedIndex()) {
		
		case 0:
			AddStudentDialog addStudentDialog = AddStudentDialog.getAddStudentDialog();
			addStudentDialog.setLocationRelativeTo(MainFrame.getMainFrame());
			break;
		case 1:
			AddProfessorDialog addProfessorDialog = AddProfessorDialog.getAddProfessorDialog();
			addProfessorDialog.setLocationRelativeTo(MainFrame.getMainFrame());
			break;
		case 2:
			AddSubjectDialog addSubjectDialog = AddSubjectDialog.getAddSubjectDialog();
			addSubjectDialog.setLocationRelativeTo(MainFrame.getMainFrame());
		    break;

		}
	}
	
	public static void edit() {
		
		CentralPanel centralPanel = CentralPanel.getCentralPanel();
		switch(centralPanel.getSelectedIndex()) {
		
		case 0:
			int selectedRow = StudentTable.getTable().getSelectedRow();
			if(selectedRow == -1) {
				if(MainFrame.languageChanged) {
					JOptionPane.showMessageDialog(null, MainFrame.getMainFrame().getResourceBundle().getString("selectRowError"));
					return;
				}
				JOptionPane.showMessageDialog(null, "Selektujte vrstu u kojoj se nalazi student kog želite da izmenite.");
				return;
			} else {
			EditStudentDialog editStudentDialog = EditStudentDialog.getEditStudentDialog();
			editStudentDialog.setLocationRelativeTo(MainFrame.getMainFrame());
			}
			break;
		case 1:
			
			selectedRow = ProfessorJTable.getTable().getSelectedRow();
			if(selectedRow == -1) {
				
				if(MainFrame.languageChanged) {
					JOptionPane.showMessageDialog(null, MainFrame.getMainFrame().getResourceBundle().getString("selectRowError"));
					return;
				}
				
				JOptionPane.showMessageDialog(null, "Selektujte vrstu u kojoj se nalazi profesor kog želite da izmenite");
				return;
			} else {
			EditProfessorDialog editProfessorDialog = EditProfessorDialog.getEditProfessorDialog();
			editProfessorDialog.setLocationRelativeTo(MainFrame.getMainFrame());
			}
			break;
			
		case 2:
			
			selectedRow = SubjectJTable.getTable().getSelectedRow();
			if(selectedRow == -1) {
				if(MainFrame.languageChanged) {
					JOptionPane.showMessageDialog(null, MainFrame.getMainFrame().getResourceBundle().getString("selectRowError"));
					return;
				}
				JOptionPane.showMessageDialog(null, "Selektujte vrstu u kojoj se nalazi predmet koji želite da izmenite");
				return;
			} else {
			
			EditSubjectDialog editSubjectDialog = EditSubjectDialog.getEditSubjectDialog();
			editSubjectDialog.setLocationRelativeTo(MainFrame.getMainFrame());
		    break;
			}
		}
		
	}
	
	public static void delete() {
		
		CentralPanel centralPanel = CentralPanel.getCentralPanel();
		switch(centralPanel.getSelectedIndex()) {
		
		case 0:
			int selectedRow = StudentTable.getTable().convertRowIndexToModel(StudentTable.getTable().getSelectedRow());
			if(selectedRow == -1) {
				if(MainFrame.languageChanged) {
					JOptionPane.showMessageDialog(null, MainFrame.getMainFrame().getResourceBundle().getString("selectRowError"));
					return;
				}
				JOptionPane.showMessageDialog(null, "Selektujte vrstu koju zelite da izbrisete");
				return;
			}
			else {
			DeleteStudentDialog deleteStudDialog = DeleteStudentDialog.getDeleteStudentDialog();
			deleteStudDialog.setLocationRelativeTo(MainFrame.getMainFrame());
		}
			break;
		case 1:
			selectedRow = ProfessorJTable.getTable().getSelectedRow();
			if(selectedRow == -1) {
				if(MainFrame.languageChanged) {
					JOptionPane.showMessageDialog(null, MainFrame.getMainFrame().getResourceBundle().getString("selectRowError"));
					return;
				}
				JOptionPane.showMessageDialog(null, "Selektujte vrstu u kojoj se nalazi profesor kog želite da obrišete");
				return;
			} else {
			DeleteProfessorDialog deleteProfessorDialog =  DeleteProfessorDialog.getDeleteProfessorDialog();
			deleteProfessorDialog.setLocationRelativeTo(MainFrame.getMainFrame());
			}
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
			StudentTable.getTable().search(searchField.getText());
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
