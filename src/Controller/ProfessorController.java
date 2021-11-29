package Controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import Model.Address;
import Model.Profesor;
import Model.ProfessorDatabase;
import gui.AddProfessorDialog;
import gui.ProfessorJTable;

public class ProfessorController {


		public void add() {
			
			String name = AddProfessorDialog.getNameField().getText().trim();
			
			String surname = AddProfessorDialog.getSurnameField().getText().trim();
			
			Date dateOfBirth = convertStringToDate(AddProfessorDialog.getDateOfBirth().getText().trim()); 
			
			Address address = convertStringToAddress(AddProfessorDialog.getAddress().getText().trim()); 
			
			String mobilePhone = AddProfessorDialog.getMobile().getText().trim(); 
			
			String email = AddProfessorDialog.getMailField().getText().trim();
			
			Address officeAddress = convertStringToAddress(AddProfessorDialog.getOfficeAddressField().getText().trim()); 
			
			int personalId = Integer.parseInt(AddProfessorDialog.getPersonalId().getText().trim()); 

			String titula = AddProfessorDialog.getTitulaField().getText().trim();
			
			String zvanje = AddProfessorDialog.getZvanjeField().getText().trim();
			
			int yearsOfExperience = Integer.parseInt(AddProfessorDialog.getYearsOfExpirienceField().getText().trim()); 
			
			Profesor professor = new Profesor(name, surname, dateOfBirth, email, mobilePhone, address, officeAddress, personalId, titula, yearsOfExperience, zvanje);
			
		    
			ProfessorDatabase professorDatabase = ProfessorDatabase.getInstance();
			professorDatabase.addProfessorToTable(professor);
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
				
				String streetName = "Rumenacka";
				int streetNumber = 17;                   //FIXME iz output[0] izvuci streetName i streetNumber
				
				retAddress = new Address(streetName, streetNumber , city, country);
				return retAddress;
			}
	
}
