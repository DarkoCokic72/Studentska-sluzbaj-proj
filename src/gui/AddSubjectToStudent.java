package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import Model.Grade;
import Model.Student;
import Model.StudentDatabase;
import Model.Subject;
import Model.SubjectDatabase;

public class AddSubjectToStudent extends JDialog{
	private List<Subject> subjectsToAdd;
	private Student student;
	
	public AddSubjectToStudent(String indexID) {
		setTitle("Dodavanje predmeta");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width * 3/10, d.height * 9/20);
		setModal(true);
		DefaultListModel<String> displayModel = new DefaultListModel<>();
		setLocationRelativeTo(EditStudentDialog.getEditStudentDialog());
		student = StudentDatabase.getInstance().getStudentByIndex(indexID);
		
		List<Subject> passed =  getByGrade(student, GradeDatabase.getInstance().getGrades());
		subjectsToAdd = new ArrayList<Subject>(SubjectDatabase.getDatabase().getSubjects());
		
		removeSubjectsByUnfitYear();
		removeUnpassedSubjects(subjectsToAdd, student.getUnpassedCourses());
		removePassedSubjects(subjectsToAdd, passed);
		
		for(Subject s: subjectsToAdd) {
			String name = s.getSubjectCode() + " - " + s.getSubjectName();
			displayModel.addElement(name);
		}
		
		JList<String> display = new JList<String>(displayModel);
		display.setFixedCellWidth(getWidth() * 3/4);
		display.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		display.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 3, true));
		
		JScrollPane scroll = new JScrollPane(display);
		JPanel central = new JPanel();
		JPanel south = new JPanel();
		
		JButton addBtn = new JButton("Dodaj");
		JButton cancelBtn = new JButton("Odustani");
		
		addBtn.setSize(new Dimension(60, 30));
		cancelBtn.setSize(new Dimension(60, 30));
		
		central.setLayout(new BorderLayout());
		central.add(scroll, BorderLayout.CENTER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		central.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
		
		south.setBorder(BorderFactory.createEmptyBorder(0, 40, 30, 40));
		south.add(addBtn);
		
		if(subjectsToAdd.isEmpty()) {
			addBtn.setEnabled(false);
		}
		
		south.add(Box.createRigidArea(new Dimension(35, 0)));
		
		south.add(cancelBtn);
		
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Subject s = subjectsToAdd.get(display.getSelectedIndex());
				subjectsToAdd.remove(display.getSelectedIndex());
				student.getUnpassedCourses().add(s);
				UnpassedExamsTable.getTable().updateTable();
				validate();
				dispose();
				
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		add(central, BorderLayout.CENTER);
		add(south,BorderLayout.SOUTH);
		
	}
	
	private void removeSubjectsByUnfitYear() {
		int index = 0;
		Student st = EditStudentInformationTab.getStudent();
		ArrayList<Subject> copy = new ArrayList<Subject>(subjectsToAdd);
		
		for(Subject s: copy) {
			if(st.getCurrYearOfStudies() < s.getYearOfStudy()) {
				subjectsToAdd.remove(index);
				index--;
			}
		index++;
		}
	}
	
	private void removePassedSubjects(List<Subject> subjToAdd, List<Subject> passedSubjs) {
		if(!passedSubjs.isEmpty()) {
			for(int i = 0; i < passedSubjs.size(); i++) {
				for(int j = 0; j < subjToAdd.size(); j++) {
					if(passedSubjs.get(i).getSubjectCode().equalsIgnoreCase(subjToAdd.get(j).getSubjectCode())) {
						subjToAdd.remove(j);
					}
				}
			}
		}
		
	}
	
	private void removeUnpassedSubjects(List<Subject> subjToAdd, ArrayList<Subject> unpassedSubjs) {
		if(!unpassedSubjs.isEmpty()) {
			for(int i = 0; i < unpassedSubjs.size(); i++) {
				for(int j = 0; j < subjToAdd.size(); j++) {
					if(unpassedSubjs.get(i).getSubjectCode().equalsIgnoreCase(subjToAdd.get(j).getSubjectCode())) {
						subjToAdd.remove(j);
					}
				}
			}
		}
	}
	
	private List<Subject> getByGrade(Student s, List<Grade> grades) {
		List<Subject> subjects = new ArrayList<Subject>();
		for(Grade g: grades) {
			if(g.getStudent().getIndexID().equalsIgnoreCase(s.getIndexID())) {
				subjects.add(g.getPassedSubject());
			}
		}
		
		return subjects;
	}
	
	

}
