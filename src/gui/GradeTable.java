package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class GradeTable extends JTable{
	private GradeAbstractTable gradeTableModel;
	private static GradeTable gradeTable = null;
	
	public GradeTable() {
		gradeTableModel = new GradeAbstractTable();
		setCellSelectionEnabled(false);
		setRowSelectionAllowed(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTableHeader().setReorderingAllowed(false);
		setModel(gradeTableModel);
	}
	
	public void updateTable() {
		gradeTableModel.fireTableDataChanged();
	}
	
	public static GradeTable getInstance() {
		if(gradeTable == null)
			gradeTable = new GradeTable();
		
		return gradeTable;
	}
}
