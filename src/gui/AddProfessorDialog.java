package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddProfessorDialog extends JDialog {
	
	private JFrame addProfessorFrame;
	private JPanel northPanel;
	private JPanel southPanel;
	
	private JPanel name;
	private JTextField nameField;
	private JLabel nameLab;
	
	private JPanel surname;
	private JTextField surnameField;
	private JLabel surnameLab;
	
	private JPanel dateOfBirth;
	private JTextField dateOfBirthField;
	private JLabel dateOfBirthLab;
	
	private JPanel address;
	private JTextField addressField;
	private JLabel addressLab;
	
	private JPanel mobile;
	private JTextField mobileField;
	private JLabel mobileLab;
	
	private JPanel officeAddress;
	private JTextField officeAddressField;
	private JLabel officeAddressLab;
	
	private JPanel personalId;
	private JTextField personalIdField;
	private JLabel personalIdLab;
    
	private JPanel titula;
	private JTextField titulaField;
	private JLabel titulaLab;
	
	private JPanel zvanje;
	private JTextField zvanjeField;
	private JLabel zvanjeLab;
	
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
		
		confirm = new JButton("Potvrdi");
		confirm.setPreferredSize(new Dimension(90,30));
		confirm.setEnabled(false);
		southPanel.add(confirm);
		southPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		
		cancel = new JButton("Odustani");
		cancel.setPreferredSize(new Dimension(90,30));
		southPanel.add(cancel);
		
		add(northPanel,BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		revalidate(); 
		repaint();
		
		
		
	}
	
	
	
	

}
