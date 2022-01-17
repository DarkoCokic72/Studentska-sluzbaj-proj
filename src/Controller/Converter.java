package Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import gui.MainFrame;

public class Converter {
	
	public static Date convertStringToDate(String date) {
		
		DateFormat format;
		if(MainFrame.languageChanged) {
			format = DateFormat.getDateInstance();
		} else {
			format = new SimpleDateFormat("dd.MM.yyyy");
		}
		Date retDate = null;
		try {
			retDate = format.parse(date);
		} catch (Exception e) {
			retDate = null;
		}

		return retDate;
	}
}
