package domainPackage;

import java.util.ArrayList;
import java.util.Date;

public class Document {
    private int id;
    private String title;
    private boolean onSale;
    private double price;
    private ArrayList<Author> authors;
    private String type;
    private String genre;
    private String publisher;

    public Document(int id, String title, String type, String genre, double price, String publisher){
        this.id=id;
        this.title=title;
        this.type=type;
        this.genre=genre;
        this.price=price;
        this.publisher=publisher;

    }


    public int getId() {
        return id;
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



    public ArrayList<Author> getAuthors() {
        return authors;
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

    public String toString(){
        String doc =this.id + " " + this.title + " " + this.type + " " + this.price;
        return doc;
    }
}
