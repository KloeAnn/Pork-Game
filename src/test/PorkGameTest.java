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

    @Test
    public void testPlayPorkGame_given2C_4D_5H_6C_AD_2D_3D_5S_8C_QD_thenReturnPlayer1Wins() {
        String cards="2C_4D_5H_6C_AD_2D_3D_5S_8C_QD";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player1 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4C_4D_5H_6C_AD_2D_3D_5S_8C_QD_thenReturnPlayer1Wins() {
        String cards="4C_4D_5H_6C_AD_2D_3D_5S_8C_QD";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player1 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4C_4D_5H_6C_AD_2D_3D_5S_5C_QD_thenReturnPlayer1Wins() {
        String cards="4C_4D_5H_6C_AD_2D_3D_5S_5C_QD";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player2 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4C_4D_5H_5C_AD_2D_3D_5S_5D_QD_thenReturnPlayer1Wins() {
        String cards="4C_4D_5H_5C_AD_2D_3D_5S_5D_QD";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player1 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4C_4D_8H_8C_AD_2D_3D_3S_QH_QD_thenReturnPlayer1Wins() {
        String cards="4C_4D_8H_8C_AD_2D_3D_3S_QH_QD";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player2 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4C_4D_4H_8C_TD_2D_3D_3S_QH_QD_thenReturnPlayer1Wins() {
        String cards="4C_4D_4H_8C_TD_2D_3D_3S_QH_QD";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player1 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4C_4D_4H_8C_TD_2D_3D_4S_5H_6D_thenReturnPlayer1Wins() {
        String cards="4C_4D_4H_8C_TD_2D_3D_4S_5H_6D";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player2 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4C_5D_6H_7C_8D_2D_3D_4S_5H_6D_thenReturnPlayer1Wins() {
        String cards="4C_5D_6H_7C_8D_2D_3D_4S_5H_6D";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player1 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4C_5H_6H_7C_8D_2H_3H_4H_9H_KH_thenReturnPlayer1Wins() {
        String cards="4C_5H_6H_7C_8D_2H_3H_4H_9H_KH";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player2 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4D_5D_6D_7D_AD_2H_3H_4H_9H_KH_thenReturnPlayer1Wins() {
        String cards="4D_5D_6D_7D_AD_2H_3H_4H_9H_KH";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player1 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4D_4S_6D_4H_6S_2H_2S_2D_9H_9C_thenReturnPlayer1Wins() {
        String cards="4D_4S_6D_4H_6S_2H_2S_2D_9H_9C";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player1 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4D_4S_6D_4H_6S_2H_2S_2D_2C_9C_thenReturnPlayer1Wins() {
        String cards="4D_4S_6D_4H_6S_2H_2S_2D_2C_9C";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player2 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4D_5D_6D_7D_8D_9H_9S_9D_2C_9C_thenReturnPlayer1Wins() {
        String cards="4D_5D_6D_7D_8D_9H_9S_9D_2C_9C";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player1 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4D_5D_6D_7D_8D_9H_TH_JH_QH_KH_thenReturnPlayer1Wins() {
        String cards="4D_5D_6D_7D_8D_9H_TH_JH_QH_KH";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player2 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4D_5D_6D_7D_8D_4H_5H_8H_6H_7H_thenReturnPlayer1Wins() {
        String cards="4D_5D_6D_7D_8D_4H_5H_8H_6H_7H";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("This game is a draw",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4D_TD_6D_7D_8D_4H_5H_KH_6H_7H_thenReturnPlayer1Wins() {
        String cards="4D_TD_6D_7D_8D_4H_5H_KH_6H_7H";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player2 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4D_KD_6D_7D_8D_4H_5H_KH_6H_7H_thenReturnPlayer1Wins() {
        String cards="4D_KD_6D_7D_8D_4H_5H_KH_6H_7H";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player1 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4D_KD_6D_7D_8D_4H_8H_KH_6H_7H_thenReturnPlayer1Wins() {
        String cards="4D_KD_6D_7D_8D_4H_8H_KH_6H_7H";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("This game is a draw",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4D_5S_6D_7S_8D_4H_5D_6H_7D_8H_thenReturnPlayer1Wins() {
        String cards="4D_5S_6D_7S_8D_4H_5D_6H_7D_8H";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("This game is a draw",gameResult);
    }

    @Test
    public void testPlayPorkGame_given4D_4S_6D_7S_8D_5H_5D_6H_7D_8H_thenReturnPlayer1Wins() {
        String cards="4D_4S_6D_7S_8D_5H_5D_6H_7D_8H";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player2 wins",gameResult);
    }

    @Test
    public void testPlayPorkGame_given3D_3S_6D_6S_TD_3H_3C_6H_6C_9H_thenReturnPlayer1Wins() {
        String cards="3D_3S_6D_6S_TD_3H_3C_6H_6C_9H";

        PorkGame porkGame=new PorkGame(cards);

        String gameResult=porkGame.playPorkGame();

        assertEquals("player1 wins",gameResult);
    }

}