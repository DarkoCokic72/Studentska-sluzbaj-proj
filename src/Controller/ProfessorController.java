package Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import Model.Address;
import Model.Profesor;
import Model.Profesor.Titula;
import Model.Profesor.Zvanje;
import Model.ProfessorDatabase;
import gui.AddProfessorDialog;
import gui.EditProfessorInformationTab;
import gui.ProfessorJTable;

public class ProfessorController {

		private static ProfessorController professorContr = null;
		public boolean professorAdded = false;
		public boolean professorEdited = false;
		public Boolean[] textFieldFilled = new Boolean[9];
		
		public void add() {
			
			String name = AddProfessorDialog.getNameField().getText().trim();
			String surname = AddProfessorDialog.getSurnameField().getText().trim();
			String dateString = AddProfessorDialog.getDateOfBirth().getText().trim(); //convert to Date
			String addressString = AddProfessorDialog.getAddress().getText().trim(); //convert to Address 
			String phoneNumber = AddProfessorDialog.getMobile().getText().trim(); 
			String email = AddProfessorDialog.getMailField().getText().trim();
			String officeAddressString = AddProfessorDialog.getOfficeAddressField().getText().trim(); //convert to Address
			String personalIdString = AddProfessorDialog.getPersonalId().getText().trim(); //convert to int
			Titula titula = AddProfessorDialog.getTitula();
			Zvanje zvanje = AddProfessorDialog.getZvanje();
			String yearsOfExperienceString = AddProfessorDialog.getYearsOfExpirienceField().getText().trim(); //convert to int
				
			if(checkName(name) == true && checkSurname(surname) == true && checkDate(dateString) == true && checkAddress(addressString) == true
				&& checkPhoneNumber(phoneNumber) == true && checkMail(email) == true && checkAddress(officeAddressString) 
				&& checkPersonalId(personalIdString) == true && checkYearsOfExp(yearsOfExperienceString) == true) {
			
				Date date = convertStringToDate(dateString);
				Address address = convertStringToAddress(addressString);
				Address officeAddress = convertStringToAddress(officeAddressString);
				int personalId = Integer.parseInt(personalIdString);
				int yearsOfExperience = Integer.parseInt(yearsOfExperienceString);
				
				Profesor professor = new Profesor(name, surname, date, email, phoneNumber, address, 
			    		                          officeAddress, personalId, titula, yearsOfExperience, zvanje);
			     
				ProfessorDatabase professorDatabase = ProfessorDatabase.getDatabase();
				professorDatabase.addProfessorToTable(professor);
				ProfessorJTable professorTable = ProfessorJTable.getTable();
				professorTable.updateTable();
				professorAdded = true;
			
			}
			
		}
		
		
		public void edit(Profesor professor) {
			
			String name = EditProfessorInformationTab.getNameField().getText().trim();
			String surname = EditProfessorInformationTab.getSurnameField().getText().trim();
			String dateString = EditProfessorInformationTab.getDateOfBirth().getText().trim(); //convert to Date
			String addressString = EditProfessorInformationTab.getAddress().getText().trim(); //convert to Address 
			String phoneNumber = EditProfessorInformationTab.getMobile().getText().trim(); 
			String email = EditProfessorInformationTab.getMailField().getText().trim();
			String officeAddressString = EditProfessorInformationTab.getOfficeAddressField().getText().trim(); //convert to Address
			String personalIdString = EditProfessorInformationTab.getPersonalId().getText().trim(); //convert to int
			Titula titula = EditProfessorInformationTab.getTitula();
			Zvanje zvanje = EditProfessorInformationTab.getZvanje();
			String yearsOfExperienceString = EditProfessorInformationTab.getYearsOfExpirienceField().getText().trim(); //convert to int
				
			if(checkName(name) == true && checkSurname(surname) == true && checkDate(dateString) == true && checkAddress(addressString) == true
				&& checkPhoneNumber(phoneNumber) == true && checkMail(email) == true && checkAddress(officeAddressString) 
				&& checkPersonalId(personalIdString) == true && checkYearsOfExp(yearsOfExperienceString) == true) {
			
				Date date = convertStringToDate(dateString);
				Address address = convertStringToAddress(addressString);
				Address officeAddress = convertStringToAddress(officeAddressString);
				int personalId = Integer.parseInt(personalIdString);
				int yearsOfExperience = Integer.parseInt(yearsOfExperienceString);
				
				professor.setName(name);
				professor.setSurname(surname);
				professor.setDateOfBirth(date);
				professor.setAddress(address);
				professor.setPhoneNumber(phoneNumber);
				professor.seteMail(email);
				professor.setOfficeAddress(officeAddress);
				professor.setPersonalID(personalId);
				professor.setTitle(titula);
				professor.setZvanje(zvanje);
				professor.setTitle(titula);
				professor.setYearsOfExperience(yearsOfExperience);
				
				ProfessorJTable professorTable = ProfessorJTable.getTable();
				professorTable.updateTable();
				professorEdited = true;
			
			}
			
		}
		
