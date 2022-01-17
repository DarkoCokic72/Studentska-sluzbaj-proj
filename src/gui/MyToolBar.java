package gui;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
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
				
		btnCreate.addMouseListener(new MouseListener() {

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
				MainController.add();
			}

		});
		
		
		btnEdit.addMouseListener(new MouseListener() {

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
				
				MainController.edit();
			}
			
		});
		
		btnDelete.addMouseListener(new MouseListener() {

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
				
				MainController.delete();

				
			}
			
		});
		
		btnSearch.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				MainController.search(textField);
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
