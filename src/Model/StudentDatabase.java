package Model;

import java.util.ArrayList;

public class StudentDatabase {
	private static StudentDatabase studentDatabase = null;
	private ArrayList<Student> students;
	private ArrayList<String> culumns;
	
	public StudentDatabase( ) {
		students = new ArrayList<Student>();
		culumns = new ArrayList<String>();
		
		culumns.add("Broj indeksa");
		culumns.add("Ime");
		culumns.add("Prezime");
		culumns.add("Godina studija");
		culumns.add("Status");
		culumns.add("Prosek");
	}
	
	public int getRowCount() {
		return students.size();
	}
	
	public int getColumnCount() {
		return culumns.size();
	}
	
	public String getColumnName(int index) {
		return culumns.get(index);
	}
	
	public String getValueAt(int row, int column) {
		Student student = students.get(row);
		
		switch(column) {
			case 0:
				return student.getIndexID();
			case 1:
				return student.getName();
			case 2:
				return student.getSurname();
			case 3:
				return student.getCurrYearOfStudies().toString();
			case 4:
				return student.getCurrStatus().toString();
			case 5:
				return student.getAvgMark().toString();
			default:
				return null;
		}
	
	}
	
	public void addStudentsIntoTable(Student st) {
		students.add(st);
	}
	
	public ArrayList<Student> getStudents(){
		return students;
	}
	
	public Student getStudentFromRow(int index) {
		return students.get(index);
	}
	
	public Student getStudentByIndex(String index) {
		for(Student s: students) {
			if(s.getIndexID() == index) {
				return s;
			}
				
		}
		
		return null;
	}
	
	public double getAverageMark(String index) {
		double average = 0;
		for(Student s: students) {
			if(s.getIndexID().equalsIgnoreCase(index)) {
				for (Grade g: s.getPassedCourses()) {
					average += g.getMark();
				}
				
				if(s.getPassedCourses().isEmpty() == false) {
					average = average / s.getPassedCourses().size();
				}
				
				break;
			}
		}
		
		return average;
	}
	
	public int getTotalESPB(String index) {
		int espb = 0;
		for(Student s: students) {
			if(s.getIndexID().equalsIgnoreCase(index)) {
				for(Grade g: s.getPassedCourses()) {
					espb += g.getPassedSubject().getESPB();
				}
				break;
			}
		}
		return espb;
	}
	
	public static StudentDatabase getInstance() {
		if(studentDatabase == null) {
			studentDatabase = new StudentDatabase();
		}
		
		return studentDatabase;
	}


}
