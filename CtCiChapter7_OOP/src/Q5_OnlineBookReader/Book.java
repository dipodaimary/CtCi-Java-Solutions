package Q5_OnlineBookReader;

public class Book {
    private int bookID;
    private String details;

    public Book(int id, String str) {
        bookID = id;
        details = str;
    }

    public void update() {

    }

    public int getID() {
        return bookID;
    }

    public void setID(int id) {
        bookID = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
