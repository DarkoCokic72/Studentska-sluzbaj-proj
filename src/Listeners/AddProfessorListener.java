package Listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import Controller.ProfessorController;

public class AddProfessorListener implements FocusListener{
	
	private JTextField textField;
	private int fieldNumber;
	
    public AddProfessorListener(JTextField textField, int fieldNumber) {
		
		this.textField = textField;
		this.fieldNumber = fieldNumber;
	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent arg0) {

		ProfessorController.getProfessorController().validateAdd(textField.getText().trim(), fieldNumber);

	}
	
}

