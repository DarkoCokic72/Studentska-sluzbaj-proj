package Listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import Controller.Validation;

public class GradeEntryListener implements FocusListener{

	private JTextField textField;
	
	public GradeEntryListener(JTextField textField) {
		super();
		this.textField = textField;
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		Validation.validateGradeEntry(textField.getText().trim());
		
	}

}
