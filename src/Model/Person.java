package Model;

import java.util.Date;

public class Person {
	protected String name;
	protected String surname;
	protected Date dateOfBirth;
	protected String eMail;
	protected String phoneNumber;
	
	public Person(String name, String surname, Date date, String eMail, String phone) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = date;
		this.eMail = eMail;
		this.phoneNumber = phone;
	}

}
