package Controller;

import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Model.Student;
import Model.StudentDatabase;
import gui.AddStudentDialog;

public class ValidationStudent {
	
	public  static Boolean[] textFieldsFilled = new Boolean[8];
	private static ValidationStudent instanceStudValid = null;
	
	private ValidationStudent() {
		Arrays.fill(textFieldsFilled, Boolean.FALSE);
	}
	
	public static boolean checkName(String name) {
		boolean ret = true;
		if(name.contains(" ")) {
			//Example: Adama Dragana
			String[] nameParts = name.split(" ");
			
			for(String p: nameParts) {
				if(p.isEmpty()) 
					continue;
				ret = Pattern.matches("\\p{L}+", p);
				if(ret == false && !name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Greska: Format imena nije podrzan!");
					return ret;
				}
			}
		}else {
			ret = Pattern.matches("\\p{L}+", name);
		}
		
		if(ret == false && !name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Greska: Format imena nije podrzan!");
		}
		
		return ret;
	}
	
	public  static boolean checkSurname(String surname) {
		boolean ret = true;
		if(surname.contains("-")) {
			//Example: Medic-Glusac
			String[] surnameParts = surname.split("-");
			
			for(String p: surnameParts) {
				if(p.isEmpty()) 
					continue;
				ret = Pattern.matches("\\p{L}+", p);
				if(ret == false && !surname.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Greska: Format prezimena nije podrzan!");
					return ret;
				}
			}
		}else {
			ret = Pattern.matches("\\p{L}+", surname);
		}
		if(ret == false && !surname.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Greska: Format prezimena nije podrzan!");
		}
		
		return ret;
	}
	
	public static boolean checkDate(String date) {
		//Checked with https://regex101.com/
		String dateRegex = "^([1-9]|[12]{1}[0-9]|3{1}[01]{1}).([1-9]{1}|10{1}|11{1}|12{1}).((19|20)[0-9][0-9]).";
		boolean ret = Pattern.matches(dateRegex, date);
		
		if(ret == false && date.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Greska: Format datuma nije podrzan! Podrzani formati:"
					+ "d.m.yyyy. ili dd.mm.yyyy.");
			return false;
		}
		
		Date datOfBirth = Converter.convertStringToDate(date);
		if(datOfBirth == null && date.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Greska: Format datuma nije podrzan! Podrzani formati:"
					+ "d.m.yyyy. ili dd.mm.yyyy.");
			return false;
		}
		
		return true;
	}
	
	public static boolean checkAddress(String address) {
		boolean ret = true;
		String addressRegex = "[\\p{L}[0-9]\\s]+,[\\p{L}\\s]+,[\\p{L}\\s]+";
		ret = Pattern.matches(addressRegex, address);
		
		if(ret == false && address.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Greska: Pogresan format adrese. Adresa mora biti u formatu: ulica, broj, grad, drzava");
		}
		return ret;
	}
	
	public static boolean checkPhone(String phone) {
		String phoneNumRegex = "\\+?[0-9][0-9/-]+";
		boolean ret = Pattern.matches(phoneNumRegex, phone);
		
		if(ret == false && phone.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Greska: Format broja telefona nije podrzan!");
		}
		
		return ret;
	}
	
	public  static boolean checkEmail(String email) {
		String emailRegex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$"; //https://stackoverflow.com/questions/42266148/email-validation-regex-java
		boolean ret = Pattern.matches(emailRegex, email);
		
		if(ret == false && email.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Greska: Neispravan format e-mail adrese.");
		}
		
		return ret;
	}
	
	public static boolean checkIndex(String index) {
		String indexRegex = "^[a-z]{2}-([1-9]|[1-9]{1}[0-9]{1}|[12]{1}[0-9]{2})-((20)[0-9]{2})$";
		boolean ret = Pattern.matches(indexRegex, index);
		
		if(ret == false && index.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Greska: neispravan format broja indeksa");
		}
		
		for(Student s: StudentDatabase.getInstance().getStudents()) {
			if(index == s.getIndexID()) {
				JOptionPane.showMessageDialog(null, "Vec postoji student sa tim brojem indeksa!");
				ret = false;
			}
		}
		
		return ret;
	}
	
	public static boolean checkYearOfEnroll(String year) {
		String yearEnrRegex = "^(20)[0-9]{2}$";
		boolean ret = Pattern.matches(yearEnrRegex, year);
		
		if(ret == false && year.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Greska: Neispravna godina upisa. Proverite da li ste uneli nedozovoljene karaktere");
		}
		
		return ret;
	}
	
	public static boolean studentValid() {
		for(Boolean t: textFieldsFilled) {
			if(!t)
				return false;
		}
		
		return true;
	}
	
	private static void fieldValidation(String input, int fieldNum) {
		switch(fieldNum) {
		case 0:
			if(!input.isEmpty()) {
				textFieldsFilled[fieldNum] = true;
			} else {
				textFieldsFilled[fieldNum] = false;
			}
			break;
		case 1:
			if(!input.isEmpty()) {
				textFieldsFilled[fieldNum] = true;
			} else {
				textFieldsFilled[fieldNum] = false;
			}
			break;
		case 2:
			if(!input.isEmpty()) {
				textFieldsFilled[fieldNum] = true;
			} else {
				textFieldsFilled[fieldNum] = false;
			}
			break;
		case 3:
			if(!input.isEmpty()) {
				textFieldsFilled[fieldNum] = true;
			} else {
				textFieldsFilled[fieldNum] = false;
			}
			break;
		case 4:
			if(!input.isEmpty()) {
				textFieldsFilled[fieldNum] = true;
			} else {
				textFieldsFilled[fieldNum] = false;
			}
			break;
		case 5:
			if(!input.isEmpty()) {
				textFieldsFilled[fieldNum] = true;
			} else {
				textFieldsFilled[fieldNum] = false;
			}
			break;
		case 6:
			if(!input.isEmpty()) {
				textFieldsFilled[fieldNum] = true;
			} else {
				textFieldsFilled[fieldNum] = false;
			}
			break;
		case 7:
			if(!input.isEmpty()) {
				textFieldsFilled[fieldNum] = true;
			} else {
				textFieldsFilled[fieldNum] = false;
			}
			break;
		}
	}
	
	
	public static boolean validateAdd(String input, int fieldNum) {
		fieldValidation(input, fieldNum);
		
		if(studentValid()) {
			AddStudentDialog.getConfirm().setEnabled(true);
		} else {
			AddStudentDialog.getConfirm().setEnabled(false);

		}
		
		return studentValid();
	}
	
	
	public static void resetFields() {
		Arrays.fill(textFieldsFilled, Boolean.FALSE);
	}
	
	public void fieldsFilled() {
		Arrays.fill(textFieldsFilled, Boolean.TRUE);
	}
	
	public static ValidationStudent getInstance() {
		if(instanceStudValid == null) {
			instanceStudValid = new ValidationStudent();
		}
		
		return instanceStudValid;
	}
	
}