package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ProfessorJTable extends JTable{
	
	private static ProfessorJTable professorTable= null;
	private ProfessorAbstractTable professorTableModel; 
	
    private ProfessorJTable() {
			
   	    professorTableModel = new ProfessorAbstractTable(); 
   	    
   	    setRowSelectionAllowed(true);
   		setColumnSelectionAllowed(true);
   		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   		getTableHeader().setReorderingAllowed(false);
   		
   		setModel(professorTableModel);
   		
	}
    
    public void updateTable() {
    	professorTableModel.fireTableDataChanged();
    }
    
    public static ProfessorJTable getTable() {
		if (professorTable == null) {
			professorTable = new ProfessorJTable();
		}
		return professorTable;
	}
	

}
