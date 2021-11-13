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
		this.mark = mark;
		this.dateOfExam = date;
	}
}
