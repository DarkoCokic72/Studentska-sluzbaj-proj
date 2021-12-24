package Controller;

import java.util.ArrayList;
import java.util.Date;

import Model.Address;
import Model.Student;
import Model.Student.Status;
import Model.StudentDatabase;
import gui.AddProfessorDialog;
import gui.AddStudentDialog;
import gui.EditStudentInformationTab;
import gui.StudentTable;

public class StudentController {
	public static StudentController studContr = null;
	public boolean studentAdded = false;
	public boolean studentEdited = false;

	
	public void add() {
		String name = AddStudentDialog.getNameField().getText().trim();
		String surname = AddStudentDialog.getSurnameField().getText().trim();
		String dateStr = AddStudentDialog.getDateOfBirthField().getText().trim();
		
		String street = AddStudentDialog.getStreetField().getText().trim(); 
		String streetNumberString = AddStudentDialog.getStreetNumberField().getText().trim(); //convert to int
		String city = AddStudentDialog.getCityField().getText().trim();
		String country = AddStudentDialog.getCountryField().getText().trim();
		
		String phoneNum = AddStudentDialog.getPhoneNumberField().getText().trim();
		String email = AddStudentDialog.getEmailField().getText().trim();
		String index = AddStudentDialog.getIndexField().getText().trim();
		String yearOfEnroll = AddStudentDialog.getYearOfEnrollField().getText().trim();
		int currYearofStudies = AddStudentDialog.getCurrentYearOfStudies();
		Status status = AddStudentDialog.getStatus();

		//street, streetNumberString, city, country
		if(checkFields(name, surname, dateStr, street, streetNumberString, city, country, phoneNum, email, index, yearOfEnroll) == true) {
			Date date = Converter.convertStringToDate(dateStr);
			int streetNumber = Integer.parseInt(streetNumberString);
			Address adr = new Address(street, streetNumber, city, country); 
			
			int yearEnr = Integer.parseInt(yearOfEnroll);
			
			Student student = new Student(name, surname, date, email, phoneNum, adr, index, yearEnr, currYearofStudies, status);
			student.setAvgMark();
			StudentDatabase studDatabase = StudentDatabase.getInstance();
			studDatabase.addStudentsIntoTable(student);
			StudentTable studTable = StudentTable.getTable();
			studTable.updateTable();
			studentAdded = true;
		}
		
	}
	

	public boolean checkFields(String name, String surname, String date, String street, String streetNum, String city, String country, String phone, String email, String index, String year) {
		boolean ret;
		if(ValidationStudent.checkName(name) == true && ValidationStudent.checkSurname(surname) == true && ValidationStudent.checkDate(date) == true
				&& ValidationStudent.checkStreet(street) == true && ValidationStudent.checkStreetNumber(streetNum) == true && ValidationStudent.checkCity(city) == true 
				&& ValidationStudent.checkCountry(country) == true && ValidationStudent.checkPhone(phone) == true && ValidationStudent.checkEmail(email) == true 
				&& ValidationStudent.checkIndex(index) == true && ValidationStudent.checkYearOfEnroll(year) == true) {
			ret = true;
		} else {
			ret = false;
		}
		
		return ret;
	}
	
	public static StudentController getStudentConstroler() {
		if(studContr == null) {
			studContr = new StudentController();
		}
		
		return studContr;
	}

	public void delete(Student student) {
		// TODO Auto-generated method stub
		String index = student.getIndexID();
		ArrayList<Student> studentList = StudentDatabase.getInstance().getStudents();
		
		int i = 0;
		for(Student s: studentList) {
			if(index == s.getIndexID()) {
				studentList.remove(i);
				break;
			}
			i++;
		}
		
		StudentTable studTable = StudentTable.getTable();
		studTable.updateTable();
	}

	public void edit(Student student) {
		// TODO Auto-generated method stub
		
		String name = EditStudentInformationTab.getNameField().getText().trim();
		String surname = EditStudentInformationTab.getSurnameField().getText().trim();
		String dateStr = EditStudentInformationTab.getDateOfBirthField().getText().trim();
		
		String street = EditStudentInformationTab.getStreetField().getText().trim(); 
		String streetNumberString = EditStudentInformationTab.getStreetNumberField().getText().trim(); //convert to int
		String city = EditStudentInformationTab.getCityField().getText().trim();
		String country = EditStudentInformationTab.getCountryField().getText().trim();
		
		String phoneNum = EditStudentInformationTab.getPhoneNumberField().getText().trim();
		String email = EditStudentInformationTab.getEmailField().getText().trim();
		
		String yearOfEnroll = EditStudentInformationTab.getYearOfEnrollField().getText().trim();
		int currYearofStudies = EditStudentInformationTab.getCurrentYearOfStudies();
		Status status = EditStudentInformationTab.getStatus();
		
		
		// ValidationStudent.
		if(ValidationStudent.checkName(name) == true && ValidationStudent.checkSurname(surname) == true && ValidationStudent.checkDate(dateStr) == true
			&& ValidationStudent.checkStreet(street) == true && ValidationStudent.checkStreetNumber(streetNumberString) == true && ValidationStudent.checkCity(city) == true 
			&& ValidationStudent.checkCountry(country)==true && ValidationStudent.checkPhone(phoneNum) == true && ValidationStudent.checkEmail(email) == true 
			&& ValidationStudent.checkYearOfEnroll(yearOfEnroll) == true)  {
			
			String index = EditStudentInformationTab.getIndexField().getText().trim();
			String wrongIndex = EditStudentInformationTab.getIndexField().getText().trim();
			
			if(ValidationStudent.checkIndex(wrongIndex)) {
				Date date = Converter.convertStringToDate(dateStr);
				int streetNumber = Integer.parseInt(streetNumberString);
				Address adr = new Address(street, streetNumber, city, country); 
				int yearEnr = Integer.parseInt(yearOfEnroll);
				
				student.setName(name);
				student.setSurname(surname);
				student.setDateOfBirth(date);
				student.setAddress(adr);
				student.setPhoneNumber(phoneNum);
				student.seteMail(email);
				student.setYearOfEnroll(yearEnr);
				student.setCurrStatus(status);
				student.setCurrYearOfStudies(currYearofStudies);
				student.setIndexID(index);
				
				StudentTable studentTable = StudentTable.getTable();
				studentTable.updateTable();
				studentEdited = true;
				
			} else {
				student.setIndexID(index);
			}
		}
		
	}
	
	
}
