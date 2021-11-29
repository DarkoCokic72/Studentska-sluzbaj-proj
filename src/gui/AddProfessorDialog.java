package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.ProfessorController;

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
	private static JTextField titulaField;
	private JLabel titulaLab;
	
	private JPanel zvanje;
	private static JTextField zvanjeField;
	private JLabel zvanjeLab;
	
	private JPanel yearsOfExpirience;
	private static JTextField yearsOfExpirienceField;
	private JLabel yearsOfExpirienceLab;
	
	private JButton confirm;
	private JButton cancel;
	
	public AddProfessorDialog() {
		
		northPanel = new JPanel();
		southPanel = new JPanel();
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width*3/8, height*300/488); 
		setTitle("Dodavanje profesora");
		setResizable(false);
		
		name = new JPanel();
		nameLab = new JLabel("Ime*");
		nameField = new JTextField();
		nameLab.setPreferredSize(new Dimension(200,25));
		nameField.setPreferredSize(new Dimension(200,25));
		name.add(nameLab);
		name.add(nameField);
		northPanel.add(name);
		
		surname = new JPanel();
		surnameLab = new JLabel("Prezime*");
		surnameField = new JTextField();
		surnameLab.setPreferredSize(new Dimension(200,25));
		surnameField.setPreferredSize(new Dimension(200,25));
		surname.add(surnameLab);
		surname.add(surnameField);
		northPanel.add(surname);
		
		dateOfBirth = new JPanel();
		dateOfBirthLab = new JLabel("Datum rodjenja*");
		dateOfBirthField = new JTextField();
		dateOfBirthLab.setPreferredSize(new Dimension(200,25));
		dateOfBirthField.setPreferredSize(new Dimension(200,25));
		dateOfBirth.add(dateOfBirthLab);
		dateOfBirth.add(dateOfBirthField);
		northPanel.add(dateOfBirth);
		
		address = new JPanel();
		addressLab = new JLabel("Adresa stanovanja*");
		addressField = new JTextField();
		addressLab.setPreferredSize(new Dimension(200,25));
		addressField.setPreferredSize(new Dimension(200,25));
		address.add(addressLab);
		address.add(addressField);
		northPanel.add(address);
		
		mobile = new JPanel();
		mobileLab = new JLabel("Broj telefona*");
		mobileField = new JTextField();
		mobileLab.setPreferredSize(new Dimension(200,25));
		mobileField.setPreferredSize(new Dimension(200,25));
		mobile.add(mobileLab);
		mobile.add(mobileField);
		northPanel.add(mobile);
		
		mail = new JPanel();
		mailLab = new JLabel("E-mail  adresa*");
		mailField = new JTextField();
		mailLab.setPreferredSize(new Dimension(200,25));
		mailField.setPreferredSize(new Dimension(200,25));
		mail.add(mailLab);
		mail.add(mailField);
		northPanel.add(mail);
		
		officeAddress = new JPanel();
		officeAddressLab = new JLabel("Adresa kancelarije*");
		officeAddressField = new JTextField();
		officeAddressLab.setPreferredSize(new Dimension(200,25));
		officeAddressField.setPreferredSize(new Dimension(200,25));
		officeAddress.add(officeAddressLab);
		officeAddress.add(officeAddressField);
		northPanel.add(officeAddress);
		
		personalId = new JPanel();
		personalIdLab = new JLabel("Broj licne karte*");
		personalIdField = new JTextField();
		personalIdLab.setPreferredSize(new Dimension(200,25));
		personalIdField.setPreferredSize(new Dimension(200,25));
		personalId.add(personalIdLab);
		personalId.add(personalIdField);
		northPanel.add(personalId);
		
		titula = new JPanel();
		titulaLab = new JLabel("Titula*");
		titulaField = new JTextField();
		titulaLab.setPreferredSize(new Dimension(200,25));
		titulaField.setPreferredSize(new Dimension(200,25));
		titula.add(titulaLab);
		titula.add(titulaField);
		northPanel.add(titula);
		
		zvanje = new JPanel();
		zvanjeLab = new JLabel("Zvanje*");
		zvanjeField = new JTextField();
		zvanjeLab.setPreferredSize(new Dimension(200,25));
		zvanjeField.setPreferredSize(new Dimension(200,25));
		zvanje.add(zvanjeLab);
		zvanje.add(zvanjeField);
		northPanel.add(zvanje);
		
		yearsOfExpirience = new JPanel();
		yearsOfExpirienceLab = new JLabel("Godine iskustva*");
		yearsOfExpirienceField = new JTextField();
		yearsOfExpirienceLab.setPreferredSize(new Dimension(200,25));
		yearsOfExpirienceField.setPreferredSize(new Dimension(200,25));
		yearsOfExpirience.add(yearsOfExpirienceLab);
		yearsOfExpirience.add(yearsOfExpirienceField);
		northPanel.add(yearsOfExpirience);
		
		confirm = new JButton("Potvrdi");
		confirm.setPreferredSize(new Dimension(90,30));
		//confirm.setEnabled(false);
		southPanel.add(confirm);
		
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					ProfessorController professorController = new ProfessorController();
					professorController.add();
					if(professorController.professorAdded == true) {
					dispose();
					professorController.professorAdded = false;
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
    
    public static JTextField getTitulaField() {
    	return titulaField;
    }
    
    public static JTextField getZvanjeField() {
    	return zvanjeField;
    }
    
    public static JTextField getYearsOfExpirienceField() {
    	return yearsOfExpirienceField;
    }
    
    
}
