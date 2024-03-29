package gui;

import javax.swing.table.AbstractTableModel;

import Model.Student;
import Model.StudentDatabase;
import Model.Subject;
import Model.SubjectDatabase;

public class UnpassedExamsAbstractTable extends AbstractTableModel{

	@Override
	public int getRowCount() {
		StudentDatabase studentDatabase = StudentDatabase.getInstance();
		Student student = studentDatabase.getStudentFromRow(EditStudentDialog.selectedRow);
		return student.getUnpassedCourses().size();
	}

	@Override
	public int getColumnCount() {
		
		SubjectDatabase subjectDatabase = SubjectDatabase.getDatabase();
		return subjectDatabase.getColumnCount();
		
	}
	

	@Override
	public String getColumnName(int columnIndex) {
		return SubjectDatabase.getDatabase().getColumnName(columnIndex);
	}

	@Override
	public String getValueAt(int rowIndex, int columnIndex) {
		
		int rowStudent = EditStudentDialog.selectedRow;
		Subject subject = StudentDatabase.getInstance().getStudentFromRow(rowStudent).getUnpassedCourses().get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return subject.getSubjectCode();
		case 1:
			return subject.getSubjectName();
		case 2:
			return subject.getESPB().toString();
		case 3:
			return subject.getYearOfStudy().toString();
		case 4:
			return subject.getTerm().name();
		default:
			return null;
		}
	}

}
