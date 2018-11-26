package presentationPackage;

import domainPackage.Document;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Buyer extends Person {
    public Connection jdbc_connection;
    public Statement statement;
    private ShoppingCart cart;
    
    public Buyer() {
    	
    }

    public Buyer(String u) {
    	super(u);
    }

    public ResultSet searchDocumentbyTitle(){
        String title= JOptionPane.showInputDialog("Search the title:");
            String sql = "SELECT * FROM Documents WHERE TITLE="+ title;
        try {
            statement = jdbc_connection.createStatement();
            ResultSet books = statement.executeQuery(sql);
            return books;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void placeOrder(){
        double total_price =0;
        String message ="Would You Like to Buy";
        for (int i=0; i< cart.docs.size();i++){
            total_price+= cart.docs.get(i).getPrice();
            message+=cart.docs.get(i).getTitle()+", ";
        }
        message +="with total amount of $"+total_price+"?";
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog (null,
                message,"Please Confirm",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
            makePayment();
        }
    }


    public void makePayment(){
        Order order = new Order(this, cart);
        for (int i=0; i< cart.docs.size();i++){
            cart.docs.get(i).soldOne();
        }
        String sql = "INSERT INTO transaction" +
                " VALUES ( " +  ");";
        try{
            statement = jdbc_connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void register(){
        String username="";
        String password="";
        String sql = "INSERT INTO USERS" +
                " VALUES ( " + username + ", '" +
                password + ");";
        try{
            statement = jdbc_connection.createStatement();
            statement.executeUpdate(sql);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

    }

    public void addToCart(Document doc){
        this.cart.docs.add(doc);
    }

    public void removeFromCart(Document doc){
        this.cart.docs.remove(doc);
    }

	
}
