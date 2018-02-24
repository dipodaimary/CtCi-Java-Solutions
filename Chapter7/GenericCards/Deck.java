package Chapter7.GenericCards;

import java.util.ArrayList;
import java.util.Random;

public class Deck<T extends Card> {
    private ArrayList<T> cards;
    private int dealIndex = 0;

    public Deck() {

    }

    public void setDeckOfCards(ArrayList<T> deckOfCards) {
        cards = deckOfCards;
    }

    public void shuffle() {
        Random r = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int j = r.nextInt(cards.size());
            T card1 = cards.get(i);
            T card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    public int remainingCards() {
        return cards.size() - dealIndex;
    }

    public T[] dealHand(int number) {
        if (remainingCards() < number) {
            return null;
        }
        T[] hand = (T[]) new Card[number];
        int count = 0;
        while (count < number) {
            T card = dealCard();
            if (card != null) {
                hand[count] = card;
                count++;
            }
        }
        return hand;
    }

    public T dealCard() {
        if (remainingCards() == 0) {
            return null;
        }
        T card = cards.get(dealIndex);
        card.markAvailable();
        dealIndex++;
        return card;
    }

    public void print() {
        for (Card card : cards) {
            card.print();
        }
    }
}
