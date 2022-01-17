package Model;

import java.util.ArrayList;
import java.util.List;

import gui.AddSubjectToProfessorTable;
import gui.ProfessorJTable;

public class ProfessorDatabase {
	
	private static ProfessorDatabase professorDatabase = null;
	private ArrayList<Profesor> professors;
	private ArrayList<String> columns;
		
	private ProfessorDatabase() {
		
		professors = new ArrayList<Profesor>();
		columns = new ArrayList<String>();
		
	    columns.add("Ime");
	    columns.add("Prezime");
	    columns.add("Zvanje");
	    columns.add("E-mail adresa");
	    
	}
	
	public int getRowCount() {
		return professors.size();
	}
	
	public int getColumnCount() {
		return columns.size();
	}
	
	public String getColumnName(int index) {
		return columns.get(index);
	}
	
	
	public String getValueAt(int row, int column) {
		
		Profesor professor = professors.get(row);
		
		switch (column) {
		
		    case 0:
			
			    return professor.getName();
			
		    case 1:
			
			    return professor.getSurname();
			
		    case 2:
			
		    	return professor.getZvanje().name();
			
		    case 3:
			
			    return professor.geteMail();
			
		    default:
			    return null;
		}
	}
	
	public void addProfessorToTable(Profesor professor) {
		professors.add(professor);
	}
	
	public ArrayList<Profesor> getProfessors() {
		return professors;
	}
	
	public Profesor getProfessorFromRow(int rowIndex) {
		return professors.get(rowIndex);
	}
	
	public static ProfessorDatabase getDatabase() {
		if (professorDatabase == null) {
			professorDatabase = new ProfessorDatabase();
		}
		return professorDatabase;
	}

	public void setProfessors(ArrayList<Profesor> professors) {
		this.professors = professors;
	}
	
	public List<Subject> getDoesNotTeachSubjects(){
		ArrayList<Subject> subjects = new ArrayList<Subject>(SubjectDatabase.getDatabase().getSubjects());
		for(Profesor p: professors) {
			for(Subject s: p.getSubjectsTeaches()) {
				if(subjects.contains(s)) {
					subjects.remove(s);
				}
			}
		}
		
		return subjects;
	}
	
	public Profesor getByPersonalID(int id) {
		for(Profesor p: professors) {
			if(p.getPersonalID() == id) {
				return p;
			}
		}
		return null;
	}
	
	public void addSubject() {
		int row  = ProfessorJTable.getTable().convertRowIndexToModel(ProfessorJTable.getTable().getSelectedRow());
		Profesor p = ProfessorDatabase.getDatabase().getProfessorFromRow(row);
		
		int id = p.getPersonalID();
		Subject s = getDoesNotTeachSubjects().get(AddSubjectToProfessorTable.getInstance().getSelectedRow());
		
		for(Profesor prof: professors) {
			if(prof.getPersonalID() == id) {
				if(!prof.getSubjectsTeaches().contains(s)) {
					prof.getSubjectsTeaches().add(s);
				}
				
				s.setSubjectProfessor(prof);
				return;
			}
		}
	}

}
