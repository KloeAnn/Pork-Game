package main;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Level {
    private List<Card>cards;
    private int cardsLevel;
    private List<Integer> repeatNumber;

    public Level(String c) {
        if(c.length()==2){
            Card card = new Card(c);
            this.cards = Arrays.asList(card);
            setCardsLevel(1);
            setRepeatNumber(new ArrayList());
        }else{
            Card card1 = new Card(c.split("_")[0]);
            Card card2 = new Card(c.split("_")[1]);
            Card card3 = new Card(c.split("_")[2]);
            Card card4 = new Card(c.split("_")[3]);
            Card card5 = new Card(c.split("_")[4]);

            this.cards = Arrays.asList(card1, card2,card3,card4,card5);
            Collections.sort(this.cards);
            calculateCardsLevel(getCards());
        }
    }

    public int getCardsLevel() {
        return cardsLevel;
    }

    public void setCardsLevel(int cardsLevel) {
        this.cardsLevel = cardsLevel;
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Integer> getRepeatNumber() {
        return repeatNumber;
    }

    public void setRepeatNumber(List repeatNumber) {
        this.repeatNumber = repeatNumber;
    }

    public Card getMaxCard(){
        return getCards().get(getCards().size()-1);
    }

    public void calculateCardsLevel(List<Card> cards){
        repeatNumber=new ArrayList<>();
        getCards().stream().forEach(
                p -> {
                    if (!repeatNumber.contains(p.getCardNumber())) {
                        repeatNumber.add(p.getCardNumber());
                    }
                }
        );
        if(repeatNumber.size()==getCards().size()){
            setCardsLevel(1);
        }else {
            setCardsLevel(2);
        }
    }
}
