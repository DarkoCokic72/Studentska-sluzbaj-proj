package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
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
		
		setTitle("Studentska služba");
		setLocationRelativeTo(null);
		Image img=kit.getImage("images/icon.png");
		setIconImage(img);
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		MyToolBar toolbar = new MyToolBar();
		add(toolbar, BorderLayout.NORTH);
		
		CentralPanel centralPanel = new CentralPanel();
		centralPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 7, 20));
		add(centralPanel, BorderLayout.CENTER);
		
		}
}
	
	
