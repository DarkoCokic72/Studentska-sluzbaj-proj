package Model;

import java.io.Serializable;
import java.util.List;

public class CompleteDatabase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4833356850657704986L;
	private List<Student> students;
	private List<Profesor> professors;
	private List<Subject> subjects;
	private List<Grade> grades;
	
	public CompleteDatabase(List<Student> students, List<Profesor> professors, List<Subject> subjects, List<Grade> grades) {
		
		this.students = students;
		this.professors = professors;
		this.subjects = subjects;
		this.grades = grades;
		
	}


	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Profesor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Profesor> professors) {
		this.professors = professors;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

}
