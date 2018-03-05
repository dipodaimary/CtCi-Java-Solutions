package Q3_JukeBox;

public class User {
    private String name;
    private long ID;

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public long getID() {
        return ID;
    }

    public void setID(long id) {
        ID = id;
    }

    public User(String n, long id) {
        name = n;
        ID = id;
    }

    public User getUser() {
        return this;
    }

    public static User addUser(String n, long id) {
        return new User(n, id);
    }
}
