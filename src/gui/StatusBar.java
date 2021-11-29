package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusBar extends JPanel {
	public StatusBar() {
		super();
		setLayout(new BorderLayout());
		
		JLabel labTitle = new JLabel("Studentska sluzba");
		labTitle.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 0));
		Date currDate = new Date();
		
		/*Inspirational references:
		 * https://www.youtube.com/watch?v=qc930nafWdM
		 * https://www.youtube.com/watch?v=9gxeDtbeX0c
		 *  */
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd.MM.YYYY");
		JLabel labTime = new JLabel(dateFormat.format(currDate));
		labTime.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 30));
		
		
		Timer timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date datum = new Date();
				dateFormat.format(datum);
				
			}
		});
		
		timer.start();
		
		add(labTitle, BorderLayout.WEST);
		add(labTime, BorderLayout.EAST);
		
		
	}
}
