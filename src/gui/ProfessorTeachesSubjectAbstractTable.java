package gui;

import javax.swing.table.AbstractTableModel;

import Model.Profesor;
import Model.ProfessorDatabase;
import Model.SubjectDatabase;

public class ProfessorTeachesSubjectAbstractTable extends AbstractTableModel{
	
	 public ProfessorTeachesSubjectAbstractTable() {}

	@Override
	public int getRowCount() {
		int row = ProfessorJTable.getTable().convertRowIndexToModel(ProfessorJTable.getTable().getSelectedRow());
		Profesor p = ProfessorDatabase.getDatabase().getProfessorFromRow(row);
		return p.getSubjectsTeaches().size();
	}

	@Override
	public int getColumnCount() {
		return SubjectDatabase.getDatabase().getColumnCount() - 1;
	}
	
	public String getColumnName(int column) {
		if(column > 1) {
			column++;
		}
		
		return SubjectDatabase.getDatabase().getColumnName(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex ) {

		return SubjectDatabase.getDatabase().getProfValueAt(rowIndex, columnIndex, getProf().getPersonalID());
	}
	
	public Profesor getProf() {
		int row = ProfessorJTable.getTable().convertRowIndexToModel(ProfessorJTable.getTable().getSelectedRow());
		return ProfessorDatabase.getDatabase().getProfessorFromRow(row);
	}

}
