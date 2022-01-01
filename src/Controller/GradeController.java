package Controller;

import java.util.Date;

import Model.Grade;
import Model.Student;
import Model.StudentDatabase;
import Model.Subject;
import gui.EditStudentDialog;
import gui.GradeEntryDialog;
import gui.StudentTable;
import gui.UnpassedExamsTable;

public class GradeController {
	
	private static GradeController gradeContr = null;
	public static boolean gradeEntried = false;
	
	public void entry() {
		
		Student student = StudentDatabase.getInstance().getStudentFromRow(EditStudentDialog.selectedRow);
		
		String subjectCode = GradeEntryDialog.getSubjectCodeField().getText();
		Subject subject = null;
		for(Subject s: student.getUnpassedCourses()) {
			if(s.getSubjectCode().equals(subjectCode)) {
				subject = s;
			}
		}
		
		int grade = GradeEntryDialog.getGrade();
		String dateString = GradeEntryDialog.getDate().getText().trim();
		
		if(Validation.checkDate(dateString) == true) {
			
			Date date = Converter.convertStringToDate(dateString);
			Grade g = new Grade(student, subject, grade, date);
			
			//dodavanje ocene u polozene predmete
			student.getPassedCourses().add(g);
			
			//brisanje iz nepolozenih predmeta
			int selectedRowSubject = UnpassedExamsTable.getTable().convertRowIndexToModel(StudentTable.getTable().getSelectedRow());
			student.getUnpassedCourses().remove(selectedRowSubject);
			UnpassedExamsTable.getTable().updateTable();
			
			//promena proseka za studenta
			student.setAvgMark();
			
			//dodavanje studenata u listu studenata koji su polozili predmet
			subject.getStudentWhoPassed().add(student);
			
			gradeEntried = true;
				
		}	
	}
	
	 public static GradeController getGradeController() {
 		
	    	if (gradeContr == null) {
	    		gradeContr = new GradeController();
	    	}
	    	return gradeContr;
	    }

}
