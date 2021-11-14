package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
	
public class MainFrame extends JFrame {
		
		public MainFrame() { 
			
		super(); 
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width*3/4, height*3/4); 
		
		setTitle("Studentska slu�ba");
		setLocationRelativeTo(null);
		Image img=kit.getImage("images/icon.png");
		setIconImage(img);
		getContentPane().setBackground(Color.GRAY);
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		}
}
	
	
