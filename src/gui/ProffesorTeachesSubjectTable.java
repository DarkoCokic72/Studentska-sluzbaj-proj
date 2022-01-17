package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;

public class ProffesorTeachesSubjectTable extends JTable{
	
	private ProfessorTeachesSubjectAbstractTable model;
	private TableRowSorter<ProfessorTeachesSubjectAbstractTable> sorter;
	private static ProffesorTeachesSubjectTable teachesInstance = null;
	
	private ProffesorTeachesSubjectTable() {
		model = new ProfessorTeachesSubjectAbstractTable();
		setRowSelectionAllowed(true);
		setColumnSelectionAllowed(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTableHeader().setReorderingAllowed(false);
		setModel(model);
		setRowSorter(sorter);
	}
	
	public  void updateTable() {
		model.fireTableDataChanged();
	}
	
	public static ProffesorTeachesSubjectTable getInstance() {
		if(teachesInstance == null)
			teachesInstance = new ProffesorTeachesSubjectTable();
		
		if(MainFrame.languageChanged) {
			initComponents();
		}
		
		return teachesInstance;
	}
	
	 public static void initComponents() {
	 		
	 		teachesInstance.getColumnModel().getColumn(0).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("subjectCode"));
	 		teachesInstance.getColumnModel().getColumn(1).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("subjectName"));
			teachesInstance.getColumnModel().getColumn(2).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("subjectYear"));
			teachesInstance.getColumnModel().getColumn(3).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("subjectTerm"));
			 		
	 		teachesInstance.updateTable();	
	 		
	 	}

}
