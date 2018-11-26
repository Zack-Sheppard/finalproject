package domainPackage;

import java.util.ArrayList;
import java.util.Date;

public class Document {
    private String title;
    private boolean onSale;
    private double price;
    private Author author;
    private String type;
    private String genre;
    private String publisher;
    private int quantity;

    public Document(String title, String type, String genre, double price, String publisher){
        this.title=title;
        this.type=type;
        this.genre=genre;
        this.price=price;
        this.publisher=publisher;

    }

    public String getPublisher() {
        return publisher;
    }

    public String getType() {
        return type;
    }

    public String getGenre() {
        return genre;
    }


    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }


    public boolean isOnSale() {
        return onSale;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void soldOne(){
        quantity--;
    }

    public String toString(){
        String doc = this.title + " " + this.type + " " + this.price + " " + this.author;
        return doc;
    }
}
