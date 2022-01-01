package Controller;

import java.util.ArrayList;

import Model.Subject;
import Model.SubjectDatabase;
import gui.SubjectJTable;

public class SubjectController {
	
	private static SubjectController subjectContr = null;
	
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
	
    public static SubjectController getSubjectController() {
		
    	if (subjectContr == null) {
    		subjectContr = new SubjectController();
    	}
    	return subjectContr;
    }
        

}
