package gui;

import javax.swing.table.AbstractTableModel;

import Model.ChairDatabase;

public class ChairAbstractTable extends AbstractTableModel{
	
	private ChairDatabase chairDatabase;
	
	public ChairAbstractTable() {
		chairDatabase = ChairDatabase.getInstance();
	}

	@Override
	public int getRowCount() {
		
		return chairDatabase.getRowCount();
	}

	@Override
	public int getColumnCount() {
		
		return chairDatabase.getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return chairDatabase.getValueAt(rowIndex, columnIndex);
	}
	
	public String getColumnName(int column) {
		return chairDatabase.getColumnName(column);
	}

}
