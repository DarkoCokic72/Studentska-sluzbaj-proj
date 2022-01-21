package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ActionMap;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import Controller.MainController;

public class MyToolBar extends JToolBar {
	
	private static JButton btnCreate;
	private static JButton btnDelete;
	private static JButton btnEdit;
	private static JButton btnSearch;
	private static JTextField textField;
	
	public MyToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		btnCreate = new JButton();
		btnCreate.setToolTipText("Create entity");
		btnCreate.setIcon(new ImageIcon("images" + File.separator + "Plus-icon.png"));
		add(btnCreate); 
		
		addSeparator();

		btnEdit = new JButton();
		btnEdit.setToolTipText("Edit entity");
		btnEdit.setIcon(new ImageIcon("images" + File.separator +"Pen-5-icon.png"));
		add(btnEdit);

		addSeparator();
		
		btnDelete = new JButton();
		btnDelete.setToolTipText("Delete entity");
		btnDelete.setIcon(new ImageIcon("images" + File.separator + "Recycle-Bin-icon.png"));
		add(btnDelete);
		
		add(Box.createGlue());
		
		Dimension dim = new Dimension(150,20);
		
		textField = new JTextField();
		textField.setPreferredSize(dim);
		textField.setMaximumSize(textField.getPreferredSize());
		textField.setToolTipText("Type entity");
		add(textField);
		
		addSeparator();
		
		btnSearch = new JButton();
		btnSearch.setToolTipText("Search entity");
		btnSearch.setIcon(new ImageIcon("images" + File.separator +"search-icon.png"));
		add(btnSearch);
		
		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.add();
				
			}
			
		});
		
		KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_C , KeyEvent.CTRL_DOWN_MASK);
		int condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
		InputMap inputMap = btnCreate.getInputMap(condition);
		ActionMap actionMap = btnCreate.getActionMap();
		inputMap.put(keyStroke, keyStroke.toString());
	    actionMap.put(keyStroke.toString(), new AbstractAction() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 7529236918948520061L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnCreate.doClick();
			}
		});
		
	    btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainController.edit();
				
			}
	    	
	    });
	    
	    keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_E , KeyEvent.CTRL_DOWN_MASK);
		condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
		inputMap = btnEdit.getInputMap(condition);
		actionMap = btnEdit.getActionMap();
		inputMap.put(keyStroke, keyStroke.toString());
	    actionMap.put(keyStroke.toString(), new AbstractAction() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 3218530110365506595L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnEdit.doClick();
			}
		});
		
		
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainController.delete();
				
			}
			
		});
		
		keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_D , KeyEvent.CTRL_DOWN_MASK);
		condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
		inputMap = btnDelete.getInputMap(condition);
		actionMap = btnDelete.getActionMap();
		inputMap.put(keyStroke, keyStroke.toString());
	    actionMap.put(keyStroke.toString(), new AbstractAction() {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 5532527550873390851L;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnDelete.doClick();
			}
		});
		
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MainController.search(textField);
				
			}
			
		});
		
		keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_R , KeyEvent.CTRL_DOWN_MASK);
		condition = JComponent.WHEN_IN_FOCUSED_WINDOW;
		inputMap = btnSearch.getInputMap(condition);
		actionMap = btnSearch.getActionMap();
		inputMap.put(keyStroke, keyStroke.toString());
	    actionMap.put(keyStroke.toString(), new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btnSearch.doClick();
			}
		});
	    

		
	}
	
	 public static void initComponents() {
		btnCreate.setToolTipText(MainFrame.getMainFrame().getResourceBundle().getString("btnCreateText"));
		btnEdit.setToolTipText(MainFrame.getMainFrame().getResourceBundle().getString("btnEditText"));
		btnDelete.setToolTipText(MainFrame.getMainFrame().getResourceBundle().getString("btnDeleteText"));
		btnSearch.setToolTipText(MainFrame.getMainFrame().getResourceBundle().getString("btnSearchText"));
		textField.setToolTipText(MainFrame.getMainFrame().getResourceBundle().getString("btnSearchText"));
	 }

}
