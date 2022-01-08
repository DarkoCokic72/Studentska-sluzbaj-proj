package Controller;

import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Model.Subject;
import Model.SubjectDatabase;
import gui.AddSubjectDialog;
import gui.EditSubjectInformationTab;



public class ValidationSubject {
	public static Boolean[] textFieldsFilled = new Boolean[4];
	private static ValidationSubject instanceSubjValid = null;
	
	private ValidationSubject() {
		Arrays.fill(textFieldsFilled, Boolean.FALSE);
	}
	
	
	public static boolean checkName(String name) {
		// https://stackoverflow.com/questions/15805555/java-regex-to-validate-full-name-allow-only-spaces-and-letters
		String nameRegex = "^[\\p{L} .'-]+[1-9]?$";
		boolean ret = Pattern.matches(nameRegex, name);
		
		if(ret == false && !name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Pogresan format imena predmeta!");
		}
		

		
		return ret;
	}
	
	public static boolean checkCode(String code) {
		String codeRegex = "^[A-Z]{1,2}[0-9]{2}[A-Z0-9]{1}$";
		// matches: E231, RI43A
		boolean ret = Pattern.matches(codeRegex, code);
		
		if(ret == false && !code.isEmpty())
			JOptionPane.showMessageDialog(null, "Pogresan format sifre predmeta!");
		
		for(Subject s: SubjectDatabase.getDatabase().getSubjects()) {
			if(s.getSubjectName().equalsIgnoreCase(code))
				JOptionPane.showMessageDialog(null, "Greska! Vec postoji predmet sa tom sifrom!");
				ret = false;
		}
		
		
		return ret;
	}
	
	public static boolean checkYearOfStudy(String year) {
		String yearRegex = "[1-4]";
		boolean ret = Pattern.matches(yearRegex, year);
		
		if(ret == false && !year.isEmpty())
			JOptionPane.showMessageDialog(null, "Pogresan format godine u kojoj se izvodi predmet!");
		
		return ret;
	} 
	
	public static boolean checkESPB(String espb) {
		String espbRegex = "[2-9]";
		boolean ret = Pattern.matches(espbRegex, espb);
		if(ret == false && !espb.isEmpty())
			JOptionPane.showMessageDialog(null, "Pogresan format ESPB bodova!");
		
		return ret;
	}
	
	
	public static boolean subjectValid() {
		for(Boolean t: textFieldsFilled) {
			if(!t)
				return false;
		}
		
		return true;
	}
	
	private static void fieldValidation(String input, int fieldNum) {
		if(!input.isEmpty()) {
			textFieldsFilled[fieldNum] = true;
		}
		else {
			textFieldsFilled[fieldNum] = false;
		}
	}
	
	public static boolean validateAdd(String input, int fieldNum) {
		fieldValidation(input, fieldNum);
		
		if(subjectValid()) {
			AddSubjectDialog.getConfirm().setEnabled(true);
		} else {
			AddSubjectDialog.getConfirm().setEnabled(false);

		}
		
		return subjectValid();
	}
	
	public static boolean validateEdit(String input, int fieldNum) {
		fieldValidation(input, fieldNum);
		
		if(subjectValid()) {
			EditSubjectInformationTab.getConfirm().setEnabled(true);
		} else {
			EditSubjectInformationTab.getConfirm().setEnabled(false);

		}
		
		return subjectValid();
	}
	

	public static void resetFields() {
		Arrays.fill(textFieldsFilled, Boolean.FALSE);
	}
	
	public static void fieldsFilled() {
		Arrays.fill(textFieldsFilled, Boolean.TRUE);
	}

	
	public static ValidationSubject getInstance() {
		if(instanceSubjValid == null)
			instanceSubjValid = new ValidationSubject();
		
		return instanceSubjValid;
	}
	
}
