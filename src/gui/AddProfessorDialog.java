package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ProfessorController;
import Controller.Validation;
import Listeners.AddProfessorListener;
import Model.Profesor;
import Model.Profesor.Zvanje;

public class AddProfessorDialog extends JDialog {
	
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
	
	public AddProfessorDialog() {
		
		northPanel = new JPanel();
		southPanel = new JPanel();
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width*3/8, height*25/37);
		ImageIcon img = new ImageIcon("images" + File.separator + "Plus-icon.png");
		setIconImage(img.getImage());
		setTitle("Dodavanje profesora");
		setResizable(false);
		
		Validation.resetFieldsProfessor();
		
		name = new JPanel();
		nameLab = new JLabel("Ime*");
		nameField = new JTextField();
		nameLab.setPreferredSize(new Dimension(200,25));
		nameField.setPreferredSize(new Dimension(270,25));
		name.add(nameLab);
		name.add(nameField);
		northPanel.add(name);
		nameField.addFocusListener(new AddProfessorListener(nameField, 0));
		
		surname = new JPanel();
		surnameLab = new JLabel("Prezime*");
		surnameField = new JTextField();
		surnameLab.setPreferredSize(new Dimension(200,25));
		surnameField.setPreferredSize(new Dimension(270,25));
		surname.add(surnameLab);
		surname.add(surnameField);
		northPanel.add(surname);
		surnameField.addFocusListener(new AddProfessorListener(surnameField, 1));
		
		dateOfBirth = new JPanel();
		dateOfBirthLab = new JLabel("Datum rodjenja* (dd.mm.yyyy.)");
		dateOfBirthField = new JTextField();
		dateOfBirthLab.setPreferredSize(new Dimension(200,25));
		dateOfBirthField.setPreferredSize(new Dimension(270,25));
		dateOfBirth.add(dateOfBirthLab);
		dateOfBirth.add(dateOfBirthField);
		northPanel.add(dateOfBirth);
		dateOfBirthField.addFocusListener(new AddProfessorListener(dateOfBirthField, 2));
		
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
		streetField.addFocusListener(new AddProfessorListener(streetField, 3));
		streetNumberField.addFocusListener(new AddProfessorListener(streetNumberField, 4));
		cityField.addFocusListener(new AddProfessorListener(cityField, 5));
		countryField.addFocusListener(new AddProfessorListener(countryField, 6));
		
		mobile = new JPanel();
		mobileLab = new JLabel("Broj telefona*");
		mobileField = new JTextField();
		mobileLab.setPreferredSize(new Dimension(200,25));
		mobileField.setPreferredSize(new Dimension(270,25));
		mobile.add(mobileLab);
		mobile.add(mobileField);
		northPanel.add(mobile);
		mobileField.addFocusListener(new AddProfessorListener(mobileField, 7));
		
		mail = new JPanel();
		mailLab = new JLabel("E-mail  adresa*");
		mailField = new JTextField();
		mailLab.setPreferredSize(new Dimension(200,25));
		mailField.setPreferredSize(new Dimension(270,25));
		mail.add(mailLab);
		mail.add(mailField);
		northPanel.add(mail);
		mailField.addFocusListener(new AddProfessorListener(mailField, 8));
		
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
		officeStreetField.addFocusListener(new AddProfessorListener(officeStreetField, 9));
		officeStreetNumberField.addFocusListener(new AddProfessorListener(officeStreetNumberField, 10));
		officeCityField.addFocusListener(new AddProfessorListener(officeCityField, 11));
		officeCountryField.addFocusListener(new AddProfessorListener(officeCountryField, 12));
		
		personalId = new JPanel();
		personalIdLab = new JLabel("Broj lične karte*");
		personalIdField = new JTextField();
		personalIdLab.setPreferredSize(new Dimension(200,25));
		personalIdField.setPreferredSize(new Dimension(270,25));
		personalId.add(personalIdLab);
		personalId.add(personalIdField);
		northPanel.add(personalId);
		personalIdField.addFocusListener(new AddProfessorListener(personalIdField, 13));
		
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
		
		yearsOfExperience = new JPanel();
		yearsOfExperienceLab = new JLabel("Godine staza*");
		yearsOfExperienceField = new JTextField();
		yearsOfExperienceLab.setPreferredSize(new Dimension(200,25));
		yearsOfExperienceField.setPreferredSize(new Dimension(270,25));
		yearsOfExperience.add(yearsOfExperienceLab);
		yearsOfExperience.add(yearsOfExperienceField);
		northPanel.add(yearsOfExperience);
		yearsOfExperienceField.addFocusListener(new AddProfessorListener(yearsOfExperienceField, 14));
		
		confirm = new JButton("Potvrdi");
		confirm.setPreferredSize(new Dimension(90,30));
		confirm.setEnabled(false);
		southPanel.add(confirm);
		
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					ProfessorController professorContr = ProfessorController.getProfessorController();
					professorContr.add();
					if(professorContr.professorAdded == true) {
						
						Validation.resetFieldsProfessor();
					    dispose();
					    professorContr.professorAdded = false;
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
		    	
		    	Validation.resetFieldsProfessor();
				dispose();
			}

		});
		
		add(northPanel,BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		revalidate(); 
		repaint();
		
		
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
