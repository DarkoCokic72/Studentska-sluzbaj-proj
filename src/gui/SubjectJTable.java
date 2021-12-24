package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class SubjectJTable extends JTable {

	 private SubjectAbstractTable subjectTableModel; 
	
     public SubjectJTable() {
			
    	    subjectTableModel = new SubjectAbstractTable(); 
    	    setCellSelectionEnabled(false);
       	    setRowSelectionAllowed(true);
       	    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    		getTableHeader().setReorderingAllowed(false);
    		
    		setModel(subjectTableModel);
    		
	}
}
