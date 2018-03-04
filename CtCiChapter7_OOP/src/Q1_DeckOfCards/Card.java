package Q1_DeckOfCards;

public abstract class Card {
    protected int faceValue;
    private boolean isAvailable;
    protected Suit suit;

    public Card(int c, Suit s) {
        faceValue = c;
        suit = s;
    }

    public abstract int value();

    public Suit getSuit() {
        return suit;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markAvailable() {
        isAvailable = true;
    }

    public void markUnAvailable() {
        isAvailable = false;
    }

    public void print() {
        String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        System.out.print(faceValues[faceValue - 1]);
        switch (suit) {
            case Club:
                System.out.println('c');
                break;
            case Diamond:
                System.out.println('d');
                break;
            case Heart:
                System.out.println('h');
                break;
            case Spade:
                System.out.println('s');
                break;
        }
    }
}
