package Q5_OnlineBookReader;

public class Display {
    private Book activeBook;
    private User activeUser;
    private int pageNumber = 0;

    public void displayUser(User user) {
        activeUser = user;
        refreshUsername();
    }

    public void displayBook(Book book) {
        pageNumber = 0;
        activeBook = book;
        refreshTitle();
        refreshDetails();
        refreshPage();
    }

    private void refreshPage() {
    }

    private void refreshDetails() {
    }

    private void refreshTitle() {
    }

    private void refreshUsername() {
    }

    public void turnPageForward() {
        pageNumber++;
        refreshPage();
    }

    public void turnPageBackward() {
        pageNumber--;
        refreshPage();
    }
}
