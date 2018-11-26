package presentationPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;

import domainPackage.Document;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DocumentGUI {

	private JFrame frame;
	private Document doc;
	private int docID;
	private Operator op;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the application.
	 */
	public DocumentGUI(Operator o, Document d, int id) {
		op = o;
		docID = id;
		doc = d;
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
		frame.setBounds(100, 100, 396, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(135, 31, 217, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(135, 76, 217, 22);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(135, 123, 217, 22);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(135, 174, 217, 22);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(135, 225, 217, 22);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(135, 276, 217, 22);
		frame.getContentPane().add(textField_5);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(56, 34, 56, 16);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(56, 126, 56, 16);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setBounds(56, 79, 56, 16);
		frame.getContentPane().add(lblAuthor);
		
		JLabel lblPublisher = new JLabel("Publisher");
		lblPublisher.setBounds(56, 177, 56, 16);
		frame.getContentPane().add(lblPublisher);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(56, 228, 56, 16);
		frame.getContentPane().add(lblType);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setBounds(56, 279, 56, 16);
		frame.getContentPane().add(lblGenre);
		
		JButton btnFinalize = new JButton("Finalize");
		btnFinalize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finish();
			}
		});
		btnFinalize.setBounds(217, 322, 97, 25);
		frame.getContentPane().add(btnFinalize);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		btnCancel.setBounds(76, 322, 97, 25);
		frame.getContentPane().add(btnCancel);
	}
	
	public void finish() {
		// Get info from JTextFields, construct Doc
		
		// If ID > 0, delete the doc, then add the edited version
	}
	
	public void cancel() {
		// Close window
	}

}
