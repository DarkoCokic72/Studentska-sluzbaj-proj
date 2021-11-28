package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ProfessorJTable extends JTable{
	
	private ProfessorAbstractTable professorTableModel; 
	
    public ProfessorJTable() {
			
   	    professorTableModel = new ProfessorAbstractTable(); 
   	    
   	    setRowSelectionAllowed(true);
   		setColumnSelectionAllowed(true);
   		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   		getTableHeader().setReorderingAllowed(false);
   		
   		setModel(professorTableModel);
   		
	}
	

}
