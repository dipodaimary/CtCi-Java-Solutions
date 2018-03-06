package Q5_OnlineBookReader;

public class OnlineReaderSystem {
    private Library library;
    private UserManager userManager;
    Display display;
    Book activeBook;
    User activeUser;

    public OnlineReaderSystem() {
        userManager = new UserManager();
        library = new Library();
        display = new Display();
    }

    public Library getLibrary() {
        return library;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public Display getDisplay() {
        return display;
    }

    public Book getActiveBook() {
        return activeBook;
    }

    public void setActiveBook(Book b) {
        display.displayBook(b);
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User u) {
        activeUser = u;
        display.displayUser(u);
    }
}
