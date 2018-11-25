package presentationPackage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OperatorGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OperatorGUI window = new OperatorGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OperatorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 318, 206);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddDocuments = new JButton("Add Document");
		btnAddDocuments.setBounds(76, 29, 140, 25);
		frame.getContentPane().add(btnAddDocuments);
		
		JButton btnRemoveDocument = new JButton("Remove Document");
		btnRemoveDocument.setBounds(76, 67, 140, 25);
		frame.getContentPane().add(btnRemoveDocument);
		
		JButton btnEditDocument = new JButton("Edit Document");
		btnEditDocument.setBounds(76, 105, 140, 25);
		frame.getContentPane().add(btnEditDocument);
	}

}
