package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class UnpassedExamsTable extends JTable{
	
	private static UnpassedExamsTable unpassedExamsTable= null;
	private UnpassedExamsAbstractTable model;
	
	public UnpassedExamsTable() {
		
		model = new UnpassedExamsAbstractTable();
		setModel(model);
		setRowSelectionAllowed(true);
		setCellSelectionEnabled(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTableHeader().setReorderingAllowed(false);
			
	}

}
