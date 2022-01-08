package Listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import Controller.ValidationSubject;

public class EditSubjectListener  implements FocusListener{
	
	private int fieldNumber;
	private JTextField textField;
	
	public EditSubjectListener(int fieldNum, JTextField texField) {
		super();
		
		this.fieldNumber = fieldNum;
		this.textField = texField;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
		ValidationSubject.validateEdit(textField.getText().trim(), fieldNumber);
		
	}

}
