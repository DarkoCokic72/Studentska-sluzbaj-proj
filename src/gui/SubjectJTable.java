package gui;

import java.util.Arrays;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class SubjectJTable extends JTable {

	 private SubjectAbstractTable subjectTableModel; 
	 private static SubjectJTable subjectTable = null;
	 private TableRowSorter<SubjectAbstractTable> tableRowSorter;
		
	
     public SubjectJTable() {
			
    	    subjectTableModel = new SubjectAbstractTable(); 
    	    setCellSelectionEnabled(false);
       	    setRowSelectionAllowed(true);
       	    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    		getTableHeader().setReorderingAllowed(false);
    		setModel(subjectTableModel);
    		tableRowSorter = new TableRowSorter<SubjectAbstractTable>(subjectTableModel);
    		setRowSorter(tableRowSorter);
    		
     }
     
     public void updateTable() {
     	subjectTableModel.fireTableDataChanged();
     }
     
     public void search(String input) {
    	 
    	String[] words = input.split(" ");
      	int numberOfWords = words.length;
      	if (numberOfWords == 1) {
      		RowFilter<SubjectAbstractTable, Integer> filter1 = RowFilter.regexFilter(".*" + "(?i)" + words[0] + ".*");
      		List<RowFilter<SubjectAbstractTable, Integer>> filters = Arrays.asList(filter1);
      		tableRowSorter.setRowFilter(RowFilter.andFilter(filters));
      	}
      	if (numberOfWords == 2) {
      		
      		RowFilter<SubjectAbstractTable, Integer> filter1 = RowFilter.regexFilter(".*" + "(?i)" + words[0] + ".*");
      		RowFilter<SubjectAbstractTable, Integer> filter2 = RowFilter.regexFilter(".*" + "(?i)" + words[1] + ".*");
      		List<RowFilter<SubjectAbstractTable, Integer>> filters = Arrays.asList(filter1, filter2);
      		tableRowSorter.setRowFilter(RowFilter.andFilter(filters));
      	} 	
    	 
     }
     	
     
     public static SubjectJTable getTable() {
 		if (subjectTable == null) {
 			subjectTable = new SubjectJTable();
 		}
 		return subjectTable;
 	}
 	
}
