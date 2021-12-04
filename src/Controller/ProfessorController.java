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
				
			if(Validation.checkName(name) == true && Validation.checkSurname(surname) == true && Validation.checkDate(dateString) == true && Validation.checkAddress(addressString) == true
				&& Validation.checkPhoneNumber(phoneNumber) == true && Validation.checkMail(email) == true && Validation.checkAddress(officeAddressString) 
				&& Validation.checkPersonalId(personalIdString) == true && Validation.checkYearsOfExp(yearsOfExperienceString) == true) {
			
				Date date = Converter.convertStringToDate(dateString);
				Address address = Converter.convertStringToAddress(addressString);
				Address officeAddress = Converter.convertStringToAddress(officeAddressString);
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
			Titula titula = EditProfessorInformationTab.getTitula();
			Zvanje zvanje = EditProfessorInformationTab.getZvanje();
			String yearsOfExperienceString = EditProfessorInformationTab.getYearsOfExpirienceField().getText().trim(); //convert to int
				
			if(Validation.checkName(name) == true && Validation.checkSurname(surname) == true && Validation.checkDate(dateString) == true && Validation.checkAddress(addressString) == true
				&& Validation.checkPhoneNumber(phoneNumber) == true && Validation.checkMail(email) == true && Validation.checkAddress(officeAddressString) 
				&& Validation.checkYearsOfExp(yearsOfExperienceString) == true) {
				
				
				String personalIdString = EditProfessorInformationTab.getPersonalId().getText().trim(); //convert to int
				professor.setPersonalID(-1);	 			//postavljamo personalID na -1 kako bismo mogli da ga ne promenimo prilikom editovanja, 
															//a da nam pri tome ne iskoci greska da vec postoji profesor sa identicnim ID
				String personalIdStringWrong = EditProfessorInformationTab.getPersonalId().getText().trim();
				
				if(Validation.checkPersonalId(personalIdStringWrong)) {
			
					Date date = Converter.convertStringToDate(dateString);
					Address address = Converter.convertStringToAddress(addressString);
					Address officeAddress = Converter.convertStringToAddress(officeAddressString);
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
				
				else {
					
					int personalId = Integer.parseInt(personalIdString);	//ako je personalID pogresnog formata ne mozemo izmeniti profesora, pa samo vracamo stari Id
					professor.setPersonalID(personalId);
				}
			
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
		

	    public static ProfessorController getProfessorController() {
	    		
	    	if (professorContr == null) {
	    		professorContr = new ProfessorController();
	    	}
	    	return professorContr;
	    }
	        
			
			
	
}
