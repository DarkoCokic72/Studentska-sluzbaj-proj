package main;

import java.util.ArrayList;

import Controller.Converter;
import Model.Address;
import Model.Profesor;
import Model.Profesor.Zvanje;
import Model.Student;
import Model.Student.Status;
import Model.Subject.Term;
import Model.SubjectDatabase;
import Model.StudentDatabase;
import Model.Subject;
import gui.MainFrame;
import gui.StudentTable;

public class MyApp {

	public static void main(String[] args) {
		
		MainFrame mf = MainFrame.getMainFrame();
		
		Student s = new Student("Ana", "Vulin", Converter.convertStringToDate("4.3.2000"), "sm.vulinana@gmail.com", "0690386028", 
				new Address("Rumenacka", 17, "Novi Sad", "Srbija"), "ra-65-2019", 2019, 1, Status.B);
		StudentDatabase studDatabase = StudentDatabase.getInstance();
		studDatabase.addStudentsIntoTable(s);
		StudentTable studTable = StudentTable.getTable();
		studTable.updateTable();
		
		Subject subj = new Subject("S101", " OISISI", Term.WINTER,
				3, new Profesor("Marko", "Markovic", Converter.convertStringToDate("1.1.1990."), "marko@gmail.com", "0611123526", 
						new Address("Rumenacka", 17, "Novi Sad", "Srbija"), new Address("Rumenacka", 17, "Novi Sad", "Srbija"), 123456789, 10, Zvanje.REDOVNI_PROFESOR), 5);
		ArrayList<Subject> unpassedCourses= new ArrayList<Subject>();
		unpassedCourses.add(subj);
		SubjectDatabase subjectDatabase = SubjectDatabase.getDatabase();
		subjectDatabase.addSubjectIntoTable(subj);
		
		
		Subject subj2 = new Subject("S102", "NANS", Term.WINTER,
				3, new Profesor("Marko", "Markovic", Converter.convertStringToDate("1.1.1990."), "marko@gmail.com", "0611123526", 
						new Address("Rumenacka", 17, "Novi Sad", "Srbija"), new Address("Rumenacka", 17, "Novi Sad", "Srbija"), 123456789, 10, Zvanje.REDOVNI_PROFESOR), 5);
		unpassedCourses.add(subj2);
		subjectDatabase.addSubjectIntoTable(subj2);
		s.setUnpassedCourses(unpassedCourses);
	}

}
