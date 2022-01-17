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

import Controller.SubjectController;
import Controller.ValidationSubject;
import Listeners.AddSubjectListener;
import Model.Subject;
import Model.Subject.Term;

public class AddSubjectDialog extends JDialog {
	
	private static AddSubjectDialog addSubjectDialog = null;
	
	private JPanel northPanel;
	private JPanel southPanel;
	
	private JPanel code;
	private static JTextField codeField;
	private static JLabel codeLabel;
	
	private JPanel name;
	private static JTextField nameField;
	private static JLabel nameLabel;
	
	private JPanel yearOfStudy;
	private static JTextField yearOfStudyField;
	private static JLabel yearOfStudyLabel;
	
	private JPanel espb;
	private static JTextField espbField;
	private static JLabel espbLabel;
	
	private JPanel term;
	private static JComboBox<String> termComboBox;
	private static JLabel termLabel;
	
	private static JButton confirm;
	private static JButton cancel;
	
	public AddSubjectDialog() {
		northPanel = new JPanel();
		southPanel = new JPanel();
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width * 3/8, height * 300 /444);
		ImageIcon img = new ImageIcon("images/Plus-icon.png");
		setIconImage(img.getImage());
		setTitle("Dodavanje predmeta");
		setResizable(false);
		
		ValidationSubject.resetFields();
		
		code = new JPanel();
		codeLabel = new JLabel("Šifra predemeta*");
		codeField = new JTextField();
		codeLabel.setPreferredSize(new Dimension(200, 25));
		codeField.setPreferredSize(new Dimension(280, 25));
		code.add(codeLabel);
		code.add(codeField);
		northPanel.add(code);
		codeField.addFocusListener(new AddSubjectListener(codeField, 0));
		
		name = new JPanel();
		nameLabel = new JLabel("Naziv predemeta*");
		nameField = new JTextField();
		nameLabel.setPreferredSize(new Dimension(200, 25));
		nameField.setPreferredSize(new Dimension(280, 25));
		name.add(nameLabel);
		name.add(nameField);
		northPanel.add(name);
		nameField.addFocusListener(new AddSubjectListener(nameField, 1));
		
		yearOfStudy = new JPanel();
		yearOfStudyLabel = new JLabel("Godina studija u kojoj se izvodi*");
		yearOfStudyField = new JTextField();
		yearOfStudyLabel.setPreferredSize(new Dimension(200, 25));
		yearOfStudyField.setPreferredSize(new Dimension(280, 25));
		yearOfStudy.add(yearOfStudyLabel);
		yearOfStudy.add(yearOfStudyField);
		northPanel.add(yearOfStudy);
		yearOfStudyField.addFocusListener(new AddSubjectListener(yearOfStudyField, 2));
		
		espb = new JPanel();
		espbLabel = new JLabel("ESPB*");
		espbField = new JTextField();
		espbLabel.setPreferredSize(new Dimension(200, 25));
		espbField.setPreferredSize(new Dimension(280, 25));
		espb.add(espbLabel);
		espb.add(espbField);
		northPanel.add(espb);
		espbField.addFocusListener(new AddSubjectListener(espbField, 3));
		
		String[] terms = {"Zimski", "Letnji"};
		term = new JPanel();
		termLabel = new JLabel("Semestar*");
		termComboBox = new JComboBox<String>(terms);
		termLabel.setPreferredSize(new Dimension(200, 25));
		termComboBox.setPreferredSize(new Dimension(280, 25));
		termComboBox.setSelectedIndex(0);
		term.add(termLabel);
		term.add(termComboBox);
		northPanel.add(term);
		
		confirm = new JButton("Potvrdi");
		confirm.setPreferredSize(new Dimension(90,30));
		confirm.setEnabled(false);
		southPanel.add(confirm);
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SubjectController subjController = SubjectController.getSubjectController();
				subjController.add();
				if(subjController.subjectAdded == true) {
					ValidationSubject.resetFields();
					dispose();
					subjController.subjectAdded = false;
					addSubjectDialog = null;
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
				// TODO Auto-generated method stub
				ValidationSubject.resetFields();
				dispose();
				addSubjectDialog = null;
				
			}
		});
		
		add(northPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				addSubjectDialog = null;
			}
		});
		
		
		revalidate();
		repaint();
		
	}

	

	public static JTextField getCodeField() {
		return codeField;
	}



	public JLabel getCodeLabel() {
		return codeLabel;
	}



	public static JTextField getNameField() {
		return nameField;
	}



	public JLabel getNameLabel() {
		return nameLabel;
	}



	public static JTextField getYearOfStudyField() {
		return yearOfStudyField;
	}



	public JLabel getYearOfStudyLabel() {
		return yearOfStudyLabel;
	}



	public static JTextField getEspbField() {
		return espbField;
	}



	public JLabel getEspbLabel() {
		return espbLabel;
	}



	public static JComboBox<String> getTermComboBox() {
		return termComboBox;
	}



	public JLabel getTermLabel() {
		return termLabel;
	}



	public static JButton getConfirm() {
		return confirm;
	}
	
	public static Term getTerm() {
		int index = termComboBox.getSelectedIndex();
		Term term = null;
		
		switch (index) {
		case 0:
			term = Subject.Term.WINTER;
			break;
		case 1:
			term = Term.SUMMER;
			break;
		}
		return term;
	}
	
	public static AddSubjectDialog getAddSubjectDialog() {
		
		if (addSubjectDialog == null) {
			addSubjectDialog = new AddSubjectDialog();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();;
		}
		
		return addSubjectDialog;
	}
	
	public static void initComponents() {
		
    	addSubjectDialog.setTitle(MainFrame.getMainFrame().getResourceBundle().getString("addSubjectDialogTitle"));
    	codeLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("subjectCode"));
    	nameLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("subjectName"));
    	yearOfStudyLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("yearOfStudy"));
    	espbLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("ESPB"));
    	termLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("subjectTerm"));
    	if(MainFrame.englishLanguage) {
    		String[] terms = {"Winter", "Summer"};
    		termComboBox.setModel(new DefaultComboBoxModel<String>(terms));
    	}
    		
		confirm.setText(MainFrame.getMainFrame().getResourceBundle().getString("confirmBtn"));
		cancel.setText(MainFrame.getMainFrame().getResourceBundle().getString("cancelBtn"));

	}
	
}
