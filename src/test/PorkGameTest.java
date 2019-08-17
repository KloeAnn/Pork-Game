package test;

import main.PorkGame;
import org.junit.Test;

import static org.junit.Assert.*;

public class PorkGameTest {

    @Test
    public void testPlayPorkGame_given2C_AD_thenReturnPlayer2Wins() {
        String cards="3C_AD";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player2 wins",gameResult);
    }
}