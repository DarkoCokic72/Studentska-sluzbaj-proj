package Model;

import java.util.ArrayList;


public class Subject {
	
	public enum Term { SUMMER, WINTER}
	
	private String subjectCode;
	private String subjectName;
	private Term term;
	private int yearOfStudy;
	private Profesor subjectProfessor;
	private int ESPB;
	private ArrayList<Student> studentsWhoPassed;
	private ArrayList<Student> studentsWhoDidNotPassed;
	
	public Subject(String subjectCode, String subjectName, Term term, int yearOfStudy, Profesor subjectProfessor, int ESPB) {
		
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.term = term;
		this.yearOfStudy = yearOfStudy;
		this.subjectProfessor = subjectProfessor;
		this.ESPB = ESPB;
		studentsWhoPassed = new ArrayList<Student>();
		studentsWhoDidNotPassed = new ArrayList<Student>();
			
	}
	
	public String getSubjectCode() {
		return subjectCode;
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	
	public Term getTerm() {
		return term;
	}
	public Integer getYearOfStudy() {
		return yearOfStudy;
	}
	
	public Profesor getSubjectProfessor() {
		return subjectProfessor;
	}
	
	public Integer getESPB() {
		return ESPB;
	}
	
	public ArrayList<Student> getStudentWhoPassed(){
		return studentsWhoPassed;
	}
	
	public ArrayList<Student> getStudentWhoDidNotPassed(){
		return studentsWhoDidNotPassed;
	}
	
	
	
	public void setSubjectCode(String code) {
		this.subjectCode = code;
	}
	
	public void setSubjectName(String name) {
		this.subjectName = name;
	}
	
	public void setTerm(Term t) {
		this.term = t;
	}
	
	public void setYearOfStudy(int year) {
		this.yearOfStudy = year;
	}
	
	public void setSubjectProfessor(Profesor professor) {
		this.subjectProfessor = professor;
	}
	
	public void setESPB(int ESPB) {
		this.ESPB = ESPB;
	}
	
	public void setStudentsWhoPassed(ArrayList<Student> students) {
		this.studentsWhoPassed = students;
	}
	
	public void setStudentsWhoDidNotPassed(ArrayList<Student> students) {
		this.studentsWhoDidNotPassed = students;
	}

}
