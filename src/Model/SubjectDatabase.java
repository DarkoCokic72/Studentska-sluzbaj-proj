package Model;

import java.util.ArrayList;

public class SubjectDatabase {

	private static SubjectDatabase subjectDatabase = null;
	private ArrayList<Subject> subjects;
	private ArrayList<String> columns;
		
	private SubjectDatabase() {
		
		subjects = new ArrayList<Subject>();
		columns = new ArrayList<String>();
		
	    columns.add("Šifra");
	    columns.add("Naziv");
	    columns.add("ESPB");
	    columns.add("Godina");
	    columns.add("Semestar");
	    
	}
	
	public int getRowCount() {
		return subjects.size();
	}
	
	public int getColumnCount() {
		return columns.size();
	}
	
	public String getColumnName(int index) {
		
		return columns.get(index);
		
	}
	
	
	public String getValueAt(int row, int column) {
		
		Subject subject = subjects.get(row);
		
		switch (column) {
		
		    case 0:
			
			    return subject.getSubjectCode();
			
		    case 1:
			
			    return subject.getSubjectName();
			
		    case 2:
			
			    return subject.getESPB().toString();
			
		    case 3:
			
			    return subject.getYearOfStudy().toString();
			
		    case 4:
			
			    return subject.getTerm().name();
			
		    default:
			    return null;
		}
	}
	
	public void addSubjectIntoTable(Subject sub) {
		subjects.add(sub);
	}
	
	
	public Subject getSubjectFromRow(int index) {
		return subjects.get(index);
	}
	
	public static SubjectDatabase getDatabase() {
		if(subjectDatabase == null) {
			subjectDatabase = new SubjectDatabase();
		}
		
		return subjectDatabase;
	}

	
}
