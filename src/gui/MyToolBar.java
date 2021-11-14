package gui;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class MyToolBar extends JToolBar {
	
	public MyToolBar() {
		
		super(SwingConstants.HORIZONTAL);
		
		JButton btnCreate = new JButton();
		btnCreate.setToolTipText("Create entity");
		btnCreate.setIcon(new ImageIcon("images/Plus-icon.png"));
		add(btnCreate);

		addSeparator();

		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit entity");
		btnEdit.setIcon(new ImageIcon("images/Pen-5-icon.png"));
		add(btnEdit);

		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete entity");
		btnDelete.setIcon(new ImageIcon("images/Recycle-Bin-icon.png"));
		add(btnDelete);
		
		addSeparator();
		
		JTextField textField = new JTextField();
		add(textField);
		
		addSeparator();
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search entity");
		btnSearch.setIcon(new ImageIcon("images/search-icon.png"));
		add(btnSearch);
				
		
	}

}
