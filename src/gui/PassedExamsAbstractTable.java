package gui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.table.AbstractTableModel;

import Model.Grade;
import Model.Student;
import Model.StudentDatabase;
import Model.SubjectDatabase;

public class PassedExamsAbstractTable extends AbstractTableModel{
	
	
	

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		StudentDatabase studentDatabase = StudentDatabase.getInstance();
		Student student = studentDatabase.getStudentFromRow(StudentTable.getTable().convertRowIndexToModel(StudentTable.getTable().getSelectedRow()));
		return student.getPassedCourses().size();
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		GradeDatabase gradeDatabase = GradeDatabase.getInstance();
		return gradeDatabase.getColumnCount();
	}
	
	public String getColumnName(int columnIndex) {
		return GradeDatabase.getInstance().getColumnName(columnIndex);
	}

	@Override
	public String getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		int rowStudent = StudentTable.getTable().convertRowIndexToModel(StudentTable.getTable().getSelectedRow());
		Grade grade = StudentDatabase.getInstance().getStudentFromRow(rowStudent).getPassedCourses().get(rowIndex);
		
		switch(columnIndex) {
		case 0:
			return grade.getPassedSubject().getSubjectCode();
		case 1:
			return grade.getPassedSubject().getSubjectName();
		case 2:
			return grade.getPassedSubject().getESPB().toString();
		case 3:
			return grade.getMark().toString();
		case 4:
			return dateFormat(grade.getDateOfExam());
		default:
			return null;
		}
	}
	
	private String dateFormat(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
		return dateFormat.format(date);
	}

}
