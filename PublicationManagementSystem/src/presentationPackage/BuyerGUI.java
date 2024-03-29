package presentationPackage;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import storagePackage.Driver;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import domainPackage.Document;

public class BuyerGUI {

	private JFrame frame;
	public Buyer buyer;
	public boolean isRegistered;
	public ArrayList<Document> searched;
	public ArrayList<Document> cart;
	
	DefaultListModel<String> model;
	ListSelectionModel select;
	
	DefaultListModel<String> model_1;
	ListSelectionModel select_1;
	
	Document selectedDoc;
	
	JButton btnAddToCart;
	JButton btnRemoveFromCart;
	JButton btnPlaceOrder;

	/**
	 * Create the application.
	 */
	public BuyerGUI(Buyer b, boolean reg) {
		buyer = b;
		isRegistered = reg;
		cart = new ArrayList<Document>();
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
		frame.setBounds(100, 100, 609, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				search();
			}
		});
		btnSearch.setBounds(97, 38, 97, 25);
		frame.getContentPane().add(btnSearch);
		
		if(isRegistered) {
			JButton btnUnregister = new JButton("Unregister");
			btnUnregister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					unreg();
				}
			});
			btnUnregister.setBounds(388, 38, 97, 25);
			frame.getContentPane().add(btnUnregister);
		}
		else {
			JButton btnRegister = new JButton("Register");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reg();
				}
			});
			btnRegister.setBounds(388, 38, 97, 25);
			frame.getContentPane().add(btnRegister);
		}
		
		
		btnAddToCart = new JButton("Add to Cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addToCart();
			}
		});
		btnAddToCart.setEnabled(false);
		btnAddToCart.setBounds(78, 395, 97, 25);
		frame.getContentPane().add(btnAddToCart);
		
		btnRemoveFromCart = new JButton("Remove from Cart");
		btnRemoveFromCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeFromCart();
			}
		});
		btnRemoveFromCart.setEnabled(false);
		btnRemoveFromCart.setBounds(227, 395, 137, 25);
		frame.getContentPane().add(btnRemoveFromCart);
		
		btnPlaceOrder = new JButton("Place Order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkout();
			}
		});
		btnPlaceOrder.setEnabled(false);
		btnPlaceOrder.setBounds(426, 395, 106, 25);
		frame.getContentPane().add(btnPlaceOrder);
		
		JLabel lblCart = new JLabel("Shopping Cart");
		lblCart.setBounds(248, 234, 97, 16);
		frame.getContentPane().add(lblCart);
		
		JButton btnPromotions = new JButton("Promotions");
		btnPromotions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getPromotions();
			}
		});
		if(!isRegistered) {
			btnPromotions.setEnabled(false);
		}
		btnPromotions.setBounds(237, 38, 116, 25);
		frame.getContentPane().add(btnPromotions);
		
		JLabel lblBooks = new JLabel("Books");
		lblBooks.setBounds(278, 90, 47, 16);
		frame.getContentPane().add(lblBooks);
		
		model = new DefaultListModel<String>();
		model_1 = new DefaultListModel<String>();
		
		String width = "9999999999999999999999999999999999999";
		
		JList<String> listArea = new JList<String>(model);
		select = listArea.getSelectionModel();
		select.addListSelectionListener(new ListSelectionHandler());
		listArea.setPrototypeCellValue(width);
		listArea.setVisibleRowCount(20);
		JScrollPane listScrollPane = new JScrollPane(listArea);
		
		JList<String> listArea_1 = new JList<String>(model_1);
		select_1 = listArea_1.getSelectionModel();
		select_1.addListSelectionListener(new ListSelectionHandler_1());
		listArea_1.setPrototypeCellValue(width);
		listArea_1.setVisibleRowCount(20);
		JScrollPane listScrollPane_1 = new JScrollPane(listArea_1);
		
		listScrollPane.setBounds(64, 119, 468, 102);
		frame.getContentPane().add(listScrollPane);
		
		listScrollPane_1.setBounds(64, 258, 468, 102);
		frame.getContentPane().add(listScrollPane_1);
		
	}
	
	public void reg() {
		RegisterGUI r = new RegisterGUI();
	}
	
	public void unreg() {
		int a = JOptionPane.showConfirmDialog(null, "Are you sure?");
		if(a == 0) {
			// delete
			Driver d = new Driver();
			d.unregister(buyer.getUsername());
			// close windows
			frame.dispose();
			System.exit(0);
		}
	}
	
	public void getPromotions() {
		
	}
	
	public void search() {
		String s = JOptionPane.showInputDialog("Enter Book Title");
	    if(s != null) {
	    	Driver d = new Driver();
			searched = d.search(s);
	    }
		for(int i = 0; i < searched.size(); i++) {
			model.addElement(searched.get(i).toString());
		}
		
	}
	
	public class ListSelectionHandler implements ListSelectionListener {
	    public void valueChanged(ListSelectionEvent e) {
	        if(e.getValueIsAdjusting()) {
	        	btnAddToCart.setEnabled(true);
	        	DefaultListSelectionModel model 
						= (DefaultListSelectionModel) e.getSource();
	        	int i = model.getMaxSelectionIndex();
	        	selectedDoc = searched.get(i);
	        }
	    }
	}
	
	public class ListSelectionHandler_1 implements ListSelectionListener {
	    public void valueChanged(ListSelectionEvent e) {
	        if(e.getValueIsAdjusting()) {
	        	btnRemoveFromCart.setEnabled(true);
	        	DefaultListSelectionModel model_1 
						= (DefaultListSelectionModel) e.getSource();
	        	int i = model_1.getMaxSelectionIndex();
	        	selectedDoc = cart.get(i);
	        }
	    }
	}
	
	public void addToCart() {
		// remove from searched list
		model.removeElement(selectedDoc.toString());
		// add to cart
		model_1.addElement(selectedDoc.toString());
		cart.add(selectedDoc);
		btnAddToCart.setEnabled(false);
		// enable checkout button
		btnPlaceOrder.setEnabled(true);
	}
	
	public void removeFromCart() {
		model_1.removeElement(selectedDoc.toString());
		cart.remove(selectedDoc);
		btnRemoveFromCart.setEnabled(false);
	}
	
	public void checkout() {
		String books = "";
		for(int i = 0; i < cart.size(); i++) {
			books += cart.get(i).toString() + " ";
		}
		int a = JOptionPane.showConfirmDialog(null, 
				"Buy " + books + "?");
		if(a == 0) {
			// delete book(s) from database
			Driver d = new Driver();
			for(int i = 0; i < cart.size(); i++) {
				d.removeDoc(cart.get(i).toString());
			}
		}
		frame.dispose();
	}
	
}
