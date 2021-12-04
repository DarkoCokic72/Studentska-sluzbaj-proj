package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import Model.Profesor.Titula;
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
	private static JTextField addressField;
	private JLabel addressLab;
	
	private JPanel mobile;
	private static JTextField mobileField;
	private JLabel mobileLab;
	
	private JPanel mail;
	private static JTextField mailField;
	private JLabel mailLab;
	
	private JPanel officeAddress;
	private static JTextField officeAddressField;
	private JLabel officeAddressLab;
	
	private JPanel personalId;
	private static JTextField personalIdField;
	private JLabel personalIdLab;
    
	private JPanel titula;
	private static JComboBox<String> titulaComboBox;
	private JLabel titulaLab;
	
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
		ImageIcon img = new ImageIcon("images/Plus-icon.png");
		setIconImage(img.getImage());
		setTitle("Dodavanje profesora");
		setResizable(false);
		
		Validation.resetFieldsProfessor();
		
		name = new JPanel();
		nameLab = new JLabel("Ime*");
		nameField = new JTextField();
		nameLab.setPreferredSize(new Dimension(200,25));
		nameField.setPreferredSize(new Dimension(200,25));
		name.add(nameLab);
		name.add(nameField);
		northPanel.add(name);
		nameField.addFocusListener(new AddProfessorListener(nameField, 0));
		
		surname = new JPanel();
		surnameLab = new JLabel("Prezime*");
		surnameField = new JTextField();
		surnameLab.setPreferredSize(new Dimension(200,25));
		surnameField.setPreferredSize(new Dimension(200,25));
		surname.add(surnameLab);
		surname.add(surnameField);
		northPanel.add(surname);
		surnameField.addFocusListener(new AddProfessorListener(surnameField, 1));
		
		dateOfBirth = new JPanel();
		dateOfBirthLab = new JLabel("Datum rodjenja*");
		dateOfBirthField = new JTextField();
		dateOfBirthLab.setPreferredSize(new Dimension(200,25));
		dateOfBirthField.setPreferredSize(new Dimension(200,25));
		dateOfBirth.add(dateOfBirthLab);
		dateOfBirth.add(dateOfBirthField);
		northPanel.add(dateOfBirth);
		dateOfBirthField.addFocusListener(new AddProfessorListener(dateOfBirthField, 2));
		
		address = new JPanel();
		addressLab = new JLabel("Adresa stanovanja*");
		addressField = new JTextField();
		addressLab.setPreferredSize(new Dimension(200,25));
		addressField.setPreferredSize(new Dimension(200,25));
		address.add(addressLab);
		address.add(addressField);
		northPanel.add(address);
		addressField.addFocusListener(new AddProfessorListener(addressField, 3));
		
		mobile = new JPanel();
		mobileLab = new JLabel("Broj telefona*");
		mobileField = new JTextField();
		mobileLab.setPreferredSize(new Dimension(200,25));
		mobileField.setPreferredSize(new Dimension(200,25));
		mobile.add(mobileLab);
		mobile.add(mobileField);
		northPanel.add(mobile);
		mobileField.addFocusListener(new AddProfessorListener(mobileField, 4));
		
		mail = new JPanel();
		mailLab = new JLabel("E-mail  adresa*");
		mailField = new JTextField();
		mailLab.setPreferredSize(new Dimension(200,25));
		mailField.setPreferredSize(new Dimension(200,25));
		mail.add(mailLab);
		mail.add(mailField);
		northPanel.add(mail);
		mailField.addFocusListener(new AddProfessorListener(mailField, 5));
		
		officeAddress = new JPanel();
		officeAddressLab = new JLabel("Adresa kancelarije*");
		officeAddressField = new JTextField();
		officeAddressLab.setPreferredSize(new Dimension(200,25));
		officeAddressField.setPreferredSize(new Dimension(200,25));
		officeAddress.add(officeAddressLab);
		officeAddress.add(officeAddressField);
		northPanel.add(officeAddress);
		officeAddressField.addFocusListener(new AddProfessorListener(officeAddressField, 6));
		
		personalId = new JPanel();
		personalIdLab = new JLabel("Broj licne karte*");
		personalIdField = new JTextField();
		personalIdLab.setPreferredSize(new Dimension(200,25));
		personalIdField.setPreferredSize(new Dimension(200,25));
		personalId.add(personalIdLab);
		personalId.add(personalIdField);
		northPanel.add(personalId);
		personalIdField.addFocusListener(new AddProfessorListener(personalIdField, 7));
		
		String titule[] = {"BSC", "MSC", "MR", "DR", "PROF"};
		titula = new JPanel();
        titulaLab = new JLabel("Titula*");
		titulaComboBox= new JComboBox<String>(titule);
		titulaLab.setPreferredSize(new Dimension(200,25));
		titulaComboBox.setPreferredSize(new Dimension(200,25));
		titulaComboBox.setSelectedIndex(0);
		titula.add(titulaLab);
		titula.add(titulaComboBox);
		northPanel.add(titula);
		
		String zvanja[] = {"SARADNIK U NASTAVI", "ASISTENT", "DOCENT", "REDOVNI PROFESOR", "VANREDNI PROFESOR", "EMERITUS"};
		zvanje = new JPanel();
		zvanjeLab = new JLabel("Zvanje*");
		zvanjeComboBox = new JComboBox<String>(zvanja);
		zvanjeLab.setPreferredSize(new Dimension(200,25));
		zvanjeComboBox.setPreferredSize(new Dimension(200,25));
		zvanjeComboBox.setSelectedIndex(0);
		zvanje.add(zvanjeLab);
		zvanje.add(zvanjeComboBox);
		northPanel.add(zvanje);
		
		yearsOfExperience = new JPanel();
		yearsOfExperienceLab = new JLabel("Godine staza*");
		yearsOfExperienceField = new JTextField();
		yearsOfExperienceLab.setPreferredSize(new Dimension(200,25));
		yearsOfExperienceField.setPreferredSize(new Dimension(200,25));
		yearsOfExperience.add(yearsOfExperienceLab);
		yearsOfExperience.add(yearsOfExperienceField);
		northPanel.add(yearsOfExperience);
		yearsOfExperienceField.addFocusListener(new AddProfessorListener(yearsOfExperienceField, 8));
		
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
    
    public static JTextField getAddress() {
    	return addressField;
    }
    
    public static JTextField getMobile() {
    	return mobileField;
    }
    
    public static JTextField getMailField() {
    	return mailField;
    }
    
    public static JTextField getOfficeAddressField() {
    	return officeAddressField;
    }
    
    public static JTextField getPersonalId() {
    	return personalIdField;
    }
    
    public static Titula getTitula() {
    	
    	int titulaIndex = titulaComboBox.getSelectedIndex();
    	Titula titula;
    	
    	switch (titulaIndex) {
		case 0:
			titula = Profesor.Titula.BSC;
			break;
		case 1:
			titula = Profesor.Titula.MSC;
			break;
		case 2:
			titula = Profesor.Titula.MR;
			break;
		case 3:
			titula = Profesor.Titula.DR;
			break;
		case 4:
			titula = Profesor.Titula.PROF;
			break;
		default:
			titula = Profesor.Titula.PROF;
		}
    	
    	return titula;
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
