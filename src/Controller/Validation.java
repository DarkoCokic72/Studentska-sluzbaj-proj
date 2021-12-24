package Controller;

import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Model.Profesor;
import Model.ProfessorDatabase;
import gui.AddProfessorDialog;
import gui.EditProfessorInformationTab;

public class Validation {
	
	public static Boolean[] textFieldFilledProfessor = new Boolean[15];
	
	public static boolean checkName(String name) {
			
		boolean retVal = true;
		if (name.contains(" ")) {
				
			String[] nameParts = name.split(" ");
				
			for (String p : nameParts) {
					
				if (p.isEmpty())
					continue;
				retVal = Pattern.matches("\\p{L}+", p);
				if (retVal == false && !name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Format imena nije podrzan");
					return retVal;
				}
			}
		}else {
			retVal = Pattern.matches("\\p{L}+", name);

		}
		if (retVal == false && !name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Format imena nije podrzan");
		}
		return retVal;

	}
	
	
	public static boolean checkSurname(String surname) {
			
		boolean retVal = true;
		if (surname.contains("-")) {
			String[] parts = surname.split("-");
			for (String p : parts) {
				p = p.trim();
				retVal = Pattern.matches("\\p{L}+", p);
				if (retVal == false && !surname.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Neispravan format prezimena");
					return retVal;
				}
			}
		} else {
			retVal = Pattern.matches("\\p{L}+", surname);
		}
		if (retVal == false && !surname.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Neispravan format prezimena");
		}

		return retVal;
			
	}
	
	
	public static boolean checkDate(String date) {
		
		String regex = "[0-9]{1,2}.[0-9]{1,2}.[0-9]{4}.";
		boolean retVal = Pattern.matches(regex, date);
		
		if (retVal == false && date.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Format datuma nije podrzan.\nPodrzani formati su dd.mm.yyyy. ili d.m.yyyy.");
			return false;
		}
		
		Date datumRod = Converter.convertStringToDate(date);
		if (datumRod == null && date.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Format datuma nije podrzan.\nPodrzani formati su dd.mm.yyyy. ili d.m.yyyy.");
			return false;
		}
		
		return true;

	}
	
	public static boolean checkStreet(String street) {
		
		boolean retVal;
		String regex = "[\\p{L}\\s]+";
		retVal = Pattern.matches(regex, street);
		
		if (retVal == false && !street.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Pogresan format ulice.");
		}
		
		return retVal;
		
	}
	
	public static boolean checkStreetNumber(String streetNumber) {
		
		boolean retVal;
		String regex = "[0-9]+";
		retVal = Pattern.matches(regex, streetNumber);
		
		if (retVal == false && !streetNumber.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Pogresan format broja kuce.");
		}
		
		return retVal;
		
	}
	
	public static boolean checkCity(String city) {
		
		boolean retVal;
		String regex = "[\\p{L}\\s]+";
		retVal = Pattern.matches(regex, city);
		
		if (retVal == false && !city.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Pogresan format grada.");
		}
		
		return retVal;
		
	}
	
	public static boolean checkCountry(String country) {
		
		boolean retVal;
		String regex = "[\\p{L}\\s]+";
		retVal = Pattern.matches(regex, country);
		
		if (retVal == false && !country.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Pogresan format drzave.");
		}
		
		return retVal;
		
	}
	
	public static boolean checkPhoneNumber(String number) {
			
		boolean retVal;
		String regex = "\\+?[0-9][0-9/-]+";
		retVal = Pattern.matches(regex, number);
		if (retVal == false && !number.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Neispravan format broja telefona.");
		}
		return retVal;
			
	}
	

	
	public static boolean checkEmail(String email) {
		
		boolean retVal;
		String emailRegex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$"; //https://stackoverflow.com/questions/42266148/email-validation-regex-java
		retVal = Pattern.matches(emailRegex, email);
		
		if(retVal == false && email.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Neispravan format e-mail adrese.");
		}
		
		return retVal;
	}
	
	
	public static boolean checkPersonalId(String number) {
		
		boolean retVal = true;
		String regex = "[0-9]{9}";
		retVal = Pattern.matches(regex, number);
		
		if (retVal == false && !number.isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Neispravan format broja licne karte");
		}
	
	
		for (Profesor p : ProfessorDatabase.getDatabase().getProfessors()) {
			if (Integer.parseInt(number) == p.getPersonalID()) {
				
				JOptionPane.showMessageDialog(null, "Vec postoji profesor sa unetim brojem licne karte");	
				retVal = false;
				
			}
		}
		
		return retVal;
	}


	

	public static boolean checkYearsOfExp(String years) {
		
		boolean retVal;
		retVal = Pattern.matches("[1-9][0-9]?", years); 
		
		if (retVal == false && !years.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Uneli ste pogresan broj godina iskustva");
		}
		
		return retVal;
	}
	
	   
    public static void resetFieldsProfessor() {
    	Arrays.fill(textFieldFilledProfessor, Boolean.FALSE);
    }
    
    public static void fieldsFilledProfessor() {
    	Arrays.fill(textFieldFilledProfessor, Boolean.TRUE);
    }
        
    
    public static boolean validateAddProfessor(String input, int fieldNumber) {
        	
    	fieldValidationProfessor(input, fieldNumber);

    	if (professorValid()) {
    		AddProfessorDialog.getConfirm().setEnabled(true);
    	}
    	else {
    		AddProfessorDialog.getConfirm().setEnabled(false);
    	}

    	return professorValid();
    }
    
    public static boolean validateEditProfessor(String input, int fieldNumber) {
    	
    	fieldValidationProfessor(input, fieldNumber);

    	if (professorValid()) {
    		EditProfessorInformationTab.getConfirm().setEnabled(true);
    	}
    	else {
    		EditProfessorInformationTab.getConfirm().setEnabled(false);
    	}

    	return professorValid();
    }
        
    private static void fieldValidationProfessor(String input, int fieldNumber) {
    	
    		if(!input.isEmpty()) {
    			textFieldFilledProfessor[fieldNumber] = true;
    		}
    		else {
    			textFieldFilledProfessor[fieldNumber] = false;
    		}
    	
    }
        

    public static boolean professorValid() {

    	for (Boolean t : textFieldFilledProfessor) {
    		if (!t)
    			return false;
    	}

    	return true;
    }

   

}
