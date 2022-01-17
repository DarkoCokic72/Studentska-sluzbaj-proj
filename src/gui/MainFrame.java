package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import persistence.Serialization;
	
public class MainFrame extends JFrame {
		
	private static MainFrame mf = null;
	private ResourceBundle resourceBundle;
	public static boolean languageChanged = false;
	public static boolean englishLanguage = false;
	
	private MainFrame() { 
			
		super(); 
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		int width = d.width;
		int height = d.height;
		setSize(width*3/4, height*3/4); 
		
		setTitle("Studentska služba");
		setLocationRelativeTo(null);
		Image img=kit.getImage("images" + File.separator + "icon.png");
		setIconImage(img);
		
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				try {
					Serialization.serialization();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		MyToolBar toolbar = new MyToolBar();
		add(toolbar, BorderLayout.NORTH);
		
		StatusBar stBar = new StatusBar();
		add(stBar, BorderLayout.SOUTH);
		
		CentralPanel centralPanel = CentralPanel.getCentralPanel();
		centralPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 7, 20));
		add(centralPanel, BorderLayout.CENTER);
		
		resourceBundle = ResourceBundle.getBundle("messageResources.MessageResources", Locale.getDefault());
			
		revalidate(); 
		repaint();
		
	}
		

	public static MainFrame getMainFrame() {
		if (mf == null) {
			mf = new MainFrame();
		}
		return mf;
	}
		
	
	public void changeLanguage() {

		languageChanged = true;
		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
		setTitle(resourceBundle.getString("naslovAplikacije"));
		MenuBar.initComponents();
		StatusBar.initComponents();
		CentralPanel.initComponents();
		MyToolBar.initComponents();
		validate();
		
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
}
	
	
