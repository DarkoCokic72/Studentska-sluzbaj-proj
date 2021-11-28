package Model;

import java.sql.Date;
import java.util.ArrayList;

public class Profesor extends Person {
	
	private Address officeAddress;
	private int personalID;
	private String titula;
	private int yearsOfExperience;
	private ArrayList<Subject> subjectsTeaches;
	private String zvanje;
	
	public Profesor(String name, String surname, Date date, String eMail, String phone, Address address, Address officeAddress, int ID, String title, int yearsOfExperience, String zvanje) {
		
		super(name, surname, date, eMail, phone, address);
		this.officeAddress = officeAddress;
		this.personalID = ID;
		this.titula = title;
		this.yearsOfExperience = yearsOfExperience;
		subjectsTeaches = new ArrayList<Subject>();
		this.zvanje = zvanje;
				
	}
	
	public int getPersonalID() {
		return personalID;
	}
	
	public String getTitula() {
		return titula;
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
	
	public String getZvanje() {
		return zvanje;
	}
	
	
	
	public void setPersonalID(int ID) {
		this.personalID = ID;
	}
	
	public void setTitle(String title) {
		this.titula = title;
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
