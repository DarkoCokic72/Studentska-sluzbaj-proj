package gui;

import javax.swing.table.AbstractTableModel;

import Model.Student;
import Model.StudentDatabase;

public class GradeAbstractTable extends AbstractTableModel{

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		int row = StudentTable.getTable().convertRowIndexToModel(StudentTable.getTable().getSelectedRow());
		Student student = StudentDatabase.getInstance().getStudentFromRow(row);
		return student.getPassedCourses().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return GradeDatabase.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
		return GradeDatabase.getInstance().getValueAt(rowIndex, columnIndex, getStudentFromRow(rowIndex).getIndexID());
	}
	
	public String getColumnName(int index) {
		return GradeDatabase.getInstance().getColumnName(index);
	}
	
	public Student getStudentFromRow(int rowIndex) {
		int row = StudentTable.getTable().convertRowIndexToModel(StudentTable.getTable().getSelectedRow());
		return StudentDatabase.getInstance().getStudentFromRow(row);
	}

}
