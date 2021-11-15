package Model;

import java.sql.Date;
import java.util.ArrayList;

public class Profesor extends Person {
	
	private Address officeAddress;
	private int personalID;
	private String title;
	private int yearsOfExperience;
	private ArrayList<Subject> subjectsTeaches;
	
	public Profesor(String name, String surname, Date date, String eMail, String phone, Address address, Address officeAddress, int ID, String title, int yearsOfExperience) {
		
		super(name, surname, date, eMail, phone, address);
		this.officeAddress = officeAddress;
		this.personalID = ID;
		this.title = title;
		this.yearsOfExperience = yearsOfExperience;
		subjectsTeaches = new ArrayList<Subject>();
				
	}
	
	public int getPersonalID() {
		return personalID;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}
	
	public ArrayList<Subject> getSubjectsTeaches(){
		return subjectsTeaches;
	}
	
	public Address getOfficeAdress() {
		return officeAddress;
	}
	
	
	
	public void setPersonalID(int ID) {
		this.personalID = ID;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setYearsOfExperience(int years) {
		this.yearsOfExperience = years;
	}
	
	public void setSubjectsTeaches(ArrayList<Subject> subjects) {
		this.subjectsTeaches = subjects;
	}
	
	public void setOfficeAddress(Address addr) {
		this.officeAddress = addr;
	}
	
	
	
}
