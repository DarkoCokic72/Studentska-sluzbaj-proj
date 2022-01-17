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
		
		return teachesInstance;
	}

}
