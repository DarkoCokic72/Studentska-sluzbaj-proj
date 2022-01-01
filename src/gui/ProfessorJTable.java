package gui;

import java.util.Arrays;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

public class ProfessorJTable extends JTable{
	
	private static ProfessorJTable professorTable = null;
	private ProfessorAbstractTable professorTableModel; 
	private TableRowSorter<ProfessorAbstractTable> tableRowSorter;
	
    private ProfessorJTable() {
			
   	    professorTableModel = new ProfessorAbstractTable(); 
   	    setCellSelectionEnabled(false);
   	    setRowSelectionAllowed(true);
   		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
   		getTableHeader().setReorderingAllowed(false);
   		setModel(professorTableModel);
   		
   		tableRowSorter = new TableRowSorter<ProfessorAbstractTable>(professorTableModel);
		setRowSorter(tableRowSorter);
		
	}
    
    public void updateTable() {
    	professorTableModel.fireTableDataChanged();
    }
    
    public void search(String input) {
    	
    	String[] words = input.split(" ");
    	int numberOfWords = words.length;
    	if (numberOfWords == 1) {
    		RowFilter<ProfessorAbstractTable, Integer> filter = RowFilter.regexFilter(".*" + "(?i)" + words[0] + ".*");
    		List<RowFilter<ProfessorAbstractTable, Integer>> filters = Arrays.asList(filter);
    		tableRowSorter.setRowFilter(RowFilter.andFilter(filters));
    	}
    	if (numberOfWords == 2) {
    		
    		RowFilter<ProfessorAbstractTable, Integer> filter1 = RowFilter.regexFilter(".*" + "(?i)" + words[0] + ".*");
    		RowFilter<ProfessorAbstractTable, Integer> filter2 = RowFilter.regexFilter(".*" + "(?i)" + words[1] + ".*");
    		List<RowFilter<ProfessorAbstractTable, Integer>> filters = Arrays.asList(filter1, filter2);
    		tableRowSorter.setRowFilter(RowFilter.andFilter(filters));
    	
    	}
    	
    }

    
    public static ProfessorJTable getTable() {
		if (professorTable == null) {
			professorTable = new ProfessorJTable();
		}
		return professorTable;
	}
	

}
