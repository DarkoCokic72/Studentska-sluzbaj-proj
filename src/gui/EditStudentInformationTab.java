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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.StudentController;
import Controller.ValidationStudent;
import Listeners.EditStudentListener;
import Model.Address;
import Model.Student;
import Model.Student.Status;
import Model.StudentDatabase;

public class EditStudentInformationTab extends JPanel {
	
	private static EditStudentInformationTab editStudentInformationTab = null;
	
	private JPanel northPanel;
	private JPanel southPanel;
	
	private JPanel name;
	private static JTextField nameField;
	private static JLabel nameLabel;
	
	private JPanel surname;
	private static JTextField surnameField;
	private static JLabel surnameLabel;
	
	private JPanel dateOfBirth;
	private static JTextField dateOfBirthField;
	private static JLabel dateOfBirthLabel;
	
	private JPanel address;
	private static JTextField streetField;
	private static JTextField streetNumberField;
	private static JTextField cityField;
	private static JTextField countryField;
	private static JLabel addressLabel;
	
	private JPanel phoneNumber;
	private static JTextField phoneNumberField;
	private static JLabel phoneNumberLabel;
	
	private JPanel email;
	private static JTextField emailField;
	private static JLabel emailLabel;
	
	private JPanel index;
	private static JTextField indexField;
	private static JLabel indexLabel;
	
	private JPanel yearOfEnroll;
	private static JTextField yearOfEnrollField;
	private static JLabel yearOfEnrollLabel;
	
	private JPanel currYearOfStudies;
	private static JComboBox<String> currYearOfStudiesComboBox;
	private static JLabel currYearOfStudiesLabel;
	
	private JPanel currStatus;
	private static JComboBox<String> currStatusComboBox;
	private static JLabel currStatusLabel;
	
	private static JButton confirm;
	private static JButton cancel;
	
	private static Student student;
	
