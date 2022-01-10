package Model;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3862363247424524272L;
	protected String name;
	protected String surname;
	protected Date dateOfBirth;
	protected String eMail;
	protected String phoneNumber;
	protected Address address;
	
	public Person(String name, String surname, Date date, String eMail, String phone, Address addr) {
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = date;
		this.eMail = eMail;
		this.phoneNumber = phone;
		this.address = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}



