package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class SubjectJTable extends JTable {

	 private SubjectAbstractTable subjectTableModel; 
	 private static SubjectJTable subjectTable;
	
     public SubjectJTable() {
			
    	    subjectTableModel = new SubjectAbstractTable(); 
    	    setCellSelectionEnabled(false);
       	    setRowSelectionAllowed(true);
       	    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    		getTableHeader().setReorderingAllowed(false);
    		
    		setModel(subjectTableModel);
     }
     
     public void search(String text) {
     	
     }
     
     public static SubjectJTable getTable() {
 		if (subjectTable == null) {
 			subjectTable = new SubjectJTable();
 		}
 		return subjectTable;
 	}
 	
}
