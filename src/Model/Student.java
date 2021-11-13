package Model;

import java.util.ArrayList;
import java.util.Date;

enum Status {B, S};

public class Student extends Person{
	private String indexID;
	private int  yearOfEnroll;
	private int currYearOfStudies;
	private Status currStatus;
	private double avgMark;
	private ArrayList<Subject> passedCourses;
	private ArrayList<Subject> unpassedCourses;
	
	public Student(String name, String surname,Date date, String email, String phone, Address addr, String index, int yearEnr, int currYear, Status st) {
		super(name, surname, date, email, phone, addr);
		this.indexID = index;
		this.yearOfEnroll = yearEnr;
		this.currYearOfStudies = currYear;
		this.currStatus = st;
		passedCourses = new ArrayList<Subject>();
		unpassedCourses = new ArrayList<Subject>();
	}
	
	

}
