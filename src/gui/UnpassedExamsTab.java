package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class UnpassedExamsTab extends JPanel{
	
	private static UnpassedExamsTab unpassedExamsTab = null;
	
	private static JButton btnDelete;
	private static JButton btnAdd;
	private static JButton btnPassExam;
	
	
	public UnpassedExamsTab() {
		
		btnAdd = new JButton("Dodaj");
		btnAdd.setPreferredSize(new Dimension(100,25));
		btnAdd.addMouseListener(new MouseListener() {
			
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

				AddSubjectToStudent addSubjectToStudent = AddSubjectToStudent.getAddSubjectToStudentDialog(EditStudentInformationTab.getStudent().getIndexID());
				addSubjectToStudent.setLocationRelativeTo(MainFrame.getMainFrame());
				addSubjectToStudent.setVisible(true);
			}
		});
		
		btnDelete = new JButton("Obriši");
		btnDelete.setPreferredSize(new Dimension(100,25));;
		btnDelete.addMouseListener(new MouseListener() {
			
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
				if(UnpassedExamsTable.getTable().getSelectedRow() == -1) {
					if(MainFrame.languageChanged) {
						JOptionPane.showMessageDialog(null, MainFrame.getMainFrame().getResourceBundle().getString("selectRowError"));
						return;
					}
					JOptionPane.showMessageDialog(null, "Označite predmet u tabeli koji želite da obrišete");
				} else {
				
					RemoveSubjectFromStudent removeSubjectFromStudent = RemoveSubjectFromStudent.getRemoveSubjectFromStudentDialog(EditStudentDialog.getEditStudentDialog());
					removeSubjectFromStudent.setLocationRelativeTo(MainFrame.getMainFrame());
					removeSubjectFromStudent.setVisible(true);
				}
			}
		});
		
		btnPassExam = new JButton("Polaganje");
		btnPassExam.setPreferredSize(new Dimension(100,25));
		btnPassExam.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow = UnpassedExamsTable.getTable().convertRowIndexToModel(UnpassedExamsTable.getTable().getSelectedRow());
				if(selectedRow == -1) {
					if(MainFrame.languageChanged) {
						JOptionPane.showMessageDialog(null, MainFrame.getMainFrame().getResourceBundle().getString("selectRowError"));
						return;
					}
					JOptionPane.showMessageDialog(null, "Selektujte vrstu u kojoj se nalazi predmet za koji želite da unesete ocenu");
					return;
				}
				GradeEntryDialog gradeEntryDialog = GradeEntryDialog.getGradeEntryDialog();
				gradeEntryDialog.setLocationRelativeTo(MainFrame.getMainFrame());
			}

		});
		
		
		JPanel northPanel = new JPanel();
		northPanel.add(btnAdd);
		northPanel.add(btnDelete);
		northPanel.add(btnPassExam);
		northPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane(UnpassedExamsTable.getTable());
		scrollPane.setPreferredSize(new Dimension(600,300));
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 50, 30, 80));
		
		add(northPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
			
		
	}
	
	public static UnpassedExamsTab getUnpassedExamsTab() {
		if(unpassedExamsTab == null) {
			unpassedExamsTab = new UnpassedExamsTab();
		}
		
		if(MainFrame.languageChanged == true) {
			initComponents();
		}
		
		return unpassedExamsTab;
	}
	
	public static void initComponents() {
		
		btnDelete.setText(MainFrame.getMainFrame().getResourceBundle().getString("deleteBtn"));
		btnAdd.setText(MainFrame.getMainFrame().getResourceBundle().getString("addBtn"));
		btnPassExam.setText(MainFrame.getMainFrame().getResourceBundle().getString("passExamBtn"));
		
		UnpassedExamsTable.initComponents();
		
	}

}
