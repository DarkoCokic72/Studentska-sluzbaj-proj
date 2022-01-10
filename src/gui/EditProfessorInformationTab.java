package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ProfessorController;
import Controller.Validation;
import Listeners.EditProfessorListener;
import Model.Address;
import Model.Profesor;
import Model.ProfessorDatabase;
import Model.Profesor.Zvanje;


public class EditProfessorInformationTab extends JPanel {
	
	private JPanel northPanel;
	private JPanel southPanel;
	
	private JPanel name;
	private static JTextField nameField;
	private JLabel nameLab;
	
	private JPanel surname;
	private static JTextField surnameField;
	private JLabel surnameLab;
	
	private JPanel dateOfBirth;
	private static JTextField dateOfBirthField;
	private JLabel dateOfBirthLab;
	
	private JPanel address;
	private static JTextField streetField;
	private static JTextField streetNumberField;
	private static JTextField cityField;
	private static JTextField countryField;
	private JLabel addressLab;
	
	private JPanel mobile;
	private static JTextField mobileField;
	private JLabel mobileLab;
	
	private JPanel mail;
	private static JTextField mailField;
	private JLabel mailLab;
	
	private JPanel officeAddress;
	private static JTextField officeStreetField;
	private static JTextField officeStreetNumberField;
	private static JTextField officeCityField;
	private static JTextField officeCountryField;
	private JLabel officeAddressLab;
	
	private JPanel personalId;
	private static JTextField personalIdField;
	private JLabel personalIdLab;
	
	private JPanel zvanje;
	private static JComboBox<String> zvanjeComboBox;
	private JLabel zvanjeLab;
	
	private JPanel yearsOfExperience;
	private static JTextField yearsOfExperienceField;
	private JLabel yearsOfExperienceLab;
	
	private static JButton confirm;
	private JButton cancel;
	
	private static Profesor professor;
	
	
	public EditProfessorInformationTab() {
		
		int selectedRow = ProfessorJTable.getTable().convertRowIndexToModel(ProfessorJTable.getTable().getSelectedRow());
		professor = ProfessorDatabase.getDatabase().getProfessorFromRow(selectedRow);
		
		northPanel = new JPanel();
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		southPanel = new JPanel();
		southPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width*3/8, height*300/444); 
		
		Validation.fieldsFilledProfessor(); 
		
		name = new JPanel();
		nameLab = new JLabel("Ime*");
		nameField = new JTextField();
		nameLab.setPreferredSize(new Dimension(200,25));
		nameField.setPreferredSize(new Dimension(270,25));
		name.add(nameLab);
		name.add(nameField);
		northPanel.add(name);
		
		nameField.setText(professor.getName());
		nameField.addFocusListener(new EditProfessorListener(nameField, 0));
		
		surname = new JPanel();
		surnameLab = new JLabel("Prezime*");
		surnameField = new JTextField();
		surnameLab.setPreferredSize(new Dimension(200,25));
		surnameField.setPreferredSize(new Dimension(270,25));
		surname.add(surnameLab);
		surname.add(surnameField);
		northPanel.add(surname);
		
		surnameField.setText(professor.getSurname());
		surnameField.addFocusListener(new EditProfessorListener(surnameField, 1));
		
		dateOfBirth = new JPanel();
		dateOfBirthLab = new JLabel("Datum rodjenja* (dd.mm.yyyy.)");
		dateOfBirthField = new JTextField();
		dateOfBirthLab.setPreferredSize(new Dimension(200,25));
		dateOfBirthField.setPreferredSize(new Dimension(270,25));
		dateOfBirth.add(dateOfBirthLab);
		dateOfBirth.add(dateOfBirthField);
		northPanel.add(dateOfBirth);
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
		dateOfBirthField.setText(dateFormat.format(professor.getDateOfBirth()));
		dateOfBirthField.addFocusListener(new EditProfessorListener(dateOfBirthField, 2));
		
		address = new JPanel();
		addressLab = new JLabel("Adresa stanovanja*");
		streetField = new JTextField();
		streetNumberField = new JTextField();
		cityField = new JTextField();
		countryField = new JTextField();
		addressLab.setPreferredSize(new Dimension(200,25));
		streetField.setPreferredSize(new Dimension(75,25));
		streetNumberField.setPreferredSize(new Dimension(30,25));
		cityField.setPreferredSize(new Dimension(75,25));
		countryField.setPreferredSize(new Dimension(75,25));
		streetField.setToolTipText("Ulica");
		streetNumberField.setToolTipText("Broj");
		cityField.setToolTipText("Grad");
		countryField.setToolTipText("Drzava");
		address.add(addressLab);
		address.add(streetField);
		address.add(streetNumberField);
		address.add(cityField);
		address.add(countryField);
		northPanel.add(address);
		
