package gui;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import Model.Grade;
import Model.Student;
import Model.StudentDatabase;

public class PassedExamsTable extends JTable{
	private static PassedExamsTable passedExamsTable = null;
	private PassedExamsAbstractTable model;
	
	public PassedExamsTable() {
		model = new PassedExamsAbstractTable();
		setModel(model);
	    setCellSelectionEnabled(false);
   	    setRowSelectionAllowed(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTableHeader().setReorderingAllowed(false);
	}
	
	public void updateTable() {
    	model.fireTableDataChanged();
    	repaint();
    	validate();
    }
	
	public static PassedExamsTable getInstance() {
		if(passedExamsTable == null)
			passedExamsTable = new PassedExamsTable();
		
		return passedExamsTable;
	}
	
	public static void initComponents() {
    	
		passedExamsTable.getColumnModel().getColumn(0).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("subjectCode"));
 		passedExamsTable.getColumnModel().getColumn(1).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("subjectName"));
 		passedExamsTable.getColumnModel().getColumn(2).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("ESPB"));
 		passedExamsTable.getColumnModel().getColumn(3).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("grade"));
 		passedExamsTable.getColumnModel().getColumn(4).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("date"));
 		
 		ArrayList<Grade> gradeList = GradeDatabase.getInstance().getGrades();
 		for(Grade g: gradeList) {
 			
 			DateFormat dateFormat = DateFormat.getDateInstance();
 			String dateString = dateFormat.format(g.getDateOfExam());
 			
 			Date retDate = null;
 			
 			try {
				retDate = dateFormat.parse(dateString);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
			}
 			
 			g.setDateOfExam(retDate);
 			
 		}		
 		passedExamsTable.updateTable();	

	}
}
