package main;

import java.util.Arrays;
import java.util.List;

public class PorkGame {
    private List<Player> players;

    public PorkGame(String c) {
        if (c.length() == 5) {
            Player player1 = new Player(c.substring(0, 2));
            Player player2 = new Player(c.substring(3));
            this.players = Arrays.asList(player1, player2);
        } else {
            Player player1 = new Player(c.substring(0, 14));
            Player player2 = new Player(c.substring(15));
            this.players = Arrays.asList(player1, player2);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }

    public String playPorkGame() {
        Card card1 = getPlayers().get(0).getMaxCard();
        Card card2 = getPlayers().get(1).getMaxCard();
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