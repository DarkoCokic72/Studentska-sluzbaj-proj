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
			Date date = Converter.convertStringToDate(dateStr);
			Address adr = Converter.convertStringToAddress(addressStr);
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
	
	public boolean checkFields(String name, String surname, String date, String address, String phone, String email, String index, String year) {
		boolean ret;
		if(ValidationStudent.checkName(name) == true && ValidationStudent.checkSurname(surname) == true && ValidationStudent.checkDate(date) == true
		&& ValidationStudent.checkAddress(address) == true && ValidationStudent.checkPhone(phone) == true && ValidationStudent.checkEmail(email) == true 
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
	
	
}
