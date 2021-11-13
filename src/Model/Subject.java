package Model;

import java.util.ArrayList;

enum Term { SUMMER, WINTER}

public class Subject {
	
	private int subjectCode;
	private int subjectName;
	private Term term;
	private int yearOfStudy;
	private String subjectProfessor;
	private int ESPB;
	private ArrayList<Student> studentsWhoPassed;
	private ArrayList<Student> studentsWhoDidNotPassed;
	
	public Subject(int subjectCode, int subjectName, Term term, int yearOfStudy, String subjectProfessor, int ESPB) {
		
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.term = term;
		this.yearOfStudy = yearOfStudy;
		this.subjectProfessor = subjectProfessor;
		this.ESPB = ESPB;
		studentsWhoPassed = new ArrayList<Student>();
		studentsWhoDidNotPassed = new ArrayList<Student>();
			
	}

}
