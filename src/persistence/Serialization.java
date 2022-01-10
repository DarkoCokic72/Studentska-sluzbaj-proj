package persistence;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import Model.CompleteDatabase;
import Model.ProfessorDatabase;
import Model.StudentDatabase;
import Model.SubjectDatabase;
import gui.GradeDatabase;

public class Serialization {

	public static void serialization() throws FileNotFoundException, IOException {
		
		StudentDatabase studentDatabase = StudentDatabase.getInstance();
		ProfessorDatabase professorDatabase = ProfessorDatabase.getDatabase();
		SubjectDatabase subjectDatabase = SubjectDatabase.getDatabase();
		GradeDatabase gradeDatabase = GradeDatabase.getInstance();
		
		CompleteDatabase database = new CompleteDatabase(studentDatabase.getStudents(), professorDatabase.getProfessors(), subjectDatabase.getSubjects(), gradeDatabase.getGrades());
		
		File file = new File("Database.txt");
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		
		try {
				oos.writeObject(database);
		} finally {
				oos.close();
		}
	}
}
