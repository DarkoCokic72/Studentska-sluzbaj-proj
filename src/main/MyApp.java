package main;

import Model.CompleteDatabase;
import gui.MainFrame;
import persistence.Deserialization;

public class MyApp {

	public static void main(String[] args) {
		
		Deserialization deserialization = Deserialization.getInstance();
		deserialization.deserialize();
		MainFrame mf = MainFrame.getMainFrame();
		
		//CompleteDatabase.fillDatabase();
		
	}
	

}