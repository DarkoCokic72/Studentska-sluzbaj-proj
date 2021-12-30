package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Validation;

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
			JOptionPane.showMessageDialog(null, "Selektujte vrstu u kom se nalazi predmet za koji zelite da unesete ocenu");
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
		//subjectCodeField.addFocusListener(new AddProfessorListener(subjectCodeField, 0));
		
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
		//subjectNameField.addFocusListener(new AddProfessorListener(subjectNameField, 1));
		
		String grades[] = {"5", "6", "7", "8", "9", "10"};
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
		//subjectNameField.addFocusListener(new AddProfessorListener(subjectNameField, 2));
		
		confirm = new JButton("Potvrdi");
		confirm.setPreferredSize(new Dimension(90,30));
		confirm.setEnabled(false);
		southPanel.add(confirm);
		
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
	
	

}
