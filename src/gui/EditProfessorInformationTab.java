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

import Model.Profesor;
import Model.ProfessorDatabase;


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
		
		name = new JPanel();
		nameLab = new JLabel("Ime*");
		nameField = new JTextField();
		nameLab.setPreferredSize(new Dimension(200,25));
		nameField.setPreferredSize(new Dimension(200,25));
		name.add(nameLab);
		name.add(nameField);
		northPanel.add(name);
		
		nameField.setText(professor.getName());
		//nameField.addFocusListener(new EditProfessorListener(nameField, 0));
		
		surname = new JPanel();
		surnameLab = new JLabel("Prezime*");
		surnameField = new JTextField();
		surnameLab.setPreferredSize(new Dimension(200,25));
		surnameField.setPreferredSize(new Dimension(200,25));
		surname.add(surnameLab);
		surname.add(surnameField);
		northPanel.add(surname);
		
		surnameField.setText(professor.getSurname());
		//surnameField.addFocusListener(new EditProfessorListener(surnameField, 1));
		
		dateOfBirth = new JPanel();
		dateOfBirthLab = new JLabel("Datum rodjenja*");
		dateOfBirthField = new JTextField();
		dateOfBirthLab.setPreferredSize(new Dimension(200,25));
		dateOfBirthField.setPreferredSize(new Dimension(200,25));
		dateOfBirth.add(dateOfBirthLab);
		dateOfBirth.add(dateOfBirthField);
		northPanel.add(dateOfBirth);
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
		dateOfBirthField.setText(dateFormat.format(professor.getDateOfBirth()));
		//dateOfBirthField.addFocusListener(new EditProfessorListener(dateOfBirthField, 2));
		
		address = new JPanel();
		addressLab = new JLabel("Adresa stanovanja*");
		addressField = new JTextField();
		addressLab.setPreferredSize(new Dimension(200,25));
		addressField.setPreferredSize(new Dimension(200,25));
		address.add(addressLab);
		address.add(addressField);
		northPanel.add(address);
		
		String addressString = professor.getAddress().getStreetName() + Integer.toString(professor.getAddress().getStreetNumber()) + "," + professor.getAddress().getCity() + "," + professor.getAddress().getCountry() ; 
		addressField.setText(addressString);
		//addressField.addFocusListener(new EditProfessorListener(addressField, 3));
		
		mobile = new JPanel();
		mobileLab = new JLabel("Broj telefona*");
		mobileField = new JTextField();
		mobileLab.setPreferredSize(new Dimension(200,25));
		mobileField.setPreferredSize(new Dimension(200,25));
		mobile.add(mobileLab);
		mobile.add(mobileField);
		northPanel.add(mobile);
		
		mobileField.setText(professor.getPhoneNumber());
		//mobileField.addFocusListener(new EditProfessorListener(mobileField, 4));
		
		mail = new JPanel();
		mailLab = new JLabel("E-mail  adresa*");
		mailField = new JTextField();
		mailLab.setPreferredSize(new Dimension(200,25));
		mailField.setPreferredSize(new Dimension(200,25));
		mail.add(mailLab);
		mail.add(mailField);
		northPanel.add(mail);
		
		mailField.setText(professor.geteMail());
		//mailField.addFocusListener(new EditProfessorListener(mailField, 5));
		
		officeAddress = new JPanel();
		officeAddressLab = new JLabel("Adresa kancelarije*");
		officeAddressField = new JTextField();
		officeAddressLab.setPreferredSize(new Dimension(200,25));
		officeAddressField.setPreferredSize(new Dimension(200,25));
		officeAddress.add(officeAddressLab);
		officeAddress.add(officeAddressField);
		northPanel.add(officeAddress);
		
		String officeAddressString = professor.getOfficeAddress().getStreetName() + Integer.toString(professor.getOfficeAddress().getStreetNumber()) + "," + professor.getOfficeAddress().getCity() + "," + professor.getOfficeAddress().getCountry() ; 
		officeAddressField.setText(officeAddressString);
		//officeAddressField.addFocusListener(new EditProfessorListener(officeAddressField, 6));
		
		personalId = new JPanel();
		personalIdLab = new JLabel("Broj licne karte*");
		personalIdField = new JTextField();
		personalIdLab.setPreferredSize(new Dimension(200,25));
		personalIdField.setPreferredSize(new Dimension(200,25));
		personalId.add(personalIdLab);
		personalId.add(personalIdField);
		northPanel.add(personalId);
		
		personalIdField.setText(Integer.toString(professor.getPersonalID()));
		//personalIdField.addFocusListener(new EditProfessorListener(personalIdField, 7));
		
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
		
		titulaComboBox.setSelectedIndex(professor.getTitula().ordinal());
		
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
		
		zvanjeComboBox.setSelectedIndex(professor.getZvanje().ordinal());
		
		yearsOfExperience = new JPanel();
		yearsOfExperienceLab = new JLabel("Godine staza*");
		yearsOfExperienceField = new JTextField();
		yearsOfExperienceLab.setPreferredSize(new Dimension(200,25));
		yearsOfExperienceField.setPreferredSize(new Dimension(200,25));
		yearsOfExperience.add(yearsOfExperienceLab);
		yearsOfExperience.add(yearsOfExperienceField);
		northPanel.add(yearsOfExperience);
		
		yearsOfExperienceField.setText(Integer.toString(professor.getYearsOfExperience()));
		//yearsOfExperienceField.addFocusListener(new EditProfessorListener(yearsOfExperienceField, 8));
		
		confirm = new JButton("Potvrdi");
		confirm.setPreferredSize(new Dimension(90,30));
		confirm.setEnabled(false);
		southPanel.add(confirm);
		
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				

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
	

}
