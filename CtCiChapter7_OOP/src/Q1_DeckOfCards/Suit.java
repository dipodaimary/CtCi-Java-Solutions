package Q1_DeckOfCards;

public enum Suit {
    Club(0),
    Diamond(1),
    Heart(2),
    Spade(3);
    private int value;

    private Suit(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuitFromValue(int v) {
        switch (v) {
            case 0:
                return Suit.Club;
            case 1:
                return Suit.Diamond;
            case 2:
                return Suit.Heart;
            case 3:
                return Suit.Spade;
            default:
                return null;
        }
    }
}
