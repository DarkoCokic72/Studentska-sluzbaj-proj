package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.SubjectController;
import Controller.ValidationSubject;
import Listeners.EditSubjectListener;
import Model.Subject;
import Model.SubjectDatabase;
import Model.Subject.Term;

public class EditSubjectInformationTab extends JPanel {
	
	private static EditSubjectInformationTab editSubjectInformationTab = null;
	
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
	
	private JPanel professor;
	private static JTextField professorField;
	private static JLabel professorLabel;
	private static JButton plusBtn;
	private static JButton minusBtn;
	
	private static JButton confirm;
	private static JButton cancel;
	
	public static Subject subject;
	
	public EditSubjectInformationTab() {
		int selectedRow = SubjectJTable.getTable().convertRowIndexToModel(SubjectJTable.getTable().getSelectedRow());
		subject = SubjectDatabase.getDatabase().getSubjectFromRow(selectedRow);
		
		northPanel = new JPanel();
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
		southPanel = new JPanel();
		southPanel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int heigth = d.height;
		int width = d.width;
		setSize(heigth * 3/8, width * 300 / 444);
		
		ValidationSubject.fieldsFilled();
		
		code = new JPanel();
		codeLabel = new JLabel("Šifra predmeta*");
		codeField = new JTextField();
		codeLabel.setPreferredSize(new Dimension(200, 25));
		codeField.setPreferredSize(new Dimension(280, 25));
		code.add(codeLabel);
		code.add(codeField);
		northPanel.add(code);
		
		codeField.setText(subject.getSubjectCode());
		codeField.addFocusListener(new EditSubjectListener(0, codeField));
		
		name = new JPanel();
		nameLabel = new JLabel("Naziv predmeta*");
		nameField = new JTextField();
		nameLabel.setPreferredSize(new Dimension(200, 25));
		nameField.setPreferredSize(new Dimension(280, 25));
		name.add(nameLabel);
		name.add(nameField);
		northPanel.add(name);
		
		nameField.setText(subject.getSubjectName());
		nameField.addFocusListener(new EditSubjectListener(1, nameField));
		
		yearOfStudy = new JPanel();
		yearOfStudyLabel = new JLabel("Godina studija u kojoj se izvodi*");
		yearOfStudyField = new JTextField();
		yearOfStudyLabel.setPreferredSize(new Dimension(200, 25));
		yearOfStudyField.setPreferredSize(new Dimension(280, 25));
		yearOfStudy.add(yearOfStudyLabel);
		yearOfStudy.add(yearOfStudyField);
		northPanel.add(yearOfStudy);
		
		yearOfStudyField.setText(Integer.toString(subject.getYearOfStudy()));
		yearOfStudyField.addFocusListener(new EditSubjectListener(2, yearOfStudyField));
		
		espb = new JPanel();
		espbLabel = new JLabel("ESPB*");
		espbField = new JTextField();
		espbLabel.setPreferredSize(new Dimension(200, 25));
		espbField.setPreferredSize(new Dimension(280, 25));
		espb.add(espbLabel);
		espb.add(espbField);
		northPanel.add(espb);
		
		espbField.setText(Integer.toString(subject.getESPB()));
		espbField.addFocusListener(new EditSubjectListener(3, espbField));
		
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
		
		termComboBox.setSelectedIndex(subject.getTerm().ordinal());
		
		professor = new JPanel();
		professorLabel = new JLabel("Profesor*");
		professorField = new JTextField();
		professorLabel.setPreferredSize(new Dimension(200, 25));
		professorField.setPreferredSize(new Dimension(180, 25));
		plusBtn = new JButton("+");
		minusBtn = new JButton("-");
		plusBtn.setPreferredSize(new Dimension(45, 25));
		minusBtn.setPreferredSize(new Dimension(45, 25));
		professor.add(professorLabel);
		professor.add(professorField);
		professor.add(plusBtn);
		professor.add(minusBtn);
		northPanel.add(professor);
		
		if(subject.getSubjectProfessor() != null) {
			String professorString = subject.getSubjectProfessor().getName() + " " + subject.getSubjectProfessor().getSurname();
			professorField.setText(professorString);
		}
		
		professorField.setEditable(false);
		if(professorField.getText().isEmpty() == false) {
			plusBtn.setEnabled(false);
		}
		else {
			minusBtn.setEnabled(false);
		}
		
		plusBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ChooseProfessorDialog chooseProfessorDialog = ChooseProfessorDialog.getChooseProfessorDialog();
				chooseProfessorDialog.setLocationRelativeTo(MainFrame.getMainFrame());		
				
			}
		});
		
		minusBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				RemoveProfessorFromSubjectDialog removeProfessorDialog = RemoveProfessorFromSubjectDialog.getRemoveProfessorDialog();
				removeProfessorDialog.setLocationRelativeTo(MainFrame.getMainFrame());		
				
			}
		});
		
		confirm = new JButton("Potvrdi");
		confirm.setPreferredSize(new Dimension(90,30));
		confirm.setEnabled(false);
		southPanel.add(confirm);
		
		confirm.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SubjectController subjectContr = SubjectController.getSubjectController();
				subjectContr.edit(subject);
				
				if(subjectContr.subjectEdited == true) {
					ValidationSubject.resetFields();
					EditSubjectDialog.getInstance().dispose();
					EditSubjectPanel.deleteInstance();
					EditSubjectDialog.deleteInstance();
					subjectContr.subjectEdited = false;
					editSubjectInformationTab = null;
				}
				
			}
		});
		
		southPanel.add(Box.createRigidArea(new Dimension(30,0)));
		
		cancel = new JButton("Odustani");
		cancel.setPreferredSize(new Dimension(90, 30));
		southPanel.add(cancel);
		
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EditSubjectDialog.getInstance().dispose();
				EditSubjectPanel.deleteInstance();
				EditSubjectDialog.deleteInstance();
				SubjectJTable.getTable().updateTable();
				editSubjectInformationTab = null;
				
			}
		});
		
		add(northPanel, BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
	}

	public static JTextField getCodeField() {
		return codeField;
	}

	public static JTextField getNameField() {
		return nameField;
	}

	public static JTextField getYearOfStudyField() {
		return yearOfStudyField;
	}

	public static JTextField getEspbField() {
		return espbField;
	}
	
	public static JTextField getProfessorField() {
		return professorField;
	}

	public static JComboBox<String> getTermComboBox() {
		return termComboBox;
	}
	
	public static JButton getConfirm() {
		return confirm;
	}

	public static JButton getPlus() {
		return plusBtn;
	}
	
	public static JButton getMinus() {
		return minusBtn;
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

	
	public static EditSubjectInformationTab getEditSubjectInformationTab() {
		
		if (editSubjectInformationTab == null) {
			editSubjectInformationTab = new EditSubjectInformationTab();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();;
		}
		
		return editSubjectInformationTab;
	}
	
	public static void deleteEditSubjectInformationTab() {
		editSubjectInformationTab = null;
	}
	
	public static void initComponents() {
		
    	codeLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("subjectCode"));
    	nameLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("subjectName"));
    	yearOfStudyLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("yearOfStudy"));
    	espbLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("ESPB"));
    	termLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("subjectTerm"));
    	professorLabel.setText(MainFrame.getMainFrame().getResourceBundle().getString("subjectProfessor"));
    		
		confirm.setText(MainFrame.getMainFrame().getResourceBundle().getString("confirmBtn"));
		cancel.setText(MainFrame.getMainFrame().getResourceBundle().getString("cancelBtn"));

	}
	
	
}
