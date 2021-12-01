package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class StudentTable extends JTable {
	private static StudentTable studentTable=null;;
	private StudentAbstractTable studentTableModel;
	
	public StudentTable() {
		studentTableModel = new StudentAbstractTable();
		
		setColumnSelectionAllowed(true);
		setRowSelectionAllowed(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTableHeader().setReorderingAllowed(false);
		
		setModel(studentTableModel);
	}
	
	public void updateTable() {
		studentTableModel.fireTableDataChanged();
	}
	
	public static StudentTable getTable() {
		if(studentTable == null) {
			studentTable = new StudentTable();
		}
		
		return studentTable;
	}
}
