package Model;

import java.sql.Date;
import java.util.ArrayList;

public class Profesor extends Person {
	
	private int ID;
	private String title;
	private int yearsOfExperience;
	private ArrayList<Subject> subjectsTeaches;
	private Address officeAdress;
	
	public Profesor(String name, String surname, Date date, String eMail, String phone, Address address, Address officeAddress, int ID, String title, int yearsOfExperience) {
		
		super(name, surname, date, eMail, phone, address);
		this.officeAdress = officeAddress;
		this.ID = ID;
		this.title = title;
		this.yearsOfExperience = yearsOfExperience;
		subjectsTeaches = new ArrayList<Subject>();
				
	}
	
	
}
