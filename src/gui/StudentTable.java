package gui;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;

import Model.Student;
import Model.StudentDatabase;

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
		repaint();
		validate();
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
	
	public static void initComponents() {
		
		studentTable.getColumnModel().getColumn(0).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("indexNumber"));
		studentTable.getColumnModel().getColumn(1).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("name"));
		studentTable.getColumnModel().getColumn(2).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("surname"));
		studentTable.getColumnModel().getColumn(3).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("yearOfStudy"));
		studentTable.getColumnModel().getColumn(4).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("status"));
		studentTable.getColumnModel().getColumn(5).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("avgMark"));
		
		ArrayList<Student> studentList = StudentDatabase.getInstance().getStudents();
 		for(Student s: studentList) {
 			
 			DateFormat dateFormat = DateFormat.getDateInstance();
 			String dateString = dateFormat.format(s.getDateOfBirth());
 			
 			Date retDate = null;
 			
 			try {
				retDate = dateFormat.parse(dateString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}
 			
 			s.setDateOfBirth(retDate);
 			
 			
 		}		
		
		studentTable.updateTable();	
		
	}
}
