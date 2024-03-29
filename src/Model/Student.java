package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;



public class Student extends Person implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -659548332584837119L;

//<<<<<<< HEAD
//	public enum StudentStatus {B, S};
//=======
	public enum Status {B, S};
//>>>>>>> addStudent
	
	private String indexID;
	private int  yearOfEnroll;
	private int currYearOfStudies;
	private Status currStatus;
	private double avgMark;
	private ArrayList<Grade> passedCourses;
	private ArrayList<Subject> unpassedCourses;
	
	public Student(String name, String surname,Date date, String email, String phone, Address addr, String index, int yearEnr, int currYear, Status st) {
		super(name, surname, date, email, phone, addr);
		this.indexID = index;
		this.yearOfEnroll = yearEnr;
		this.currYearOfStudies = currYear;
		this.currStatus = st;
		passedCourses = new ArrayList<Grade>();
		unpassedCourses = new ArrayList<Subject>();
	}
	
	public Student(Student student) {
		super(student.name, student.surname, student.dateOfBirth, student.eMail, student.phoneNumber, student.address);
		this.indexID = student.indexID;
		this.yearOfEnroll = student.yearOfEnroll;
		this.currYearOfStudies = student.currYearOfStudies;
		this.currStatus = student.currStatus;
		this.passedCourses = student.passedCourses;
		this.unpassedCourses = student.unpassedCourses;
	
	}

	public String getIndexID() {
		return indexID;
	}

	public void setIndexID(String indexID) {
		this.indexID = indexID;
	}

	public int getYearOfEnroll() {
		return yearOfEnroll;
	}

	public void setYearOfEnroll(int yearOfEnroll) {
		this.yearOfEnroll = yearOfEnroll;
	}

	public Integer getCurrYearOfStudies() {
		return currYearOfStudies;
	}

	public void setCurrYearOfStudies(int currYearOfStudies) {
		this.currYearOfStudies = currYearOfStudies;
	}

	public Status getCurrStatus() {
		return currStatus;
	}

	public void setCurrStatus(Status currStatus) {
		this.currStatus = currStatus;
	}

	public Double getAvgMark() {
		return avgMark;
	}

	public void setAvgMark() {
		
		if(!passedCourses.isEmpty()) {
			ListIterator<Grade> it = passedCourses.listIterator();
			double sum = 0;
			double size = 0;
			while(it.hasNext()) {
				Grade g = it.next();
				sum += g.getMark();
				size++;
			}
			
		this.avgMark = sum/size;
		} else {
			this.avgMark = 0;
		}
	}

	public ArrayList<Grade> getPassedCourses() {
		return passedCourses;
	}

	public void setPassedCourses(ArrayList<Grade> passedCourses) {
		this.passedCourses = passedCourses;
	}

	public ArrayList<Subject> getUnpassedCourses() {
		return unpassedCourses;
	}

	public void setUnpassedCourses(ArrayList<Subject> unpassedCourses) {
		this.unpassedCourses = unpassedCourses;
	}
	
	
	
	

}
