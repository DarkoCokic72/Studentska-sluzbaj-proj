package gui;

import java.util.Arrays;
import java.util.Comparator;
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
    		fixComparator();
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
     
     public void fixComparator() {
    	 
    	 tableRowSorter.setComparator(2, new Comparator<String>() {

 			@Override
 			public int compare(String a, String b) {
 				
 				int ret = 0;
 				if (Integer.parseInt(a) > Integer.parseInt(b)) {
 					ret = 1;
 				} 
 				else if (Integer.parseInt(a) < Integer.parseInt(b)) {
 					ret = -1;
 				} 
 				
 				return ret;
 			}
    	 });
    	 
    	 tableRowSorter.setComparator(3, new Comparator<String>() {

 			@Override
 			public int compare(String a, String b) {
 				
 				int ret = 0;
 				if (Integer.parseInt(a) > Integer.parseInt(b)) {
 					ret = 1;
 				} 
 				else if (Integer.parseInt(a) < Integer.parseInt(b)) {
 					ret = -1;
 				} 
 				
 				return ret;
 			}
    	 });
    	 
     }
     
  
     
     public static SubjectJTable getTable() {
 		if (subjectTable == null) {
 			subjectTable = new SubjectJTable();
 		}
 		return subjectTable;
 	}
     
     public static void initComponents() {
 		
 		subjectTable.getColumnModel().getColumn(0).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("subjectCode"));
 		subjectTable.getColumnModel().getColumn(1).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("subjectName"));
 		subjectTable.getColumnModel().getColumn(2).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("ESPB"));
		subjectTable.getColumnModel().getColumn(3).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("subjectYear"));
		subjectTable.getColumnModel().getColumn(4).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("subjectTerm"));
 		
 		subjectTable.updateTable();	
 		
 	}
 	
}
