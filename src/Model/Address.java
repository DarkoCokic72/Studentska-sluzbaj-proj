package Model;

import java.io.Serializable;

public class Address implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4972005054683916373L;
	protected String streetName;
	protected String streetNumber;
	protected String city;
	protected String country;
	
	public Address(String streetName, String streetNumber, String city, String country) {

	    this.streetName = streetName;
	    this.streetNumber = streetNumber;
	    this.city = city;
	    this.country = country;
	    
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public String getStreetNumber() {
		return streetNumber;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getCountry() {
		return country;
	}
	
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	
		
}




