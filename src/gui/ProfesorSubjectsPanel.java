package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProfesorSubjectsPanel extends JPanel {
	
	private static JButton removeBtn;
	private static JButton addBtn;
	private static ProfesorSubjectsPanel profsubjInstance = null;
	
	public ProfesorSubjectsPanel() {
		ProffesorTeachesSubjectTable.getInstance().updateTable();
		
		setLayout(new BorderLayout());
		ProffesorTeachesSubjectTable table = ProffesorTeachesSubjectTable.getInstance();
		
		JScrollPane scroll = new JScrollPane(table);
		
		addBtn = new JButton("Dodaj predmet");
		removeBtn = new JButton("Ukloni predmet");
		
		addBtn.setPreferredSize(new Dimension(130, 30));
		removeBtn.setPreferredSize(new Dimension(130, 30));
		
		scroll.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		JPanel north = new JPanel(new FlowLayout(FlowLayout.LEFT));
		north.setBorder(BorderFactory.createEmptyBorder(21, 21, 21, 21));
		
		north.add(addBtn, BorderLayout.WEST);
		north.add(removeBtn, BorderLayout.WEST);
		
		addBtn.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {}
			
			@Override
			public void mousePressed(MouseEvent e) {}
			
			@Override
			public void mouseExited(MouseEvent e) {}
			
			@Override
			public void mouseEntered(MouseEvent e) {}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				//AddSubjectToProf
				AddSubjectToProfessorDialog addSubjToProf = AddSubjectToProfessorDialog.getAddSubjectToProfessorDialog();
				addSubjToProf.setVisible(true);
			}
		});
		
		removeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//RemoveSubjectFromProf
				if(ProffesorTeachesSubjectTable.getInstance().getSelectedRow() != -1) {
					RemoveSubjectFromProfessor remSubjFromProf = RemoveSubjectFromProfessor.getRemoveSubjectFromProfessor();
					remSubjFromProf.setVisible(true);
				} else {
					if(MainFrame.languageChanged) {
						JOptionPane.showMessageDialog(null, MainFrame.getMainFrame().getResourceBundle().getString("selectRowError"));
						return;
					}
					JOptionPane.showMessageDialog(EditProfessorDialog.getEditProfessorDialog(), "Označite vrstu koju želite da izbrišete");
				}
				
			}
		});
		
		add(north, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
	}

	public static JButton getRemoveBtn() {
		return removeBtn;
	}

	public static void setRemoveBtn(JButton removeBtn) {
		ProfesorSubjectsPanel.removeBtn = removeBtn;
	}
	
	public static void deleteInstance() {
		profsubjInstance = null;
	}
	
	public static ProfesorSubjectsPanel getInstance() {
		if(profsubjInstance == null)
			profsubjInstance = new ProfesorSubjectsPanel();
		
		if(MainFrame.languageChanged) {
			initComponents();
		}
		
		return profsubjInstance;
	}
	
	 public static void initComponents() {
	 		
		 removeBtn.setText(MainFrame.getMainFrame().getResourceBundle().getString("removeSubjectBtn"));
		 addBtn.setText(MainFrame.getMainFrame().getResourceBundle().getString("addSubjectBtn"));
	 		
	 }

}
