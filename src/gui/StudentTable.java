package gui;

import java.util.Arrays;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;

import javax.swing.RowFilter;

public class StudentTable extends JTable {
	private static StudentTable studentTable=null;;
	private StudentAbstractTable studentTableModel;
	private TableRowSorter<StudentAbstractTable> tableRowSorter;
	
	public StudentTable() {
		studentTableModel = new StudentAbstractTable();
		
		setCellSelectionEnabled(false);
		setRowSelectionAllowed(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTableHeader().setReorderingAllowed(false);
		
		setModel(studentTableModel);
		
		tableRowSorter = new TableRowSorter<StudentAbstractTable>(studentTableModel);
		setRowSorter(tableRowSorter);
	}
	
	public void updateTable() {
		studentTableModel.fireTableDataChanged();
	}
	
	public void search(String input) {
		String[] parts = input.split(" ");
		int numberOfParts = parts.length;
		
		if(numberOfParts == 1) {
			RowFilter<StudentAbstractTable, Integer> surnameFilter = RowFilter.regexFilter(".*" + "(?i)" + parts[0] + ".*", 2);
			List<RowFilter<StudentAbstractTable, Integer>> filters = Arrays.asList(surnameFilter);
			tableRowSorter.setRowFilter(RowFilter.andFilter(filters));
		} else if(numberOfParts == 2) {
			RowFilter<StudentAbstractTable, Integer> surnamefilter = RowFilter.regexFilter(".*" + "(?i)" + parts[0] + ".*", 2);
			RowFilter<StudentAbstractTable, Integer> namefilter = RowFilter.regexFilter(".*" + "(?i)" + parts[1] + ".*", 1);
			List<RowFilter<StudentAbstractTable, Integer>> filters = Arrays.asList(surnamefilter, namefilter);
			tableRowSorter.setRowFilter(RowFilter.andFilter(filters));
		} else {
			RowFilter<StudentAbstractTable, Integer> surnamefilter = RowFilter.regexFilter(".*" + "(?i)" + parts[0] + ".*", 2);
			RowFilter<StudentAbstractTable, Integer> namefilter = RowFilter.regexFilter(".*" + "(?i)" + parts[1] + ".*", 1);
			RowFilter<StudentAbstractTable, Integer> indexfilter = RowFilter.regexFilter(".*" + "(?i)" + parts[2] + ".*", 0);
			List<RowFilter<StudentAbstractTable, Integer>> filters = Arrays.asList(surnamefilter, namefilter, indexfilter);
			tableRowSorter.setRowFilter(RowFilter.andFilter(filters));
		}
	}
	
	public static StudentTable getTable() {
		if(studentTable == null) {
			studentTable = new StudentTable();
		}
		
		return studentTable;
	}
}
