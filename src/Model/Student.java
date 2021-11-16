package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.ListIterator;

enum Status {B, S};

public class Student extends Person{
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

	public int getCurrYearOfStudies() {
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

	public double getAvgMark() {
		return avgMark;
	}

	public void setAvgMark() {
		ListIterator<Grade> it = passedCourses.listIterator();
		int sum = 0;
		int size = 0;
		while(it.hasNext()) {
			Grade g = it.next();
			sum += g.getMark();
			size++;
		}
		
		this.avgMark = sum/size;
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
