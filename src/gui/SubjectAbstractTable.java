package gui;

import javax.swing.table.AbstractTableModel;

import Model.SubjectDatabase;

public class SubjectAbstractTable extends AbstractTableModel{
        
	private SubjectDatabase subDatabase;
	
	public SubjectAbstractTable() {
		
		 subDatabase = SubjectDatabase.getDatabase();
		
	}
	
	
	@Override
	public int getRowCount() {
		
		return subDatabase.getRowCount();
	}

	@Override
	public int getColumnCount() {
		
		return subDatabase.getColumnCount();
	}
	
	@Override
	public String getColumnName(int column) {
		return subDatabase.getColumnName(column);
	}

	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return subDatabase.getValueAt(rowIndex, columnIndex);
		
	}
	

	
	

	
	
}
