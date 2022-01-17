package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;

public class AddSubjectToProfessorTable extends JTable{
	private static AddSubjectToProfessorTable instance = null;
	private TableRowSorter<AddSubjectToProfessorAbstractTable> sorter;
	private AddSubjectToProfessorAbstractTable model;
	
	public AddSubjectToProfessorTable() {
		
		setColumnSelectionAllowed(true);
		setRowSelectionAllowed(true);
		setCellSelectionEnabled(false);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTableHeader().setReorderingAllowed(false);
		
		model = new AddSubjectToProfessorAbstractTable();
		
		setModel(model);
		sorter = new TableRowSorter<AddSubjectToProfessorAbstractTable>(model);
		setRowSorter(sorter);
	}
	
	public void updateTable() {
		AddSubjectToProfessorAbstractTable mod = (AddSubjectToProfessorAbstractTable) getModel();
		mod.fireTableDataChanged();
	}
	
	public static AddSubjectToProfessorTable getInstance() {
		if(instance == null)
			instance = new AddSubjectToProfessorTable();
		
		return instance;
	}
	
}
