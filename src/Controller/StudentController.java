package Controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Model.Address;
import Model.Student;
import Model.Student.Status;
import Model.StudentDatabase;
import gui.AddStudentDialog;
import gui.StudentTable;

public class StudentController {
	public static StudentController studContr = null;
	public boolean studentAdded = false;
	public boolean studentEdited = false;
	public Boolean[] textFieldsFilled = new Boolean[8];
	
	public void add() {
		String name = AddStudentDialog.getNameField().getText().trim();
		String surname = AddStudentDialog.getSurnameField().getText().trim();
		String dateStr = AddStudentDialog.getDateOfBirthField().getText().trim();
		String addressStr = AddStudentDialog.getAddressField().getText().trim();
		String phoneNum = AddStudentDialog.getPhoneNumberField().getText().trim();
		String email = AddStudentDialog.getEmailField().getText().trim();
		String index = AddStudentDialog.getIndexField().getText().trim();
		String yearOfEnroll = AddStudentDialog.getYearOfEnrollField().getText().trim();
		int currYearofStudies = AddStudentDialog.getCurrentYearOfStudies();
		Status status = AddStudentDialog.getStatus();
		
		if(checkFields(name, surname, dateStr, addressStr, phoneNum, email, index, yearOfEnroll) == true) {
			Date date = convertStringToDate(dateStr);
			Address adr = convertStringToAddress(addressStr);
			int yearEnr = Integer.parseInt(yearOfEnroll);
			
			Student student = new Student(name, surname, date, email, phoneNum, adr, index, yearEnr, currYearofStudies, status);
			StudentDatabase studDatabase = StudentDatabase.getInstance();
			studDatabase.addStudentsIntoTable(student);
			StudentTable studTable = StudentTable.getTable();
			studTable.updateTable();
			studentAdded = true;
		}
		
	}
	
	public Date convertStringToDate(String date) {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date retDate = null;
		try {
			retDate = format.parse(date);
		} catch(Exception e) {
			retDate = null;
		}
		
		return retDate;
	}
	
	public boolean checkName(String name) {
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
	
	public boolean checkSurname(String surname) {
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
	
	public boolean checkDate(String date) {
		//Checked with https://regex101.com/
		String dateRegex = "^([1-9]|[12]{1}[0-9]|3{1}[01]{1}).([1-9]{1}|10{1}|11{1}|12{1}).((19|20)[0-9][0-9]).";
		boolean ret = Pattern.matches(dateRegex, date);
		
		if(ret == false && date.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Greska: Format datuma nije podrzan! Podrzani formati:"
					+ "d.m.yyyy. ili dd.mm.yyyy.");
			return false;
		}
		
		Date datOfBirth = convertStringToDate(date);
		if(datOfBirth == null && date.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Greska: Format datuma nije podrzan! Podrzani formati:"
					+ "d.m.yyyy. ili dd.mm.yyyy.");
			return false;
		}
		
		return true;
	}
	
	public boolean checkAddress(String address) {
		boolean ret = true;
		String addressRegex = "[\\p{L}[0-9]\\s]+,[\\p{L}\\s]+,[\\p{L}\\s]+";
		ret = Pattern.matches(addressRegex, address);
		
		if(ret == false && address.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Greska: Pogresan format adrese. Adresa mora biti u formatu: ulica, broj, grad, drzava");
		}
		return ret;
	}
	
	public Address convertStringToAddress(String address) {
		Address retValAdr;
		String[] output = address.split(",");
		String city = output[1];
		String country = output[2];
		
		String streetName = output[0].replaceAll("[0-9]", "");
		int streetNumber = Integer.parseInt(output[0].replaceAll("[\\p{L}+\\s]", ""));
		
		retValAdr = new Address(streetName, streetNumber, city, country);
		
		return retValAdr;
	}
	
	public boolean checkPhone(String phone) {
		String phoneNumRegex = "\\+?[0-9][0-9/-]+";
		boolean ret = Pattern.matches(phoneNumRegex, phone);
		
		if(ret == false && phone.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Greska: Format broja telefona nije podrzan!");
		}
		
		return ret;
	}
	
	public boolean checkEmail(String email) {
		String emailRegex = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}.[a-z]{2,}$";
		boolean ret = Pattern.matches(emailRegex, email);
		
		if(ret == false && email.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Greska: Neispravan format e-mail adrese.");
		}
		
		return ret;
	}
	
	public boolean checkIndex(String index) {
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
	
	public boolean checkYearOfEnroll(String year) {
		String yearEnrRegex = "^(20)[0-9]{2}$";
		boolean ret = Pattern.matches(yearEnrRegex, year);
		
		if(ret == false && year.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Greska: Neispravna godina upisa. Proverite da li ste uneli nedozovoljene karaktere");
		}
		
		return ret;
	}
	
	public boolean checkFields(String name, String surname, String date, String address, String phone, String email, String index, String year) {
		boolean ret;
		if(checkName(name) == true && checkSurname(surname) == true && checkDate(date) == true && checkAddress(address) == true 
		&& checkPhone(phone) == true && checkEmail(email) == true && checkIndex(index) == true && checkYearOfEnroll(year) == true) {
			ret = true;
		} else {
			ret = false;
		}
		
		return ret;
	}
	
	public boolean studentValid() {
		for(Boolean t: textFieldsFilled) {
			if(!t)
				return false;
		}
		
		return true;
	}
	
	private void fieldValidation(String input, int fieldNum) {
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
	
	public void resetFields() {
		Arrays.fill(textFieldsFilled, Boolean.FALSE);
	}
	
	public void fieldsFilled() {
		Arrays.fill(textFieldsFilled, Boolean.TRUE);
	}
	
	public boolean validateAdd(String input, int fieldNum) {
		fieldValidation(input, fieldNum);
		
		if(studentValid()) {
			AddStudentDialog.getConfirm().setEnabled(true);
		} else {
			AddStudentDialog.getConfirm().setEnabled(false);

		}
		
		return studentValid();
	}
	
	public static StudentController getStudentConstroler() {
		if(studContr == null) {
			studContr = new StudentController();
		}
		
		return studContr;
	}
	
	
}
