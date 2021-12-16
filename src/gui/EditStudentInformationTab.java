package gui;

import java.awt.BorderLayout;
import java.awt.Component;
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

import Controller.StudentController;
import Controller.ValidationStudent;
import Listeners.EditStudentListener;
import Model.Student;
import Model.Student.Status;
import Model.StudentDatabase;

public class EditStudentInformationTab extends JPanel {
	private JPanel northPanel;
	private JPanel southPanel;
	
	private JPanel name;
	private static JTextField nameField;
	private JLabel nameLabel;
	
	private JPanel surname;
	private static JTextField surnameField;
	private JLabel surnameLabel;
	
	private JPanel dateOfBirth;
	private static JTextField dateOfBirthField;
	private JLabel dateOfBirthLabel;
	
	private JPanel address;
	private static JTextField addressField;
	private JLabel addressLabel;
	
	private JPanel phoneNumber;
	private static JTextField phoneNumberField;
	private JLabel phoneNumberLabel;
	
	private JPanel email;
	private static JTextField emailField;
	private JLabel emailLabel;
	
	private JPanel index;
	private static JTextField indexField;
	private JLabel indexLabel;
	
	private JPanel yearOfEnroll;
	private static JTextField yearOfEnrollField;
	private JLabel yearOfEnrollLabel;
	
	private JPanel currYearOfStudies;
	private static JComboBox<String> currYearOfStudiesComboBox;
	private JLabel currYearOfStudiesLabel;
	
	private JPanel currStatus;
	private static JComboBox<String> currStatusComboBox;
	private JLabel currStatusLabel;
	
	private static JButton confirm;
	private JButton cancel;
	
	public EditStudentInformationTab() {
		int selectedRow = StudentTable.getTable().convertRowIndexToModel(StudentTable.getTable().getSelectedRow());
		Student student = StudentDatabase.getInstance().getStudentFromRow(selectedRow);
		
		
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
		nameField.setPreferredSize(new Dimension(200, 25));
		name.add(nameLabel);
		name.add(nameField);
		northPanel.add(name);
		
		nameField.setText(student.getName());
		nameField.addFocusListener(new EditStudentListener(0, nameField));
		
		surname = new JPanel();
		surnameLabel = new JLabel("Prezime*");
		surnameField = new JTextField();
		surnameLabel.setPreferredSize(new Dimension(200, 25));
		surnameField.setPreferredSize(new Dimension(200, 25));
		surname.add(surnameLabel);
		surname.add(surnameField);
		northPanel.add(surname);
		
		surnameField.setText(student.getSurname());
		surnameField.addFocusListener(new EditStudentListener(1, surnameField));
		
		dateOfBirth = new JPanel();
		dateOfBirthLabel = new JLabel("Datum rodjenja*");
		dateOfBirthField = new JTextField();
		dateOfBirthLabel.setPreferredSize(new Dimension(200, 25));
		dateOfBirthField.setPreferredSize(new Dimension(200, 25));
		dateOfBirth.add(dateOfBirthLabel);
		dateOfBirth.add(dateOfBirthField);
		northPanel.add(dateOfBirth);
		
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
		dateOfBirthField.setText(dateFormat.format(student.getDateOfBirth()));
		dateOfBirthField.addFocusListener(new EditStudentListener(2, dateOfBirthField));
		
		
		address = new JPanel();
		addressLabel = new JLabel("Adresa*");
		addressField = new JTextField();
		addressLabel.setPreferredSize(new Dimension(200, 25));
		addressField.setPreferredSize(new Dimension(200, 25));
		address.add(addressLabel);
		address.add(addressField);
		northPanel.add(address);
		
		String addressStr = student.getAddress().getStreetName() + Integer.toString(student.getAddress().getStreetNumber()) + ", "
				+ student.getAddress().getCity() + ", " + student.getAddress().getCountry();
		addressField.setText(addressStr);
		addressField.addFocusListener(new EditStudentListener(3, addressField));
		
		phoneNumber = new JPanel();
		phoneNumberLabel = new JLabel("Broj telefona*");
		phoneNumberField = new JTextField();
		phoneNumberLabel.setPreferredSize(new Dimension(200, 25));
		phoneNumberField.setPreferredSize(new Dimension(200, 25));
		phoneNumber.add(phoneNumberLabel);
		phoneNumber.add(phoneNumberField);
		northPanel.add(phoneNumber);
		
		phoneNumberField.setText(student.getPhoneNumber());
		phoneNumberField.addFocusListener(new EditStudentListener(4, phoneNumberField));
		
		email = new JPanel();
		emailLabel = new JLabel("E-mail adresa*");
		emailField = new JTextField();
		emailLabel.setPreferredSize(new Dimension(200, 25));
		emailField.setPreferredSize(new Dimension(200, 25));
		email.add(emailLabel);
		email.add(emailField);
		northPanel.add(email);
		
		emailField.setText(student.geteMail());
		emailField.addFocusListener(new EditStudentListener(5, emailField));
		
		index = new JPanel();
		indexLabel = new JLabel("Broj indeksa*");
		indexField = new JTextField();
		indexLabel.setPreferredSize(new Dimension(200, 25));
		indexField.setPreferredSize(new Dimension(200, 25));
		index.add(indexLabel);
		index.add(indexField);
		northPanel.add(index);
		
		indexField.setText(student.getIndexID());
		indexField.addFocusListener(new EditStudentListener(6, indexField));
		
		yearOfEnroll = new JPanel();
		yearOfEnrollLabel = new JLabel("Godina upisa*");
		yearOfEnrollField = new JTextField();
		yearOfEnrollLabel.setPreferredSize(new Dimension(200, 25));
		yearOfEnrollField.setPreferredSize(new Dimension(200, 25));
		yearOfEnroll.add(yearOfEnrollLabel);
		yearOfEnroll.add(yearOfEnrollField);
		northPanel.add(yearOfEnroll);
		
		yearOfEnrollField.setText(Integer.toString(student.getYearOfEnroll()));
		yearOfEnrollField.addFocusListener(new EditStudentListener(7, yearOfEnrollField));
		
		String[] currYears = {"I(prva)", "II(druga)", "III(treca)", "IV(cetrvta)"};
		currYearOfStudies = new JPanel();
		currYearOfStudiesLabel = new JLabel("Trenutna godina studija*");
		currYearOfStudiesComboBox = new JComboBox<String>(currYears);
		currYearOfStudiesLabel.setPreferredSize(new Dimension(200, 25));
		currYearOfStudiesComboBox.setPreferredSize(new Dimension(200, 25));
		currYearOfStudiesComboBox.setSelectedIndex(0);
		currYearOfStudies.add(currYearOfStudiesLabel);
		currYearOfStudies.add(currYearOfStudiesComboBox);
		northPanel.add(currYearOfStudies);
		
		currYearOfStudiesComboBox.setSelectedIndex(student.getCurrYearOfStudies()-1);
		
		String[] currStats = {"Budzet", "Samofinansiranje"};
		currStatus = new JPanel();
		currStatusLabel = new JLabel("Status Studenta*");
		currStatusComboBox = new JComboBox<String>(currStats);
		currStatusLabel.setPreferredSize(new Dimension(200, 25));
		currStatusComboBox.setPreferredSize(new Dimension(200, 25));
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



	public static JTextField getAddressField() {
		return addressField;
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

		
}