		Address address = professor.getAddress();
		streetField.setText(address.getStreetName());
		streetNumberField.setText(Integer.toString(address.getStreetNumber()));
		cityField.setText(address.getCity());
		countryField.setText(address.getCountry());
		streetField.addFocusListener(new EditProfessorListener(streetField, 3));
		streetNumberField.addFocusListener(new EditProfessorListener(streetNumberField, 4));
		cityField.addFocusListener(new EditProfessorListener(cityField, 5));
		countryField.addFocusListener(new EditProfessorListener(countryField, 6));
		
		mobile = new JPanel();
		mobileLab = new JLabel("Broj telefona*");
		mobileField = new JTextField();
		mobileLab.setPreferredSize(new Dimension(200,25));
		mobileField.setPreferredSize(new Dimension(270,25));
		mobile.add(mobileLab);
		mobile.add(mobileField);
		northPanel.add(mobile);
		
		mobileField.setText(professor.getPhoneNumber());
		mobileField.addFocusListener(new EditProfessorListener(mobileField, 7));
		
		mail = new JPanel();
		mailLab = new JLabel("E-mail  adresa*");
		mailField = new JTextField();
		mailLab.setPreferredSize(new Dimension(200,25));
		mailField.setPreferredSize(new Dimension(270,25));
		mail.add(mailLab);
		mail.add(mailField);
		northPanel.add(mail);
		
		mailField.setText(professor.geteMail());
		mailField.addFocusListener(new EditProfessorListener(mailField, 8));
		
		officeAddress = new JPanel();
		officeAddressLab = new JLabel("Adresa kancelarije*");
		officeStreetField = new JTextField();
		officeStreetNumberField = new JTextField();
		officeCityField = new JTextField();
		officeCountryField = new JTextField();
		officeAddressLab.setPreferredSize(new Dimension(200,25));
		officeStreetField.setPreferredSize(new Dimension(75,25));
		officeStreetNumberField.setPreferredSize(new Dimension(30,25));
		officeCityField.setPreferredSize(new Dimension(75,25));
		officeCountryField.setPreferredSize(new Dimension(75,25));
		officeStreetField.setToolTipText("Ulica");
		officeStreetNumberField.setToolTipText("Broj");
		officeCityField.setToolTipText("Grad");
		officeCountryField.setToolTipText("Drzava");
		officeAddress.add(officeAddressLab);
		officeAddress.add(officeStreetField);
		officeAddress.add(officeStreetNumberField);
		officeAddress.add(officeCityField);
		officeAddress.add(officeCountryField);
		northPanel.add(officeAddress);
		
		Address officeAddress = professor.getOfficeAddress();
		officeStreetField.setText(officeAddress.getStreetName());
		officeStreetNumberField.setText(Integer.toString(officeAddress.getStreetNumber()));
		officeCityField.setText(officeAddress.getCity());
		officeCountryField.setText(officeAddress.getCountry());
		officeStreetField.addFocusListener(new EditProfessorListener(officeStreetField, 9));
		officeStreetNumberField.addFocusListener(new EditProfessorListener(officeStreetNumberField, 10));
		officeCityField.addFocusListener(new EditProfessorListener(officeCityField, 11));
		officeCountryField.addFocusListener(new EditProfessorListener(officeCountryField, 12));
		
		personalId = new JPanel();
		personalIdLab = new JLabel("Broj lične karte*");
		personalIdField = new JTextField();
		personalIdLab.setPreferredSize(new Dimension(200,25));
		personalIdField.setPreferredSize(new Dimension(270,25));
		personalId.add(personalIdLab);
		personalId.add(personalIdField);
		northPanel.add(personalId);
		
		personalIdField.setText(Integer.toString(professor.getPersonalID()));
		personalIdField.addFocusListener(new EditProfessorListener(personalIdField, 13));
		
		String zvanja[] = {"SARADNIK U NASTAVI", "ASISTENT", "DOCENT", "REDOVNI PROFESOR", "VANREDNI PROFESOR", "EMERITUS"};
		zvanje = new JPanel();
		zvanjeLab = new JLabel("Zvanje*");
		zvanjeComboBox = new JComboBox<String>(zvanja);
		zvanjeLab.setPreferredSize(new Dimension(200,25));
		zvanjeComboBox.setPreferredSize(new Dimension(270,25));
		zvanjeComboBox.setSelectedIndex(0);
		zvanje.add(zvanjeLab);
		zvanje.add(zvanjeComboBox);
		northPanel.add(zvanje);
		
