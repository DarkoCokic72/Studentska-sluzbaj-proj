package gui;

import javax.swing.table.AbstractTableModel;

import Model.Profesor;
import Model.ProfessorDatabase;
import Model.Subject;

public class AddSubjectToProfessorAbstractTable extends AbstractTableModel{

	@Override
	public int getRowCount() {
		
		return ProfessorDatabase.getDatabase().getRowCount();
	}

	@Override
	public int getColumnCount() {
	
		return 1;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Subject s = ProfessorDatabase.getDatabase().getDoesNotTeachSubjects().get(rowIndex);
		return  s.getSubjectCode() + " - " +s.getSubjectName(); 
	}
	
	public Profesor getProf() {
		int row = ProfessorJTable.getTable().convertRowIndexToModel(ProfessorJTable.getTable().getSelectedRow());
		return ProfessorDatabase.getDatabase().getProfessorFromRow(row);
	}

}
