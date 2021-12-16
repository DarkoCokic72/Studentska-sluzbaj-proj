package Listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import Controller.ValidationStudent;

public class EditStudentListener implements FocusListener{
	private int fieldNumber;
	private JTextField textField;
	
	public EditStudentListener(int fieldNumber, JTextField textField) {
		super();
		this.fieldNumber = fieldNumber;
		this.textField = textField;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		ValidationStudent.validateEdit(textField.getText().trim(), fieldNumber);
	}
	
	
	
	
}
