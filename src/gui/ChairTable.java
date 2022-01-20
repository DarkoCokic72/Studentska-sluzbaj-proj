package gui;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ChairTable extends JTable{
	
	private ChairAbstractTable model;
	private static ChairTable chTable = null;
	
	public ChairTable() {
		model = new ChairAbstractTable();
		setCellSelectionEnabled(false);
		setRowSelectionAllowed(true);
		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		getTableHeader().setReorderingAllowed(false);
		setModel(model);
	}
	
	public static ChairTable getInstance() {
		if(chTable == null)
			chTable = new ChairTable();
		
		return chTable;
	}
	
	public void updateTable() {
		model.fireTableDataChanged();
	}
	
	public static void initComponents() {
		chTable.getColumnModel().getColumn(0).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("chairCodeCol"));
		chTable.getColumnModel().getColumn(1).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("chairNameCol"));
		chTable.getColumnModel().getColumn(2).setHeaderValue(MainFrame.getMainFrame().getResourceBundle().getString("chairDirCol"));
		
		chTable.updateTable();
	}

}
