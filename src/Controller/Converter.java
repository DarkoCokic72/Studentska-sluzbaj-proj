package Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Model.Address;

public class Converter {
	
	public static Date convertStringToDate(String date) {
		
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date retDate = null;
		try {
			retDate = format.parse(date);
		} catch (Exception e) {
			retDate = null;
		}

		return retDate;
	}
	
	
	public static Address convertStringToAddress(String address) {
		
		Address retAddress;
		String output[] = address.split(",");
		String city = output[1];
		String country = output[2];
		
		String streetName = output[0].replaceAll("[0-9]+", "");
		int streetNumber = Integer.parseInt(output[0].replaceAll("[\\p{L}+\\s]", ""));
		
		retAddress = new Address(streetName, streetNumber, city, country);
		return retAddress;
		
	}
	

}
