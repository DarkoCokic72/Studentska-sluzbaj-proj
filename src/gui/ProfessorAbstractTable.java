package gui;

import javax.swing.table.AbstractTableModel;

import Model.ProfessorDatabase;

public class ProfessorAbstractTable extends AbstractTableModel{

	private ProfessorDatabase professorDatabase;
	
	public ProfessorAbstractTable() {
		
		professorDatabase = ProfessorDatabase.getInstance();
	}
	
	@Override
	public int getRowCount() {
	
		return professorDatabase.getRowCount();
	}

	@Override
	public int getColumnCount() {

		return professorDatabase.getColumnCount();
	}
	
	@Override
	public String getColumnName(int index) {
		return professorDatabase.getColumnName(index);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return professorDatabase.getValueAt(rowIndex, columnIndex);
	}
  
	
}
