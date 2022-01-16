package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StatusBar extends JPanel {
	
	private static StatusBar statusBar = null;
	private static JLabel labTitle;
	private static JLabel labTime;
	private static Timer timer;

	
	public StatusBar() {
		super();
		setLayout(new BorderLayout());
		
		labTitle = new JLabel("Studentska služba");
		labTitle.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 0));
		Date currDate = new Date();
		
		/*Inspirational references:
		 * https://www.youtube.com/watch?v=qc930nafWdM
		 * https://www.youtube.com/watch?v=9gxeDtbeX0c
		 *  */
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd.MM.YYYY");
		labTime = new JLabel(dateFormat.format(currDate));
		labTime.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
		
		
		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date datum = new Date();
				datum.setTime(System.currentTimeMillis());
				labTime.setText(dateFormat.format(datum));
				
			}
		});
		
		timer.start();
		
		JLabel labOpenedTab = new JLabel();
		
		/*Help from StackOverflow
		 * https://stackoverflow.com/questions/6799731/jtabbedpane-changelistener
		 * and from this site
		 * http://www.java2s.com/Tutorial/Java/0240__Swing/ListeningforSelectedTabChanges.htm*/
		
		CentralPanel.getCentralPanel().addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() instanceof JTabbedPane) {
					JTabbedPane pane = (JTabbedPane) e.getSource();
					int selectedIndex = pane.getSelectedIndex();
					String labText = pane.getTitleAt(selectedIndex);
					
					labOpenedTab.setText(labText);
					
				}
			}
		});
		labOpenedTab.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
		
		add(labTitle, BorderLayout.WEST);
		add(labOpenedTab, BorderLayout.CENTER);
		add(labTime, BorderLayout.EAST);
		
		
	}
	
	public static StatusBar getInstance() {
		if(statusBar == null) {
			statusBar = new StatusBar();
		}
		
		return statusBar;
	}
	
	public static void initComponents() {
		
		labTitle.setText(MainFrame.getMainFrame().getResourceBundle().getString("naslovAplikacije"));
		
		timer.stop();
        timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DateFormat df = DateFormat.getDateTimeInstance();
				Date datum = new Date();
				datum.setTime(System.currentTimeMillis());
				labTime.setText(df.format(datum));
				
			}
		});
		
		timer.start();
	}
	
}