		zvanjeComboBox.setSelectedIndex(professor.getZvanje().ordinal());
		
		yearsOfExperience = new JPanel();
		yearsOfExperienceLab = new JLabel("Godine staža*");
		yearsOfExperienceField = new JTextField();
		yearsOfExperienceLab.setPreferredSize(new Dimension(200,25));
		yearsOfExperienceField.setPreferredSize(new Dimension(270,25));
		yearsOfExperience.add(yearsOfExperienceLab);
		yearsOfExperience.add(yearsOfExperienceField);
		northPanel.add(yearsOfExperience);
		
		yearsOfExperienceField.setText(Integer.toString(professor.getYearsOfExperience()));
		yearsOfExperienceField.addFocusListener(new EditProfessorListener(yearsOfExperienceField, 14));
		
		confirm = new JButton("Potvrdi");
		confirm.setPreferredSize(new Dimension(90,30));
		southPanel.add(confirm);
		
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				ProfessorController professorContr = ProfessorController.getProfessorController();
				professorContr.edit(professor);
				if(professorContr.professorEdited == true) {
					
					Validation.resetFieldsProfessor();
					EditProfessorDialog.getEditProfessorDialog().dispose();
			    	EditProfessorPanel.deleteEditProfessorPanel();
			    	EditProfessorDialog.deleteEditProfessorDialog();
				    professorContr.professorEdited = false;
				}
				

			}

		});
		
		southPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		
		cancel = new JButton("Odustani");
		cancel.setPreferredSize(new Dimension(90,30));
		southPanel.add(cancel);
		
		cancel.addActionListener(new ActionListener() {

		    @Override
			public void actionPerformed(ActionEvent e) {
		    	
		    	EditProfessorDialog.getEditProfessorDialog().dispose();
		    	EditProfessorPanel.deleteEditProfessorPanel();
		    	EditProfessorDialog.deleteEditProfessorDialog();
		    	
			}

		});
		
		add(northPanel,BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
				
	}
	
	public static JTextField getNameField() {
		return nameField;
	}
	
    public static JTextField getSurnameField() {
    	return surnameField;
    }
    
    public static JTextField getDateOfBirth() {
    	return dateOfBirthField;
    }
    
    public static JTextField getStreetField() {
    	return streetField;
    }
    
    public static JTextField getStreetNumberField() {
    	return streetNumberField;
    }
    
    public static JTextField getCityField() {
    	return cityField;
    }
    
    public static JTextField getCountryField() {
    	return countryField;
    }
    
    public static JTextField getMobile() {
    	return mobileField;
    }
    
    public static JTextField getMailField() {
    	return mailField;
    }
    
    public static JTextField getOfficeStreetField() {
    	return officeStreetField;
    }
    
    public static JTextField getOfficeStreetNumberField() {
    	return officeStreetNumberField;
    }
    
    public static JTextField getOfficeCityField() {
    	return officeCityField;
    }
    
    public static JTextField getOfficeCountryField() {
    	return officeCountryField;
    }
    
    public static JTextField getPersonalId() {
    	return personalIdField;
    }
    
    
    public static Zvanje getZvanje() {
        
    	int zvanjeIndex = zvanjeComboBox.getSelectedIndex();
    	Zvanje zvanje;
    	
		switch (zvanjeIndex) {
		case 0:
			
			zvanje = Profesor.Zvanje.SARADNIK_U_NASTAVI;
			break;
			
		case 1:
			
			zvanje = Profesor.Zvanje.ASISTENT;
			break;
			
		case 2:
			
			zvanje = Profesor.Zvanje.DOCENT;
			break;
			
		case 3:
			
			zvanje = Profesor.Zvanje.REDOVNI_PROFESOR;
			break;
			
		case 4:
			
			zvanje = Profesor.Zvanje.VANREDNI_PROFESOR;
			
		case 5:
			
			zvanje = Profesor.Zvanje.EMERITUS;
			
		default:
			
			zvanje = Profesor.Zvanje.SARADNIK_U_NASTAVI;
			
		}
		
		return zvanje;
    }
    
    public static JTextField getYearsOfExpirienceField() {
    	return yearsOfExperienceField;
    }
    
    public static JButton getConfirm() {
    	return confirm;
    }
	

}
