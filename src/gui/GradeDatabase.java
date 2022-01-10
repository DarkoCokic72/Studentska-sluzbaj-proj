package gui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.Grade;
import Model.Student;
import Model.StudentDatabase;

public class GradeDatabase {
	private static GradeDatabase gradeDatabase = null;
	private ArrayList<Grade> grades;
	private ArrayList<String> columns;
	
	public GradeDatabase() {
		grades  = new ArrayList<Grade>();
		columns = new ArrayList<String>();
		
		columns.add("Šifra predmeta");
		columns.add("Naziv predmeta");
		columns.add("ESPB");
		columns.add("Ocena");
		columns.add("Datum");
		
	}
	
	public int getRowCount() {
		return grades.size();
	}
	
	public int getColumnCount() {
		return columns.size();
	}
	
	public String getColumnName(int index) {
		return columns.get(index);
	}
	
	public String getValueAt(int row, int column, String index) {
		Grade grade = StudentDatabase.getInstance().getStudentByIndex(index).getPassedCourses().get(row);
		
		switch(column) {
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
	
	
	
	public ArrayList<Grade> getGrades() {
		return grades;
	}

	public void setGrades(ArrayList<Grade> grades) {
		this.grades = grades;
	}

	private String dateFormat(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.");
		return dateFormat.format(date);
	}
	
	public Grade getGradeFromRow(int index) {
		return grades.get(index);
	}
	
	public static GradeDatabase getInstance() {
		if(gradeDatabase == null)
			gradeDatabase = new GradeDatabase();
		
		return gradeDatabase;
	}
}
