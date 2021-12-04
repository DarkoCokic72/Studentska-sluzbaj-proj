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
	
	public static Boolean[] textFieldFilledProfessor = new Boolean[9];
	
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
	
	public static boolean checkAddress(String address) {
		
		boolean retVal = true;
		String regex = "[\\p{L}0-9\\s]+,[\\p{L}\\s]+,[\\p{L}\\s]+";
		retVal = Pattern.matches(regex, address);
		if (retVal == false && !address.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Pogresan format adrese.\nAdresa mora biti u formatu ulica broj, grad, drzava.");
		}
		return retVal;
			
	}
	
	
	public static boolean checkPhoneNumber(String number) {
			
		boolean retVal = true;
		String regex = "\\+?[0-9][0-9/-]+";
		retVal = Pattern.matches(regex, number);
		if (retVal == false && !number.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Neispravan format broja telefona.");
		}
		return retVal;
			
	}
	

	
	public static boolean checkMail(String mail) {
		
		boolean retVal = true;
		retVal = Pattern.matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}.[a-z]{2,}$", mail); 
		if (retVal == false && !mail.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Neispravan format E-mail adrese");
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
		
		boolean ret = true;
		ret = Pattern.matches("[1-9][0-9]?", years); 
		if (ret == false && !years.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Uneli ste pogresan broj godina iskustva");
		}
		
		return ret;
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
