package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Model.Chair;
import Model.ChairDatabase;
import Model.Profesor;
import Model.Profesor.Zvanje;

public class SetDirectorOfChairDialog extends JDialog{
	
	private static SetDirectorOfChairDialog setInstance = null;
	
	private List<Profesor> professorsToSet;
	private Chair chair;
	
	private static JButton setBtn;
	private static JButton cancelBtn;
	
	public SetDirectorOfChairDialog(String code) {
		setTitle("Postavljanje šefa katedre");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int width = d.width;
		int height = d.height;
		
		setSize(width * 3/10, height * 9/20);
		setModal(true);
		setLocationRelativeTo(ChairDialog.getInstance());
		
		chair = ChairDatabase.getInstance().getByCode(code);
		professorsToSet = new ArrayList<Profesor>(chair.getProfOnChair());
		
		DefaultListModel<String> displayModel = new DefaultListModel<>();
		
		removeProfsByUnfitYear();
		removeProfByUnfitTitle();
		
		for(Profesor p: professorsToSet) {
			String name = p.getName() + " " +p.getSurname();
			displayModel.addElement(name);
		}
		
		JList<String> display = new JList<String>(displayModel);
		display.setFixedCellWidth(getWidth() *3/4);
		display.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		display.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JScrollPane scroll = new JScrollPane(display);
		JPanel center = new JPanel();
		JPanel south = new JPanel();
		
		setBtn = new JButton("Postavi");
		cancelBtn = new JButton("Odustani");
		
		setBtn.setPreferredSize(new Dimension(100, 30));
		cancelBtn.setPreferredSize(new Dimension(100, 30));
		
		center.setLayout(new BorderLayout());
		center.add(scroll, BorderLayout.CENTER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		center.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
		
		south.setBorder(BorderFactory.createEmptyBorder(0, 40, 30, 40));
		south.add(setBtn);
		
		if(professorsToSet.isEmpty()) {
			setBtn.setEnabled(false);
		}
		
		south.add(Box.createRigidArea(new Dimension(35, 0)));
		
		south.add(cancelBtn);
		
		
		setBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectedIndex = display.getSelectedIndex();
				
				if(selectedIndex == -1) {
					JOptionPane.showMessageDialog(null, "Selektujte profesora koga želite da postavite.");
					return;
				} else {
					Profesor p = professorsToSet.get(display.getSelectedIndex());
					professorsToSet.remove(display.getSelectedIndex());
					chair.setDirectorOfChair(p);
					ChairTable.getInstance().updateTable();
					validate();
					dispose();
					setInstance = null;
				}
				
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				setInstance =null;
			}
		});
		
		add(center, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setInstance = null;
			}
		});
	}
	
	public void removeProfsByUnfitYear() {
		int index = 0;
		ArrayList<Profesor> copy = new ArrayList<Profesor>(professorsToSet);
		for(Profesor p: copy) {
			if(p.getYearsOfExperience() < 5) {
				professorsToSet.remove(index);
				index--;
			}
			
			index++;
		}
	}
	
	public void removeProfByUnfitTitle() {
		int index = 0;
		ArrayList<Profesor> copy = new ArrayList<Profesor>(professorsToSet);
		for(Profesor p: copy) {
			if(!(p.getZvanje() == Zvanje.VANREDNI_PROFESOR || p.getZvanje() == Zvanje.REDOVNI_PROFESOR)) {
				professorsToSet.remove(index);
				index--;
			}
			
			index++;
		}
	}
	
	public static SetDirectorOfChairDialog getInstance(String parent) {
		if(setInstance == null)
			setInstance = new SetDirectorOfChairDialog(parent);
		
		return setInstance;
	}

}
