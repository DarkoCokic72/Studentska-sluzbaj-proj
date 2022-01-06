package Listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import Controller.ValidationSubject;

public class AddSubjectListener implements FocusListener{
	private JTextField textField;
	private int fieldNUm;
	
	public AddSubjectListener(JTextField textField, int num) {
		
		this.textField = textField;
		this.fieldNUm = num;
	}
	
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		ValidationSubject.validateAdd(textField.getText().trim(), fieldNUm);
	}

}
