package Model;

import java.util.ArrayList;

public class Chair {
	private String code;
	private String nameOfChair;
	private Profesor directorOfChair;
	private ArrayList<Profesor> profOnChair;
	
	public Chair(String code, String name, Profesor prof) {
		this.code = code;
		this.nameOfChair = name;
		this.directorOfChair = prof;
		profOnChair = new ArrayList<Profesor>();
	}
}
