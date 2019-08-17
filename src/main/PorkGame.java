package main;

import java.util.Arrays;
import java.util.List;

public class PorkGame {
    private List<Card> cards;

    public PorkGame(String c) {
        Card card1 = new Card(c.split("_")[0]);
        Card card2 = new Card(c.split("_")[1]);

        this.cards = Arrays.asList(card1, card2);
    }

    public List<Card> getCards() {
        return cards;
    }

    public String playPorkGame() {
        List<Card> cards = getCards();
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        if (card1.getCardNumber() > card2.getCardNumber()) {
            return "player1 wins";
        } else {
            if (card1.getCardNumber() < card2.getCardNumber()) {
                return "player2 wins";
            } else {
                return "This game is a draw";
            }
        }
    }
}