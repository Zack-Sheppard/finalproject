package domainPackage;

import java.util.ArrayList;
import java.util.Date;

public class Document {
    private int id;
    private boolean onSale;
    private double price;
    private ArrayList<Author> authors;
    private Date publishDate;
    private String type;
    private String genre;
    private String publisher;
    private int numOfPages;



    public boolean isOnSale() {
        return onSale;
    }
}
