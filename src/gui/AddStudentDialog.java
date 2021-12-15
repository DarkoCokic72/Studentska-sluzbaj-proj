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

import Controller.StudentController;
import Controller.ValidationStudent;
import Listeners.AddStudentListener;
import Model.Student;
import Model.Student.Status;


public class AddStudentDialog extends JDialog {
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
	
	//Embrace the boredom
	
	public AddStudentDialog() {
		northPanel = new JPanel();
		southPanel = new JPanel();
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width * 3/8, height * 300 /444);
		ImageIcon img = new ImageIcon("images/Plus-icon.png");
		setIconImage(img.getImage());
		setTitle("Dodavanje studenta");
		setResizable(false);
		
		ValidationStudent.resetFields();
		
		name = new JPanel();
		nameLabel = new JLabel("Ime*");
		nameField = new JTextField();
		nameLabel.setPreferredSize(new Dimension(200, 25));
		nameField.setPreferredSize(new Dimension(200, 25));
		name.add(nameLabel);
		name.add(nameField);
		northPanel.add(name);
		nameField.addFocusListener(new AddStudentListener(nameField, 0));
		
		surname = new JPanel();
		surnameLabel = new JLabel("Prezime*");
		surnameField = new JTextField();
		surnameLabel.setPreferredSize(new Dimension(200, 25));
		surnameField.setPreferredSize(new Dimension(200, 25));
		surname.add(surnameLabel);
		surname.add(surnameField);
		northPanel.add(surname);
		nameField.addFocusListener(new AddStudentListener(surnameField, 1));
		
		dateOfBirth = new JPanel();
		dateOfBirthLabel = new JLabel("Datum rodjenja*");
		dateOfBirthField = new JTextField();
		dateOfBirthLabel.setPreferredSize(new Dimension(200, 25));
		dateOfBirthField.setPreferredSize(new Dimension(200, 25));
		dateOfBirth.add(dateOfBirthLabel);
		dateOfBirth.add(dateOfBirthField);
		northPanel.add(dateOfBirth);
		dateOfBirthField.addFocusListener(new AddStudentListener(dateOfBirthField, 2));
		
		address = new JPanel();
		addressLabel = new JLabel("Adresa*");
		addressField = new JTextField();
		addressLabel.setPreferredSize(new Dimension(200, 25));
		addressField.setPreferredSize(new Dimension(200, 25));
		address.add(addressLabel);
		address.add(addressField);
		northPanel.add(address);
		addressField.addFocusListener(new AddStudentListener(addressField, 3));
		
		phoneNumber = new JPanel();
		phoneNumberLabel = new JLabel("Broj telefona*");
		phoneNumberField = new JTextField();
		phoneNumberLabel.setPreferredSize(new Dimension(200, 25));
		phoneNumberField.setPreferredSize(new Dimension(200, 25));
		phoneNumber.add(phoneNumberLabel);
		phoneNumber.add(phoneNumberField);
		northPanel.add(phoneNumber);
		phoneNumberField.addFocusListener(new AddStudentListener(phoneNumberField, 4));
		
		email = new JPanel();
		emailLabel = new JLabel("E-mail adresa*");
		emailField = new JTextField();
		emailLabel.setPreferredSize(new Dimension(200, 25));
		emailField.setPreferredSize(new Dimension(200, 25));
		email.add(emailLabel);
		email.add(emailField);
		northPanel.add(email);
		emailField.addFocusListener(new AddStudentListener(emailField, 5));
		
		index = new JPanel();
		indexLabel = new JLabel("Broj indeksa*");
		indexField = new JTextField();
		indexLabel.setPreferredSize(new Dimension(200, 25));
		indexField.setPreferredSize(new Dimension(200, 25));
		index.add(indexLabel);
		index.add(indexField);
		northPanel.add(index);
		indexField.addFocusListener(new AddStudentListener(indexField, 6));
		
		yearOfEnroll = new JPanel();
		yearOfEnrollLabel = new JLabel("Godina upisa*");
		yearOfEnrollField = new JTextField();
		yearOfEnrollLabel.setPreferredSize(new Dimension(200, 25));
		yearOfEnrollField.setPreferredSize(new Dimension(200, 25));
		yearOfEnroll.add(yearOfEnrollLabel);
		yearOfEnroll.add(yearOfEnrollField);
		northPanel.add(yearOfEnroll);
		yearOfEnrollField.addFocusListener(new AddStudentListener(yearOfEnrollField, 7));
		
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
		
		confirm = new JButton("Potvrdi");
		confirm.setPreferredSize(new Dimension(90,30));
		confirm.setEnabled(false);
		southPanel.add(confirm);
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StudentController studContr = StudentController.getStudentConstroler();
				studContr.add();
				if(studContr.studentAdded == true) {
					ValidationStudent.resetFields();
					dispose();
					studContr.studentAdded = false;
				}
				
			}
		});
		
		southPanel.add(Box.createRigidArea(new Dimension(30,0)));
		
		cancel = new JButton("Odustani");
		cancel.setPreferredSize(new Dimension(90,30));
		southPanel.add(cancel);
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ValidationStudent.resetFields();
				dispose();
			}
		});
		
		add(northPanel, BorderLayout.CENTER);
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

	public JLabel getEmailLabel() {
		return emailLabel;
	}

	public static JTextField getIndexField() {
		return indexField;
	}


	public static JTextField getYearOfEnrollField() {
		return yearOfEnrollField;
	}

	public JLabel getYearOfEnrollLabel() {
		return yearOfEnrollLabel;
	}

	public JLabel getCurrYearOfStudiesLabel() {
		return currYearOfStudiesLabel;
	}

	public JPanel getCurrStatus() {
		return currStatus;
	}

	public static JButton getConfirm() {
		return confirm;
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

	public static JComboBox<String> getCurrYearOfStudiesComboBox() {
		return currYearOfStudiesComboBox;
	}

	public static JComboBox<String> getCurrStatusComboBox() {
		return currStatusComboBox;
	}
	
	
}
