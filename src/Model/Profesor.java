package Model;

import java.util.Date;
import java.util.ArrayList;


public class Profesor extends Person {
	
	public enum Titula {BSC, MSC, MR, DR, PROF}
	public enum Zvanje{SARADNIK_U_NASTAVI, ASISTENT, DOCENT, REDOVNI_PROFESOR, VANREDNI_PROFESOR, EMERITUS}
	
	private Address officeAddress;
	private int personalID;
	private Titula titula;
	private int yearsOfExperience;
	private ArrayList<Subject> subjectsTeaches;
	private Zvanje zvanje;
	
	public Profesor(String name, String surname, Date dateOfBirth, String eMail, String mobilePhone, Address address, Address officeAddress, int ID, Titula titula, int yearsOfExperience, Zvanje zvanje) {
		
		super(name, surname, dateOfBirth, eMail, mobilePhone, address);
		this.officeAddress = officeAddress;
		this.personalID = ID;
		this.titula = titula;
		this.yearsOfExperience = yearsOfExperience;
		subjectsTeaches = new ArrayList<Subject>();
		this.zvanje = zvanje;
				
	}
	
	public int getPersonalID() {
		return personalID;
	}
	
	public Titula getTitula() {
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
	
	public Zvanje getZvanje() {
		return zvanje;
	}
	
	
	
	public void setPersonalID(int ID) {
		this.personalID = ID;
	}
	
	public void setTitle(Titula titula) {
		this.titula = titula;
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
