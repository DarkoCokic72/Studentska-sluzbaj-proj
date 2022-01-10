package Controller;

import java.util.Date;

import Model.Grade;
import Model.Student;
import Model.StudentDatabase;
import Model.Subject;
import gui.EditStudentDialog;
import gui.GradeEntryDialog;
import gui.PassedExamsTab;
import gui.PassedExamsTable;
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
			PassedExamsTable.getInstance().updateTable();
			
			//brisanje iz nepolozenih predmeta
			int selectedRowSubject = UnpassedExamsTable.getTable().convertRowIndexToModel(StudentTable.getTable().getSelectedRow());
			student.getUnpassedCourses().remove(selectedRowSubject);
			UnpassedExamsTable.getTable().updateTable();
			
			//promena proseka za studenta
			student.setAvgMark();
			double average = student.getAvgMark();
			String averageTxt = String.format("Prosecna ocena: %.2f", average);
			PassedExamsTab.getAverageLabel().setText(averageTxt);
			
			//promena espb bodova koje je student osvojio
			String textFromESPBLab = PassedExamsTab.getTotalESPBLabel().getText().trim();
			String ESPBString = textFromESPBLab.replaceAll("[^\\d]", "");
			int ESPB = Integer.parseInt(ESPBString);
			ESPB = ESPB + subject.getESPB();
			String espbTxt = String.format("Ukupno ESPB: %d", ESPB);
			PassedExamsTab.getTotalESPBLabel().setText(espbTxt);
			
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
