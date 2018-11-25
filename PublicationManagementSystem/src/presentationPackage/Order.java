package presentationPackage;

import domainPackage.Document;

import java.util.ArrayList;
import java.util.Date;

public class Order {
    private ArrayList<Document> docs;
    private Buyer buyer;
    private Date date;

    public Order(Buyer buyer, ShoppingCart cart){
        this.buyer=buyer;
        this.docs = cart.docs;
    }
}
