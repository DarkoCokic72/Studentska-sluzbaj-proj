package Listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import Controller.StudentController;

public class AddStudentListener implements FocusListener{
	private JTextField textField;
	private int fieldNum;
	
	public AddStudentListener(JTextField textField, int fieldNum) {
		this.textField = textField;
		this.fieldNum = fieldNum;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		StudentController.getStudentConstroler().validateAdd(textField.getText().trim(), fieldNum);
		
	}
	
	
}