		public void delete(Profesor professor) {
			
			int id = professor.getPersonalID();
			ArrayList<Profesor> professorList = ProfessorDatabase.getDatabase().getProfessors();
			int i = 0;
			
			for(Profesor p: professorList) {
				if(p.getPersonalID() == id) {
					professorList.remove(i);
					break;
				}
				i++;
			}
			
			ProfessorJTable professorTable = ProfessorJTable.getTable();
			professorTable.updateTable();
					
		}
		
			
		public Date convertStringToDate(String date) {
				
			DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			Date retDate = null;
			try {
				retDate = format.parse(date);
			} catch (Exception e) {
				retDate = null;
			}

			return retDate;
		}
			
			
		public Address convertStringToAddress(String address) {
				
			Address retAddress;
			String output[] = address.split(",");
			String city = output[1];
			String country = output[2];
				
			String streetName = output[0].replaceAll("[0-9]+", "");
			int streetNumber = Integer.parseInt(output[0].replaceAll("[\\p{L}+\\s]", ""));
				
			retAddress = new Address(streetName, streetNumber, city, country);
			return retAddress;
				
		}
			
			
			
		public boolean checkName(String name) {
				
			boolean ret = true;
			if (name.contains(" ")) {
					
				String[] nameParts = name.split(" ");
					
				for (String p : nameParts) {
						
					if (p.isEmpty())
						continue;
					ret = Pattern.matches("\\p{L}+", p);
					if (ret == false && !name.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Format imena nije podrzan");
						return ret;
					}
				}
			} else {
				ret = Pattern.matches("\\p{L}+", name);

			}
			if (ret == false && !name.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Format imena nije podrzan");
			}
			return ret;

		}
					
			
		public boolean checkSurname(String surname) {
				
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
			
			
		public boolean checkDate(String date) {
				
			String regex = "[0-9]{1,2}.[0-9]{1,2}.[0-9]{4}.";
			boolean retVal = Pattern.matches(regex, date);
				
			if (retVal == false && date.isEmpty() == false) {
				JOptionPane.showMessageDialog(null, "Format datuma nije podrzan.\nPodrzani formati su dd.mm.yyyy. ili d.m.yyyy.");
				return false;
			}
				
			Date datumRod = convertStringToDate(date);
			if (datumRod == null && date.isEmpty() == false) {
				JOptionPane.showMessageDialog(null, "Format datuma nije podrzan.\nPodrzani formati su dd.mm.yyyy. ili d.m.yyyy.");
				return false;
			}
				
			return true;
		
		}
			
		public boolean checkAddress(String address) {
				
			boolean ret = true;
			String regex = "[\\p{L}0-9\\s]+,[\\p{L}\\s]+,[\\p{L}\\s]+";
			ret = Pattern.matches(regex, address);
			if (ret == false && !address.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Pogresan format adrese.\nAdresa mora biti u formatu ulica broj, grad, drzava.");
			}
			return ret;
				
		}
			
		public boolean checkPhoneNumber(String number) {
				
			boolean retVal = true;
			String regex = "\\+?[0-9][0-9/-]+";
			retVal = Pattern.matches(regex, number);
			if (retVal == false && !number.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Neispravan format broja telefona.");
			}
			return retVal;
				
		}
			
		public boolean checkMail(String mail) {
				
			boolean retVal = true;
			retVal = Pattern.matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}.[a-z]{2,}$", mail); 
			if (retVal == false && !mail.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Neispravan format E-mail adrese");
			}
				
			return retVal;
		}
			
			
		public boolean checkPersonalId(String number) {
				
			boolean retVal = true;
			String regex = "^[0-9]*$";
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
		
		
			
		
		public boolean checkYearsOfExp(String years) {
				
			boolean ret = true;
			ret = Pattern.matches("[1-9][0-9]?", years); 
			if (ret == false && !years.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Uneli ste pogresan broj godina iskustva");
			}
				
			return ret;
		}
	       
	   
	    public void resetFields() {
	    	Arrays.fill(textFieldFilled, Boolean.FALSE);
	    }
	    
	    public void fieldsFilled() {
	    	Arrays.fill(textFieldFilled, Boolean.TRUE);
	    }
	        
	    
	    public boolean validateAdd(String input, int fieldNumber) {
	        	
	    	fieldValidation(input, fieldNumber);

	    	if (professorValid()) {
	    		AddProfessorDialog.getConfirm().setEnabled(true);
	    	}
	    	else {
	    		AddProfessorDialog.getConfirm().setEnabled(false);
	    	}

	    	return professorValid();
	    }
	    
	    public boolean validateEdit(String input, int fieldNumber) {
        	
	    	fieldValidation(input, fieldNumber);

	    	if (professorValid()) {
	    		EditProfessorInformationTab.getConfirm().setEnabled(true);
	    	}
	    	else {
	    		EditProfessorInformationTab.getConfirm().setEnabled(false);
	    	}

	    	return professorValid();
	    }
	        
	    private void fieldValidation(String input, int fieldNumber) {
	    	
	    	switch (fieldNumber) {
	    	case 0:
	    		if(!input.isEmpty()) {
	    			textFieldFilled[fieldNumber] = true;
	    		}
	    		else {
	    			textFieldFilled[fieldNumber] = false;
	    		}
	    		break;
	    	case 1:
	    		if(!input.isEmpty()) {
	    			textFieldFilled[fieldNumber] = true;
	    		}
	    		else {
	    			textFieldFilled[fieldNumber] = false;
	    		}
	    		break;
	    	case 2:
	    		if(!input.isEmpty()) {
	    			textFieldFilled[fieldNumber] = true;
	    		}
	    		else {
	    			textFieldFilled[fieldNumber] = false;
	    		}
	    		break;
	    	case 3:
	    		if(!input.isEmpty()) {
	    			textFieldFilled[fieldNumber] = true;
	    		}
	    		else {
	    			textFieldFilled[fieldNumber] = false;
	    		}
	    		break;
	    	case 4:
	    		if(!input.isEmpty()) {
	    			textFieldFilled[fieldNumber] = true;
	    		}
	    		else {
	    			textFieldFilled[fieldNumber] = false;
	    		}
	    		break;
	    	case 5:
	    		if(!input.isEmpty()) {
	    			textFieldFilled[fieldNumber] = true;
	    		}
	    		else {
	    			textFieldFilled[fieldNumber] = false;
	    		}
	    		break;
	    	case 6:
	    		if(!input.isEmpty()) {
	    			textFieldFilled[fieldNumber] = true;
	    		}
	    		else {
	    			textFieldFilled[fieldNumber] = false;
	    		}
	    		break;
	    	case 7:
	    		if(!input.isEmpty()) {
	    			textFieldFilled[fieldNumber] = true;
	    		}
	    		else {
	    			textFieldFilled[fieldNumber] = false;
	    		}
	    		break;
	    	case 8:
	    		if(!input.isEmpty()) {
	    			textFieldFilled[fieldNumber] = true;
	    		}
	    		else {
	    			textFieldFilled[fieldNumber] = false;
	    		}
	    		break;
	    	}
	    }
	        

	    public boolean professorValid() {

	    	for (Boolean t : textFieldFilled) {
	    		if (!t)
	    			return false;
	    	}

	    	return true;
	    }

	    public static ProfessorController getProfessorController() {
	    		
	    	if (professorContr == null) {
	    		professorContr = new ProfessorController();
	    	}
	    	return professorContr;
	    }
	        
			
			
	
}
