package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.StudentController;
import Controller.ValidationStudent;
import Listeners.AddProfessorListener;
import Listeners.AddStudentListener;
import Model.Student;
import Model.Student.Status;


public class AddStudentDialog extends JDialog {
	
	public static AddStudentDialog addStudentDialog = null;
	
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
		nameField.setPreferredSize(new Dimension(280, 25));
		name.add(nameLabel);
		name.add(nameField);
		northPanel.add(name);
		nameField.addFocusListener(new AddStudentListener(nameField, 0));
		
		surname = new JPanel();
		surnameLabel = new JLabel("Prezime*");
		surnameField = new JTextField();
		surnameLabel.setPreferredSize(new Dimension(200, 25));
		surnameField.setPreferredSize(new Dimension(280, 25));
		surname.add(surnameLabel);
		surname.add(surnameField);
		northPanel.add(surname);
		surnameField.addFocusListener(new AddStudentListener(surnameField, 1));
		
		dateOfBirth = new JPanel();
		dateOfBirthLabel = new JLabel("Datum rodjenja*");
		dateOfBirthField = new JTextField();
		dateOfBirthLabel.setPreferredSize(new Dimension(200, 25));
		dateOfBirthField.setPreferredSize(new Dimension(280, 25));
		dateOfBirth.add(dateOfBirthLabel);
		dateOfBirth.add(dateOfBirthField);
		northPanel.add(dateOfBirth);
		dateOfBirthField.addFocusListener(new AddStudentListener(dateOfBirthField, 2));
		
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
		streetField.addFocusListener(new AddStudentListener(streetField, 3));
		streetNumberField.addFocusListener(new AddStudentListener(streetNumberField, 4));
		cityField.addFocusListener(new AddStudentListener(cityField, 5));
		countryField.addFocusListener(new AddStudentListener(countryField, 6));
		
		phoneNumber = new JPanel();
		phoneNumberLabel = new JLabel("Broj telefona*");
		phoneNumberField = new JTextField();
		phoneNumberLabel.setPreferredSize(new Dimension(200, 25));
		phoneNumberField.setPreferredSize(new Dimension(280, 25));
		phoneNumber.add(phoneNumberLabel);
		phoneNumber.add(phoneNumberField);
		northPanel.add(phoneNumber);
		phoneNumberField.addFocusListener(new AddStudentListener(phoneNumberField, 7));
		
		email = new JPanel();
		emailLabel = new JLabel("E-mail adresa*");
		emailField = new JTextField();
		emailLabel.setPreferredSize(new Dimension(200, 25));
		emailField.setPreferredSize(new Dimension(280, 25));
		email.add(emailLabel);
		email.add(emailField);
		northPanel.add(email);
		emailField.addFocusListener(new AddStudentListener(emailField, 8));
		
		index = new JPanel();
		indexLabel = new JLabel("Broj indeksa*");
		indexField = new JTextField();
		indexLabel.setPreferredSize(new Dimension(200, 25));
		indexField.setPreferredSize(new Dimension(280, 25));
		index.add(indexLabel);
		index.add(indexField);
		northPanel.add(index);
		indexField.addFocusListener(new AddStudentListener(indexField, 9));
		
		yearOfEnroll = new JPanel();
		yearOfEnrollLabel = new JLabel("Godina upisa*");
		yearOfEnrollField = new JTextField();
		yearOfEnrollLabel.setPreferredSize(new Dimension(200, 25));
		yearOfEnrollField.setPreferredSize(new Dimension(280, 25));
		yearOfEnroll.add(yearOfEnrollLabel);
		yearOfEnroll.add(yearOfEnrollField);
		northPanel.add(yearOfEnroll);
		yearOfEnrollField.addFocusListener(new AddStudentListener(yearOfEnrollField, 10));
		
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
					addStudentDialog = null;
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
				addStudentDialog = null;
			}
		});
		
		add(northPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				addStudentDialog = null;
			}
		});
		
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
	
	public static AddStudentDialog getAddStudentDialog() {
		
		if (addStudentDialog == null) {
			addStudentDialog = new AddStudentDialog();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();;
		}
		
		return addStudentDialog;
	}
	
	public static void initComponents() {
		
    	addStudentDialog.setTitle(MainFrame.getMainFrame().getResourceBundle().getString("addStudentDialogTitle"));
    	
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
			
			String[] currStatus = {"State-financing", "Self-financing"};
			currStatusComboBox.setModel(new DefaultComboBoxModel<String>(currStatus));
		}
		
		confirm.setText(MainFrame.getMainFrame().getResourceBundle().getString("confirmBtn"));
		cancel.setText(MainFrame.getMainFrame().getResourceBundle().getString("cancelBtn"));

	}
	
}
