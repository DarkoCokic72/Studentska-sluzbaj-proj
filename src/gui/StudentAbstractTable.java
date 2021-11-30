package gui;

import javax.swing.table.AbstractTableModel;

import Model.StudentDatabase;

public class StudentAbstractTable extends AbstractTableModel {
	private StudentDatabase stDatabase;
	
	public StudentAbstractTable() {
		stDatabase = StudentDatabase.getInstance();
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return stDatabase.getRowCount();
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return stDatabase.getColumnCount();
	}
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return stDatabase.getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return stDatabase.getValueAt(rowIndex, columnIndex);
	}
}
