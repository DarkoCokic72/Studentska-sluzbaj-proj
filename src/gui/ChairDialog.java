package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Model.ChairDatabase;

public class ChairDialog extends JDialog{
	private static ChairDialog chairDialog = null;
	
	private static JButton setBtn;
	
	public ChairDialog() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;
		
		setSize(width * 3/8, height * 300 /444);
		setResizable(false);
		setVisible(true);
		setTitle("Katedre");
		
		setBtn = new JButton("Postavi šefa katedre");
		setBtn.setPreferredSize(new Dimension(150, 30));
		
		setBtn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int selectedRow = ChairTable.getInstance().getSelectedRow();
				if(selectedRow != -1) {
					SetDirectorOfChairDialog setDialog = SetDirectorOfChairDialog.getInstance(ChairDatabase.getInstance().
							getChairFromRow(selectedRow).getCode());
					setDialog.setLocationRelativeTo(MainFrame.getMainFrame());
					setDialog.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Izaberite vrstu za katedru kome postavljate šefa.");
					return;
				}
			}
		});
		
		JPanel north = new JPanel();
		north.add(setBtn, BorderLayout.WEST);
		north.setBorder(BorderFactory.createEmptyBorder(30, 0,0,0));
		
		JScrollPane scroll = new JScrollPane(ChairTable.getInstance());
		scroll.setPreferredSize(new Dimension(600, 300));
		scroll.setBorder(BorderFactory.createEmptyBorder(10, 50, 30, 80));
		
		add(north, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				chairDialog = null;
			}
		});
		
		revalidate();
		repaint();
	}
	
	public static ChairDialog getInstance() {
		if(chairDialog == null)
			chairDialog = new ChairDialog();
		
		return chairDialog;
	}
}
