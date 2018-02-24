package Chapter6.PoisonedBottle;

public class Bottle {
    private boolean isPoisoned = false;
    private int id;

    public Bottle(int id) {
        this.id = id;
    }

    public void setPoisoned() {
        isPoisoned = true;
    }

    public int getId() {
        return id;
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }
}
