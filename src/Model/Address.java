package Model;
import jdk.jfr.Unsigned;

public class Address {
	
	protected String streetName;
	protected Unsigned streetNumber;
	protected String city;
	protected String country;
	
	public Address(	String streetName, Unsigned streetNumber, String city, String country) {

	    this.streetName = streetName;
	    this.streetNumber = streetNumber;
	    this.city = city;
	    this.country = country;
	    
	}
		
}




