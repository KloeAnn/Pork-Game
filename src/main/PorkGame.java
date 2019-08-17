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
        return comparePlayersLevels();
    }

    public String comparePlayersLevels(){
        Level level1 = getPlayers().get(0).getLevels();
        Level level2 = getPlayers().get(1).getLevels();

        if(level1.getCardsLevel()!=level2.getCardsLevel()) {
            System.out.println("hahaha");
            return compareResult(level1.getCardsLevel(),level2.getCardsLevel());
        }else {
            System.out.println(level1.getMaxCard());
            System.out.println(level2.getMaxCard());
            return compareResult(level1.getMaxCard(),level2.getMaxCard());
        }
    }

    public String compareResult(int number1,int number2){
        if (number1 > number2) {
            return "player1 wins";
        } else {
            if (number1 < number2) {
                return "player2 wins";
            } else {
                return "This game is a draw";
            }
        }
    }
}