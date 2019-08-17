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
        Level level1 = getPlayers().get(0).getLevels();
        Level level2 = getPlayers().get(1).getLevels();
        System.out.println(level1.getCardsLevel());
        System.out.println(level2.getCardsLevel());
        if (level1.getCardsLevel() > level2.getCardsLevel()) {
            return "player1 wins";
        } else {
            if (level1.getCardsLevel() > level2.getCardsLevel()) {
                return "player2 wins";
            } else {
                return "This game is a draw";
            }
        }
    }
}