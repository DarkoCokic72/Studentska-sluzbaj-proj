package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class UnpassedExamsTable extends JTable{
	
	private static UnpassedExamsTable unpassedExamsTable= null;
	private UnpassedExamsAbstractTable model;
	
	private UnpassedExamsTable() {
		
		model = new UnpassedExamsAbstractTable();
		setModel(model);
	    setCellSelectionEnabled(false);
   	    setRowSelectionAllowed(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTableHeader().setReorderingAllowed(false);
			
	}
	
	public static UnpassedExamsTable getTable() {
		if (unpassedExamsTable == null) {
			unpassedExamsTable = new UnpassedExamsTable();
		}
		return unpassedExamsTable;
	}
	
}
