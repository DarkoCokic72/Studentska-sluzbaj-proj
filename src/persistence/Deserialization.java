package persistence;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import Model.CompleteDatabase;
import Model.Grade;
import Model.Profesor;
import Model.ProfessorDatabase;
import Model.Student;
import Model.StudentDatabase;
import Model.Subject;
import Model.SubjectDatabase;
import gui.GradeDatabase;

public class Deserialization {
	private static Deserialization deserInstance = null;
	private ObjectInputStream ois;
	
	public Deserialization() {}
	
	public static Deserialization getInstance() {
		if(deserInstance == null)
			deserInstance = new Deserialization();
		
		return deserInstance;
	}
	
	public void deserialize() {
		String name = "Database.txt";
		CompleteDatabase database = new CompleteDatabase();
		
		try {
			File file = new File(name);
			if(file.exists() == true && file.length() != 0) {
				ois = new ObjectInputStream(new BufferedInputStream( new FileInputStream(file)));
				
				try {
					database = (CompleteDatabase) ois.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				StudentDatabase.getInstance().setStudents((ArrayList<Student>) database.getStudents());
				ProfessorDatabase.getDatabase().setProfessors((ArrayList<Profesor>)database.getProfessors());
				SubjectDatabase.getDatabase().setSubjects((ArrayList<Subject>)database.getSubjects());
				GradeDatabase.getInstance().setGrades((ArrayList<Grade>)database.getGrades());
				
				ois.close();
				
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
