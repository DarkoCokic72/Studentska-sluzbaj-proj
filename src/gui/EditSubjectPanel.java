package gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EditSubjectPanel extends JTabbedPane {
	private static EditSubjectPanel editSubjPanel = null;
	
	public EditSubjectPanel() {
		JPanel info = new JPanel();
		addTab("Informacije", info);
		info.setLayout(new BorderLayout());
		info.add(new EditSubjectInformationTab());
	}
	
	public static EditSubjectPanel getInstance() {
		if(editSubjPanel == null)
			editSubjPanel = new EditSubjectPanel();
		
		return editSubjPanel;
	}
	
	public static void deleteInstance() {
		editSubjPanel = null;
	}
}
