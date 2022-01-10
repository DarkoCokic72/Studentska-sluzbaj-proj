package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class PassedExamsTable extends JTable{
	private static PassedExamsTable passedExamsTable = null;
	private PassedExamsAbstractTable model;
	
	public PassedExamsTable() {
		model = new PassedExamsAbstractTable();
		setModel(model);
	    setCellSelectionEnabled(false);
   	    setRowSelectionAllowed(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTableHeader().setReorderingAllowed(false);
	}
	
	public void updateTable() {
    	model.fireTableDataChanged();
    }
	
	public static PassedExamsTable getInstance() {
		if(passedExamsTable == null)
			passedExamsTable = new PassedExamsTable();
		
		return passedExamsTable;
	}
	
	
}
