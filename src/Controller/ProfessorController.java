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
import Model.Profesor.Zvanje;
import Model.ProfessorDatabase;
import Model.Subject;
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
			String street = AddProfessorDialog.getStreetField().getText().trim(); 
			String streetNumberString = AddProfessorDialog.getStreetNumberField().getText().trim(); //convert to int
			String city = AddProfessorDialog.getCityField().getText().trim();
			String country = AddProfessorDialog.getCountryField().getText().trim();
			String phoneNumber = AddProfessorDialog.getMobile().getText().trim(); 
			String email = AddProfessorDialog.getMailField().getText().trim();
			String officeStreet = AddProfessorDialog.getOfficeStreetField().getText().trim(); 
			String officeStreetNumberString = AddProfessorDialog.getOfficeStreetNumberField().getText().trim(); //convert to int
			String officeCity = AddProfessorDialog.getOfficeCityField().getText().trim();
			String officeCountry = AddProfessorDialog.getCountryField().getText().trim();
			String personalIdString = AddProfessorDialog.getPersonalId().getText().trim(); //convert to int
			Zvanje zvanje = AddProfessorDialog.getZvanje();
			String yearsOfExperienceString = AddProfessorDialog.getYearsOfExpirienceField().getText().trim(); //convert to int
				
			if(Validation.checkName(name) == true && Validation.checkSurname(surname) == true && Validation.checkDate(dateString) == true && Validation.checkStreet(street) == true 
				&& Validation.checkStreetNumber(streetNumberString) == true && Validation.checkCity(city) == true && Validation.checkCity(country) == true
				&& Validation.checkPhoneNumber(phoneNumber) == true && Validation.checkEmail(email) == true && Validation.checkStreet(officeStreet) == true
				&& Validation.checkStreetNumber(officeStreetNumberString) == true && Validation.checkCity(officeCity) == true && Validation.checkCountry(officeCountry) == true
				&& Validation.checkPersonalId(personalIdString) == true && Validation.checkYearsOfExp(yearsOfExperienceString) == true) {
			
				Date date = Converter.convertStringToDate(dateString);
				Address address = new Address(street, streetNumberString, city, country);
				Address officeAddress = new Address(officeStreet, officeStreetNumberString, officeCity, officeCountry);
				int personalId = Integer.parseInt(personalIdString);
				int yearsOfExperience = Integer.parseInt(yearsOfExperienceString);
				
				Profesor professor = new Profesor(name, surname, date, email, phoneNumber, address, 
			    		                          officeAddress, personalId, yearsOfExperience, zvanje);
			     
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
			String street = EditProfessorInformationTab.getStreetField().getText().trim(); 
			String streetNumberString = EditProfessorInformationTab.getStreetNumberField().getText().trim(); //convert to int
			String city = EditProfessorInformationTab.getCityField().getText().trim();
			String country = EditProfessorInformationTab.getCountryField().getText().trim();
			String phoneNumber = EditProfessorInformationTab.getMobile().getText().trim(); 
			String email = EditProfessorInformationTab.getMailField().getText().trim();
			String officeStreet = EditProfessorInformationTab.getOfficeStreetField().getText().trim();
			String officeStreetNumberString = EditProfessorInformationTab.getOfficeStreetNumberField().getText().trim(); //convert to int
			String officeCity = EditProfessorInformationTab.getOfficeCityField().getText().trim();
			String officeCountry = EditProfessorInformationTab.getOfficeCountryField().getText().trim();
			Zvanje zvanje = EditProfessorInformationTab.getZvanje();
			String yearsOfExperienceString = EditProfessorInformationTab.getYearsOfExpirienceField().getText().trim(); //convert to int
				
			if(Validation.checkName(name) == true && Validation.checkSurname(surname) == true && Validation.checkDate(dateString) == true && Validation.checkStreet(street) == true
				&& Validation.checkStreetNumber(streetNumberString) == true && Validation.checkCity(city) == true && Validation.checkCountry(country) == true
				&& Validation.checkPhoneNumber(phoneNumber) == true && Validation.checkEmail(email) == true && Validation.checkStreet(officeStreet) == true 
				&& Validation.checkStreetNumber(officeStreetNumberString) == true && Validation.checkCity(officeCity) == true && Validation.checkCountry(officeCountry) == true
				&& Validation.checkYearsOfExp(yearsOfExperienceString) == true) {
				
				
				String personalIdString = EditProfessorInformationTab.getPersonalId().getText().trim(); //convert to int
				professor.setPersonalID(-1);	 			//postavljamo personalID na -1 kako bismo mogli da ga ne promenimo prilikom editovanja, 
															//a da nam pri tome ne iskoci greska da vec postoji profesor sa identicnim ID
				String personalIdStringWrong = EditProfessorInformationTab.getPersonalId().getText().trim();
				
				if(Validation.checkPersonalId(personalIdStringWrong)) {
			
					Date date = Converter.convertStringToDate(dateString);
					Address address = new Address(street, streetNumberString, city, country);
					Address officeAddress = new Address(officeStreet, officeStreetNumberString, officeCity, officeCountry);
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
					professor.setZvanje(zvanje);
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
					ProfessorDatabase.getDatabase().setProfessors(professorList);
					ArrayList<Subject> subjectTeaches = p.getSubjectsTeaches();
					for(Subject s: subjectTeaches) {
						s.setSubjectProfessor(null);
					}
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
	        
			
		public void removeSubject(int id) {
			int row = ProfessorJTable.getTable().convertRowIndexToModel(ProfessorJTable.getTable().getSelectedRow());
			Profesor prof = ProfessorDatabase.getDatabase().getByPersonalID(id);
			prof.getSubjectsTeaches().get(row).setSubjectProfessor(null);
			prof.getSubjectsTeaches().remove(row);
			
			ProfessorJTable.getTable().updateTable();
			
		}	
	
}
