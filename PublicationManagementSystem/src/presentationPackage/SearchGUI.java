package presentationPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import storagePackage.Driver;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import domainPackage.Document;

public class SearchGUI {

	private JFrame frame;
	private JTextField textField;
	
	public BuyerGUI bg;
	public JButton btnSearch;

	/**
	 * Create the application.
	 */
	public SearchGUI(BuyerGUI buyerGUI) {
		bg = buyerGUI;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					initialize();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 258, 213);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(25, 63, 56, 16);
		frame.getContentPane().add(lblTitle);
		
		textField = new JTextField();
		textField.setBounds(112, 60, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});
		btnSearch.setBounds(66, 117, 97, 25);
		frame.getContentPane().add(btnSearch);
		
		JLabel lblPleaseSearchUsing = new JLabel("Please Search By Book Title");
		lblPleaseSearchUsing.setBounds(37, 13, 203, 16);
		frame.getContentPane().add(lblPleaseSearchUsing);
	}
	
	public void search() {
		System.out.println("Searching");
		// Give all results to BuyerGUI.searched
		Driver d = new Driver();
		bg.searched = d.search(textField.getText());
		frame.dispose();
	}
	
}
