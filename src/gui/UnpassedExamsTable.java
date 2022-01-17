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
	
	 public void updateTable() {
	    	model.fireTableDataChanged();
	    }
	
	public static UnpassedExamsTable getTable() {
		if (unpassedExamsTable == null) {
			unpassedExamsTable = new UnpassedExamsTable();
		}
		return unpassedExamsTable;
	}
	

	public static void initComponents() {
		
		unpassedExamsTable.getColumnModel().getColumn(0).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("subjectCode"));
		unpassedExamsTable.getColumnModel().getColumn(1).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("subjectName"));
		unpassedExamsTable.getColumnModel().getColumn(2).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("ESPB"));
		unpassedExamsTable.getColumnModel().getColumn(3).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("date"));
		unpassedExamsTable.getColumnModel().getColumn(4).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("subjectTerm"));
		
		unpassedExamsTable.updateTable();	
		
	}
	
}
