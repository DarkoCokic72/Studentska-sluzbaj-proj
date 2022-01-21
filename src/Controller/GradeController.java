package Controller;

import java.util.Date;

import javax.swing.JOptionPane;

import Model.Grade;
import Model.Student;
import Model.StudentDatabase;
import Model.Subject;
import Model.SubjectDatabase;
import gui.EditStudentDialog;
import gui.GradeAnnulmentDialog;
import gui.GradeDatabase;
import gui.GradeEntryDialog;
import gui.GradeTable;
import gui.MainFrame;
import gui.PassedExamsTab;
import gui.PassedExamsTable;
import gui.StudentTable;
import gui.UnpassedExamsTable;

public class GradeController {
	
	private static GradeController gradeContr = null;
	public static boolean gradeEntried = false;
	public static boolean gradeAnnuled = false;
	public static boolean exists = false;
	
	public void entry() {
		
		int selectedRow = StudentTable.getTable().getSelectedRow();
		Student student = StudentDatabase.getInstance().getStudentFromRow(selectedRow);
	
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
			GradeDatabase gradeDatabase = GradeDatabase.getInstance();
			gradeDatabase.addGrade(g);
			
			//dodavanje ocene u polozene predmete
			student.getPassedCourses().add(g);
			PassedExamsTable.getInstance().updateTable();
			GradeTable.getInstance().updateTable();
			
			//brisanje iz nepolozenih predmeta
			student.getUnpassedCourses().remove(subject);
			UnpassedExamsTable.getTable().updateTable();
			
			//promena proseka za studenta
			student.setAvgMark();
			double average = student.getAvgMark();
			String averageTxt;
			if(MainFrame.languageChanged) {
				averageTxt = MainFrame.getMainFrame().getResourceBundle().getString("avgMark") + " : " + String.format("%.2f", average);
			} else {
				averageTxt = String.format("Prosečna ocena: %.2f", average);
			}
			PassedExamsTab.getAverageLabel().setText(averageTxt);
			
			//promena espb bodova koje je student osvojio
			String textFromESPBLab = PassedExamsTab.getTotalESPBLabel().getText().trim();
			String ESPBString = textFromESPBLab.replaceAll("[^\\d]", "");
			int ESPB = Integer.parseInt(ESPBString);
			ESPB = ESPB + subject.getESPB();
			String espbTxt;
			if(MainFrame.languageChanged) {
				espbTxt = MainFrame.getMainFrame().getResourceBundle().getString("totalESPBLabel") + " : " +String.format("%d", ESPB);
			} else {
				espbTxt = String.format("Ukupno ESPB: %d", ESPB);
			}
			PassedExamsTab.getTotalESPBLabel().setText(espbTxt);
			
			//dodavanje studenata u listu studenata koji su polozili predmet
			subject.getStudentWhoPassed().add(student);
			subject.getStudentWhoDidNotPassed().remove(student);
			
			gradeEntried = true;			
		}	
	}
	
	public void annulment() {
		
		exists = false;
		int selectedRow = EditStudentDialog.selectedRow;
		Student student = StudentDatabase.getInstance().getStudentFromRow(selectedRow);
		Grade grade = student.getPassedCourses().get(GradeAnnulmentDialog.selectedRow);
		Subject subject = grade.getPassedSubject();
		
		for(Subject s: SubjectDatabase.getDatabase().getSubjects()) {
			if(s.getSubjectCode().equals(subject.getSubjectCode())) {
				exists = true;
			}
		}
		if(exists == false) {
			if(MainFrame.languageChanged) {
				JOptionPane.showMessageDialog(null,  MainFrame.getMainFrame().getResourceBundle().getString("subjectDoesntExist"));
				return;
			}
			JOptionPane.showMessageDialog(null, "Izabrani predmet više ne postoji.");
			return;
		}
		
		subject.getStudentWhoDidNotPassed().add(student);
		student.getPassedCourses().remove(GradeAnnulmentDialog.selectedRow);
		student.getUnpassedCourses().add(subject);
		subject.getStudentWhoPassed().remove(student);
		
		int i = 0;
		for (Grade g: GradeDatabase.getInstance().getGrades()) {
			
			if (g.getPassedSubject().getSubjectCode().equals(subject.getSubjectCode()) && grade.getStudent().getIndexID().equals(student.getIndexID())) {
				GradeDatabase.getInstance().getGrades().remove(i);
				break;
			}
			i++;
		}
		
		
		student.setAvgMark();
		double average = student.getAvgMark();
		String averageTxt;
		if(MainFrame.languageChanged) {
			averageTxt = MainFrame.getMainFrame().getResourceBundle().getString("avgMark") + " : " + String.format("%.2f", average);
		} else {
			averageTxt = String.format("Prosečna ocena: %.2f", average);
		}
		PassedExamsTab.getAverageLabel().setText(averageTxt);
		
		String textFromESPBLab = PassedExamsTab.getTotalESPBLabel().getText().trim();
		String ESPBString = textFromESPBLab.replaceAll("[^\\d]", "");
		int ESPB = Integer.parseInt(ESPBString);
		ESPB = ESPB - subject.getESPB();
		String espbTxt;
		if(MainFrame.languageChanged) {
			espbTxt = MainFrame.getMainFrame().getResourceBundle().getString("totalESPBLabel") + " : " +String.format("%d", ESPB);
		} else {
			espbTxt = String.format("Ukupno ESPB: %d", ESPB);
		}
		PassedExamsTab.getTotalESPBLabel().setText(espbTxt);
		
		GradeTable.getInstance().updateTable();
		PassedExamsTable.getInstance().updateTable();
		UnpassedExamsTable.getTable().updateTable();
		
		gradeAnnuled = true;
		
	}
	
	 public static GradeController getGradeController() {
 		
	    	if (gradeContr == null) {
	    		gradeContr = new GradeController();
	    	}
	    	return gradeContr;
	    }

}
