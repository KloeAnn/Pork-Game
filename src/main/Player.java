package main;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Player {
    private Level level;

    public Player(String c) {
        this.level=new Level(c);
//        if(c.length()==2){
//            Card card = new Card(c);
//            this.cards = Arrays.asList(card);
//        }else{
//            Card card1 = new Card(c.split("_")[0]);
//            Card card2 = new Card(c.split("_")[1]);
//            Card card3 = new Card(c.split("_")[2]);
//            Card card4 = new Card(c.split("_")[3]);
//            Card card5 = new Card(c.split("_")[4]);
//
//            this.cards = Arrays.asList(card1, card2,card3,card4,card5);
//            Collections.sort(this.cards);
//        }
//        System.out.println(this.cards);
    }


    public Level getLevels() {
        return level;
    }
}