	public EditStudentInformationTab() {
		int selectedRow = StudentTable.getTable().convertRowIndexToModel(StudentTable.getTable().getSelectedRow());
		student = StudentDatabase.getInstance().getStudentFromRow(selectedRow);
		
		
		northPanel = new JPanel();
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		southPanel = new JPanel();
		southPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int heigth = d.height;
		int width = d.width;
		setSize(heigth * 3/8, width * 300 / 444);
		
		ValidationStudent.fieldsFilled();
		
		name = new JPanel();
		nameLabel = new JLabel("Ime*");
		nameField = new JTextField();
		nameLabel.setPreferredSize(new Dimension(200, 25));
		nameField.setPreferredSize(new Dimension(280, 25));
		name.add(nameLabel);
		name.add(nameField);
		northPanel.add(name);
		
		nameField.setText(student.getName());
		nameField.addFocusListener(new EditStudentListener(0, nameField));
		
		surname = new JPanel();
		surnameLabel = new JLabel("Prezime*");
		surnameField = new JTextField();
		surnameLabel.setPreferredSize(new Dimension(200, 25));
		surnameField.setPreferredSize(new Dimension(280, 25));
		surname.add(surnameLabel);
		surname.add(surnameField);
		northPanel.add(surname);
		
		surnameField.setText(student.getSurname());
		surnameField.addFocusListener(new EditStudentListener(1, surnameField));
		
		dateOfBirth = new JPanel();
		dateOfBirthLabel = new JLabel("Datum rodjenja*");
		dateOfBirthField = new JTextField();
		dateOfBirthLabel.setPreferredSize(new Dimension(200, 25));
		dateOfBirthField.setPreferredSize(new Dimension(280, 25));
		dateOfBirth.add(dateOfBirthLabel);
		dateOfBirth.add(dateOfBirthField);
		northPanel.add(dateOfBirth);
		
		DateFormat dateFormat;
		if(MainFrame.languageChanged) {
			dateFormat = DateFormat.getDateInstance();
		} else {
			dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
		}
		dateOfBirthField.setText(dateFormat.format(student.getDateOfBirth()));
		dateOfBirthField.addFocusListener(new EditStudentListener(2, dateOfBirthField));
		
		
		address = new JPanel();
		addressLabel = new JLabel("Adresa stanovanja*");
		streetField = new JTextField();
		streetNumberField = new JTextField();
		cityField = new JTextField();
		countryField = new JTextField();
		addressLabel.setPreferredSize(new Dimension(200,25));
		streetField.setPreferredSize(new Dimension(85,25));
		streetNumberField.setPreferredSize(new Dimension(30,25));
		cityField.setPreferredSize(new Dimension(75,25));
		countryField.setPreferredSize(new Dimension(75,25));
		streetField.setToolTipText("Ulica");
		streetNumberField.setToolTipText("Broj");
		cityField.setToolTipText("Grad");
		countryField.setToolTipText("Drzava");
		address.add(addressLabel);
		address.add(streetField);
		address.add(streetNumberField);
		address.add(cityField);
		address.add(countryField);
		northPanel.add(address);
		
		Address address = student.getAddress();
		streetField.setText(address.getStreetName());
		streetNumberField.setText(Integer.toString(address.getStreetNumber()));
		cityField.setText(address.getCity());
		countryField.setText(address.getCountry());
		streetField.addFocusListener(new EditStudentListener(3, streetField));
		streetNumberField.addFocusListener(new EditStudentListener(4, streetNumberField));
		cityField.addFocusListener(new EditStudentListener(5, cityField));
		countryField.addFocusListener(new EditStudentListener(6, countryField));
		
		phoneNumber = new JPanel();
		phoneNumberLabel = new JLabel("Broj telefona*");
		phoneNumberField = new JTextField();
		phoneNumberLabel.setPreferredSize(new Dimension(200, 25));
		phoneNumberField.setPreferredSize(new Dimension(280, 25));
		phoneNumber.add(phoneNumberLabel);
		phoneNumber.add(phoneNumberField);
		northPanel.add(phoneNumber);
		
		phoneNumberField.setText(student.getPhoneNumber());
		phoneNumberField.addFocusListener(new EditStudentListener(7, phoneNumberField));
		
		email = new JPanel();
		emailLabel = new JLabel("E-mail adresa*");
		emailField = new JTextField();
		emailLabel.setPreferredSize(new Dimension(200, 25));
		emailField.setPreferredSize(new Dimension(280, 25));
		email.add(emailLabel);
		email.add(emailField);
		northPanel.add(email);
		
		emailField.setText(student.geteMail());
		emailField.addFocusListener(new EditStudentListener(8, emailField));
		
		index = new JPanel();
		indexLabel = new JLabel("Broj indeksa*");
		indexField = new JTextField();
		indexLabel.setPreferredSize(new Dimension(200, 25));
		indexField.setPreferredSize(new Dimension(280, 25));
		index.add(indexLabel);
		index.add(indexField);
		northPanel.add(index);
		
		indexField.setText(student.getIndexID());
		indexField.addFocusListener(new EditStudentListener(9, indexField));
		
		yearOfEnroll = new JPanel();
		yearOfEnrollLabel = new JLabel("Godina upisa*");
		yearOfEnrollField = new JTextField();
		yearOfEnrollLabel.setPreferredSize(new Dimension(200, 25));
		yearOfEnrollField.setPreferredSize(new Dimension(280, 25));
		yearOfEnroll.add(yearOfEnrollLabel);
		yearOfEnroll.add(yearOfEnrollField);
		northPanel.add(yearOfEnroll);
		
		yearOfEnrollField.setText(Integer.toString(student.getYearOfEnroll()));
		yearOfEnrollField.addFocusListener(new EditStudentListener(10, yearOfEnrollField));
		
		String[] currYears = {"I(prva)", "II(druga)", "III(treca)", "IV(cetrvta)"};
		currYearOfStudies = new JPanel();
		currYearOfStudiesLabel = new JLabel("Trenutna godina studija*");
		currYearOfStudiesComboBox = new JComboBox<String>(currYears);
		currYearOfStudiesLabel.setPreferredSize(new Dimension(200, 25));
		currYearOfStudiesComboBox.setPreferredSize(new Dimension(280, 25));
		currYearOfStudiesComboBox.setSelectedIndex(0);
		currYearOfStudies.add(currYearOfStudiesLabel);
		currYearOfStudies.add(currYearOfStudiesComboBox);
		northPanel.add(currYearOfStudies);
		
		currYearOfStudiesComboBox.setSelectedIndex(student.getCurrYearOfStudies()-1);
		
		String[] currStats = {"Budžet", "Samofinansiranje"};
		currStatus = new JPanel();
		currStatusLabel = new JLabel("Status Studenta*");
		currStatusComboBox = new JComboBox<String>(currStats);
		currStatusLabel.setPreferredSize(new Dimension(200, 25));
		currStatusComboBox.setPreferredSize(new Dimension(280, 25));
		currStatusComboBox.setSelectedIndex(0);
		currStatus.add(currStatusLabel);
		currStatus.add(currStatusComboBox);
		northPanel.add(currStatus);
		
		currStatusComboBox.setSelectedIndex(student.getCurrStatus().ordinal());
		
		confirm = new JButton("Potvrdi");
		confirm.setPreferredSize(new Dimension(90,30));
		confirm.setEnabled(false);
		southPanel.add(confirm);
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentController studController = new StudentController();
				studController.edit(student);
				
				if(studController.studentEdited == true) {
					
					ValidationStudent.resetFields();
					EditStudentDialog.getEditStudentDialog().dispose();
					EditStudentPanel.deleteEditStudPanel();
					EditStudentDialog.deleteEditStudentDialog();
					studController.studentEdited = false;
					editStudentInformationTab = null;
				}
				
			}
		});
		
		southPanel.add(Box.createRigidArea(new Dimension(30, 0)));
		
		cancel = new JButton("Odustani");
		cancel.setPreferredSize(new Dimension(90, 30));
		southPanel.add(cancel);
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EditStudentDialog.getEditStudentDialog().dispose();
				EditStudentPanel.deleteEditStudPanel();
				EditStudentDialog.deleteEditStudentDialog();
				StudentTable.getTable().updateTable();
				editStudentInformationTab = null;
				
			}
		});
		
		add(northPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
	}

	public static JButton getConfirm() {
		return confirm;
	}


	public static JTextField getNameField() {
		return nameField;
	}


	public static JTextField getSurnameField() {
		return surnameField;
	}


	public static JTextField getDateOfBirthField() {
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

	public static JTextField getPhoneNumberField() {
		return phoneNumberField;
	}


	public static JTextField getEmailField() {
		return emailField;
	}


	public static JTextField getIndexField() {
		return indexField;
	}

	public static JTextField getYearOfEnrollField() {
		return yearOfEnrollField;
	}


	public static JComboBox<String> getCurrYearOfStudiesComboBox() {
		return currYearOfStudiesComboBox;
	}

	public static JComboBox<String> getCurrStatusComboBox() {
		return currStatusComboBox;
	}

	public static Status getStatus() {
		int statusIndex = currStatusComboBox.getSelectedIndex();
		Status status;
		
		switch(statusIndex) {
		case 0:
			 status = Student.Status.B;
			 break;
		case 1:
			status = Status.S;
			break;
		default:
			status = Status.S;
			break;
		}
		
		return status;
	}
	
	
	public static int getCurrentYearOfStudies() {
		int currYearIndex = currYearOfStudiesComboBox.getSelectedIndex();
		int currYear;
		switch(currYearIndex) {
		case 0:
			currYear = 1;
			break;
		case 1:
			currYear = 2;
			break;
		case 2:
			currYear = 3;
			break;
		case 3:
			currYear = 4;
			break;
		default:
			currYear = 1;
			break;
		
		}
		
		return currYear;
	}

	public static Student getStudent() {
		return student;
	}
	
	public static EditStudentInformationTab getEditStudentInformationTab() {
		
		if (editStudentInformationTab == null) {
			editStudentInformationTab = new EditStudentInformationTab();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();;
		}
		
		return editStudentInformationTab;
	}
	
	public static void deleteEditStudentInformationTab() {
		editStudentInformationTab = null;
	}

	public static void initComponents() {
    	
		nameLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("name"));
		surnameLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("surname"));
		dateOfBirthLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("dateOfBirth"));
		addressLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("address"));
		phoneNumberLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("phoneNumber"));
		emailLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("emailAddress"));
		indexLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("indexNumber"));
		yearOfEnrollLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("yearOfEnroll"));
		currYearOfStudiesLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("currYearOfStudies"));
		currStatusLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("currStatusStudent"));
		
		streetField.setToolTipText(MainFrame.getMainFrame().getResourceBundle().getString("street"));
		streetNumberField.setToolTipText(MainFrame.getMainFrame().getResourceBundle().getString("houseNumber"));
		cityField.setToolTipText(MainFrame.getMainFrame().getResourceBundle().getString("city"));
		countryField.setToolTipText(MainFrame.getMainFrame().getResourceBundle().getString("country"));
		
		if(MainFrame.englishLanguage) {
			String[] currYears = {"I(first)", "II(second)", "III(third)", "IV(Fourth)"};
			currYearOfStudiesComboBox.setModel(new DefaultComboBoxModel<String>(currYears));
			currYearOfStudiesComboBox.setSelectedIndex(student.getCurrStatus().ordinal());
			
			String[] currStatus = {"State-financing", "Self-financing"};
			currStatusComboBox.setModel(new DefaultComboBoxModel<String>(currStatus));
			currStatusComboBox.setSelectedIndex(student.getCurrStatus().ordinal());
		}
		
		confirm.setText(MainFrame.getMainFrame().getResourceBundle().getString("confirmBtn"));
		cancel.setText(MainFrame.getMainFrame().getResourceBundle().getString("cancelBtn"));

	}
		
}
