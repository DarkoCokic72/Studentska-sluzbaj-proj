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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNameOfChair() {
		return nameOfChair;
	}

	public void setNameOfChair(String nameOfChair) {
		this.nameOfChair = nameOfChair;
	}

	public Profesor getDirectorOfChair() {
		return directorOfChair;
	}

	public void setDirectorOfChair(Profesor directorOfChair) {
		this.directorOfChair = directorOfChair;
	}

	public ArrayList<Profesor> getProfOnChair() {
		return profOnChair;
	}

	public void setProfOnChair(ArrayList<Profesor> profOnChair) {
		this.profOnChair = profOnChair;
	}
	
	
}
