package Controller;

import java.util.ArrayList;

import Model.Profesor;
import Model.Subject;
import Model.Subject.Term;
import Model.SubjectDatabase;
import gui.AddSubjectDialog;
import gui.EditSubjectInformationTab;
import gui.SubjectJTable;

public class SubjectController {
	
	private static SubjectController subjectContr = null;
	public boolean subjectAdded = false;
	public boolean subjectEdited = false;
	public static boolean professorChoosen;
	public static boolean professorRemoved;
	
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
	
	public void edit(Subject subject) {
		
		String name = EditSubjectInformationTab.getNameField().getText().trim();
		String yearOfStudy = EditSubjectInformationTab.getYearOfStudyField().getText().trim();
		String espb = EditSubjectInformationTab.getEspbField().getText().trim();
		Term term = EditSubjectInformationTab.getTerm();
		
		if( ValidationSubject.checkName(name) == true && ValidationSubject.checkYearOfStudy(yearOfStudy) == true && ValidationSubject.checkESPB(espb) == true) {
			
			String code = EditSubjectInformationTab.getCodeField().getText().trim();
			subject.setSubjectCode("-1");
			String wrongCode = EditSubjectInformationTab.getCodeField().getText().trim();
			
			if(ValidationSubject.checkCode(wrongCode)) {
				int year = Integer.parseInt(yearOfStudy);
				int espbs = Integer.parseInt(espb);
				
				subject.setSubjectName(name);
				subject.setYearOfStudy(year);
				subject.setESPB(espbs);
				subject.setTerm(term);
				subject.setSubjectProfessor(null);
				subject.setSubjectCode(code);
				
				SubjectJTable subjTable = SubjectJTable.getTable();
				subjTable.updateTable();
				subjectEdited = true;
				
			} else {
				subject.setSubjectCode(code);
			}
		}
	}
	
    public static SubjectController getSubjectController() {
		
    	if (subjectContr == null) {
    		subjectContr = new SubjectController();
    	}
    	return subjectContr;
    }
       
    public void chooseProfessor(Subject subject, Profesor professor) {
    	
    	subject.setSubjectProfessor(professor);
    	ArrayList<Subject> subjectProfessorTeaches = professor.getSubjectsTeaches();
    	subjectProfessorTeaches.add(subject);
    	professor.setSubjectsTeaches(subjectProfessorTeaches);
    	professorChoosen = true;
    }
    
    public void removeProfessor() {
   
    	Subject subject = EditSubjectInformationTab.subject;
    	Profesor professor = subject.getSubjectProfessor();
    	subject.setSubjectProfessor(null);
    	ArrayList<Subject> subjectsProfessorTeaches = professor.getSubjectsTeaches();
    	subjectsProfessorTeaches.remove(subject);
    	professor.setSubjectsTeaches(subjectsProfessorTeaches);
    	
    	professorRemoved = true;
    }  
}
