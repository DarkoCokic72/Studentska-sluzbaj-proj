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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.GradeController;
import Controller.Validation;
import Listeners.GradeEntryListener;

public class GradeEntryDialog extends JDialog{
	
	private JPanel subjectCode;
	private static JTextField subjectCodeField;
	private JLabel subjectCodeLab;
	
	private JPanel subjectName;
	private static JTextField subjectNameField;
	private JLabel subjectNameLab;
	
	private JPanel grade;
	private static JComboBox<String> gradeComboBox;
	private JLabel gradeLab;
	
	private JPanel date;
	private static JTextField dateField;
	private JLabel dateLab;
	
	private static JButton confirm;
	private JButton cancel;
	
	public GradeEntryDialog() {
		
		int selectedRow = UnpassedExamsTable.getTable().convertRowIndexToModel(UnpassedExamsTable.getTable().getSelectedRow());
		if(selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Selektujte vrstu u kojoj se nalazi predmet za koji zelite da unesete ocenu");
			return;
		}
		
		JPanel northPanel = new JPanel();
		JPanel southPanel = new JPanel();
		
		setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width*3/16, height*25/72);
		setTitle("Unos ocene");
		ImageIcon img = new ImageIcon("images/Plus-icon.png");
		setIconImage(img.getImage());
		setResizable(false);
		
		subjectCode = new JPanel();
		subjectCodeLab = new JLabel("Sifra*");
		subjectCodeField = new JTextField();
		subjectCodeLab.setPreferredSize(new Dimension(100,25));
		subjectCodeField.setPreferredSize(new Dimension(100,25));
		subjectCodeField.setText(new UnpassedExamsAbstractTable().getValueAt(UnpassedExamsTable.getTable().convertRowIndexToModel(UnpassedExamsTable.getTable().getSelectedRow()), 0));
		subjectCodeField.setEnabled(false);
		subjectCode.add(subjectCodeLab);
		subjectCode.add(subjectCodeField);
		northPanel.add(subjectCode);
		
		subjectName = new JPanel();
		subjectNameLab = new JLabel("Naziv*");
		subjectNameField = new JTextField();
		subjectNameLab.setPreferredSize(new Dimension(100,25));
		subjectNameField.setPreferredSize(new Dimension(100,25));
		subjectNameField.setText(new UnpassedExamsAbstractTable().getValueAt(UnpassedExamsTable.getTable().convertRowIndexToModel(UnpassedExamsTable.getTable().getSelectedRow()), 1));
		subjectNameField.setEnabled(false);
		subjectName.add(subjectNameLab);
		subjectName.add(subjectNameField);
		northPanel.add(subjectName);
		
		String grades[] = {"6", "7", "8", "9", "10"};
		grade = new JPanel();
		gradeLab = new JLabel("Ocena*");
		gradeComboBox = new JComboBox<String>(grades);
		gradeLab.setPreferredSize(new Dimension(100,25));
		gradeComboBox.setPreferredSize(new Dimension(100,25));
		gradeComboBox.setSelectedIndex(0);
		grade.add(gradeLab);
		grade.add(gradeComboBox);
		northPanel.add(grade);
		
		date = new JPanel();
		dateLab = new JLabel("Datum*");
		dateField = new JTextField();
		dateLab.setPreferredSize(new Dimension(100,25));
		dateField.setPreferredSize(new Dimension(100,25));
		date.add(dateLab);
		date.add(dateField);
		northPanel.add(date);
		Validation.textFieldFilledGradeEntry = false;
		dateField.addFocusListener(new GradeEntryListener(subjectNameField));
		
		
		confirm = new JButton("Potvrdi");
		confirm.setPreferredSize(new Dimension(90,30));
		confirm.setEnabled(false);
		southPanel.add(confirm);
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
					GradeController gradeContr = GradeController.getGradeController();
					gradeContr.entry();
					
					if(GradeController.gradeEntried) {
						
						Validation.textFieldFilledGradeEntry = false;
						dispose();
						GradeController.gradeEntried = false;
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
		    	
		    	Validation.textFieldFilledGradeEntry = false;
				dispose();
			}

		});
		
		add(northPanel,BorderLayout.CENTER);
		add(southPanel, BorderLayout.SOUTH);
		
		revalidate(); 
		repaint();
		
	}
	
	public static JTextField getSubjectCodeField() {
		return subjectCodeField;
	}
	
	public static JTextField getSubjectNameField() {
		return subjectNameField;
	}
	
	public static int getGrade() {
	        
		int gradeIndex = gradeComboBox.getSelectedIndex();
	   	int grade;
	    	
		switch (gradeIndex) {
		case 0:
			grade = 6;
			break;
		case 1:
			grade = 7;
			break;
		case 2:
			grade = 8;
			break;
		case 3:
			grade = 9;
			break;
		case 4:
			grade = 10;
			break;
		default:
			grade = 6;
				
		}
			
		return grade;
    }
	
    public static JTextField getDate() {
    	return dateField;
    } 
    
    public static JButton getConfirm() {
    	return confirm;
    }
    
	
}
