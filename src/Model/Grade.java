package Model;

import java.util.Date;

public class Grade {
	private Student student;
	private Subject passedSubject;
	private int mark;
	Date dateOfExam;
	
	public Grade(Student std, Subject sbj, int mark, Date date) {
		this.student = std;
		this.passedSubject = sbj;
		if(mark >= 6 || mark <= 10) {
			this.mark = mark;
		}
		this.dateOfExam = date;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getPassedSubject() {
		return passedSubject;
	}

	public void setPassedSubject(Subject passedSubject) {
		this.passedSubject = passedSubject;
	}

	public int getMark() {
		return mark;
	}

	public void setMark(int mark) {
		if(mark >= 6 || mark <= 10) {
			this.mark = mark;
		}
	}

	public Date getDateOfExam() {
		return dateOfExam;
	}

	public void setDateOfExam(Date dateOfExam) {
		this.dateOfExam = dateOfExam;
	}
	
	
}
