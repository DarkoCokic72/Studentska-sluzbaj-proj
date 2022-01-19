package Model;

import java.util.ArrayList;

public class ChairDatabase {
	
	private static ChairDatabase instance = null;
	private ArrayList<Chair> chairs;
	private ArrayList<String> columns;
	
	public ChairDatabase() {
		chairs = new ArrayList<Chair>();
		columns = new ArrayList<String>();
		
		columns.add("Šifra");
		columns.add("Naziv");
		columns.add("Šef katedre");
		
		
	}
	
	public int getRowCount() {
		return chairs.size();
	}
	
	public int getColumnCount() {
		return columns.size();
	}
	
	public String getValueAt(int row, int column) {
		Chair chair = chairs.get(row);
		
		String name = chair.getDirectorOfChair().getName();
		String surname = chair.getDirectorOfChair().getSurname();
		
		switch(column) {
			case 0:
				return chair.getCode();
			case 1: 
				return chair.getNameOfChair();
			case 2:
				return name + " " + surname;
			default:
				return null;
		}
		
	}
	
	public String getColumnName(int index) {
		return columns.get(index);
	}
	
	public void addChairIntoTable(Chair c) {
		chairs.add(c);
	}
	
	public ArrayList<Chair> getChairs(){
		return chairs;
	}
	
	public Chair getChairFromRow(int row) {
		return chairs.get(row);
	}
	
	public static ChairDatabase getInstance() {
		if(instance == null)
			instance = new ChairDatabase();
		
		return instance;
	}

	public void setChairs(ArrayList<Chair> chairs) {
		this.chairs = chairs;
	}
	
	
	public Chair getByCode(String code) {
		for(Chair c: chairs) {
			if(c.getCode().equalsIgnoreCase(code)) {
				return c;
			}
		}
		
		return null;
	}
	
	

}
