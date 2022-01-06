package Controller;

import java.util.ArrayList;

import Model.Subject;
import Model.Subject.Term;
import Model.SubjectDatabase;
import gui.AddSubjectDialog;
import gui.SubjectJTable;

public class SubjectController {
	
	private static SubjectController subjectContr = null;
	public boolean subjectAdded = false;
	
	public void delete(Subject subject) {
		
		String code = subject.getSubjectCode();
		ArrayList<Subject> subjectList = SubjectDatabase.getDatabase().getSubjects();
		int i = 0;
		
		for(Subject s: subjectList) {
			if(s.getSubjectCode().equals(code)) {
				subjectList.remove(i);
				break;
			}
			i++;
		}
		
		SubjectJTable subjectTable = SubjectJTable.getTable();
		subjectTable.updateTable();
				
	}
	
	public void add() {
		String code = AddSubjectDialog.getCodeField().getText().trim();
		String name = AddSubjectDialog.getNameField().getText().trim();
		String yearOfStudy = AddSubjectDialog.getYearOfStudyField().getText().trim();
		String espb = AddSubjectDialog.getEspbField().getText().trim();
		Term term = AddSubjectDialog.getTerm();
		
		if(ValidationSubject.checkCode(code) == true && ValidationSubject.checkName(name) == true &&
				ValidationSubject.checkYearOfStudy(yearOfStudy) == true && ValidationSubject.checkESPB(espb) == true) {
			int year = Integer.parseInt(yearOfStudy);
			int espbs = Integer.parseInt(espb);
			
			Subject subject = new Subject(code, name, term, year, null, espbs); //professor will be added later: #profesor_predaje_predmete
			SubjectDatabase subjDatabase = SubjectDatabase.getDatabase();
			subjDatabase.addSubjectIntoTable(subject);
			SubjectJTable subjTable = SubjectJTable.getTable();
			subjTable.updateTable();
			subjectAdded = true;
		}
	}
	
    public static SubjectController getSubjectController() {
		
    	if (subjectContr == null) {
    		subjectContr = new SubjectController();
    	}
    	return subjectContr;
    }
        

}
