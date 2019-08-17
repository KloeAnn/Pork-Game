package main;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Level {
    private List<Card>cards;
    private int cardsLevel;
    private List<Integer> repeatNumber;
    private int tribleNumber;
    private int straightNumber;

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
            calculateCardsLevel();
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

    public int getMaxCard(){
        switch (getCardsLevel()){
            case 1:
                return getCards().get(getCards().size()-1).getCardNumber();
            case 2:
                return getRepeatNumber().get(0);
            case 3:
                return getRepeatNumber().get(getRepeatNumber().size()-1);
            case 4:
                return getTribleNumber();
            case 5:
                return getStraightNumber();
            default:
                return 0;
        }
    }

    public void calculateCardsLevel(){
        if(isFlush()){
            setCardsLevel(6);
        }else {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();
            repeatNumber = new ArrayList<>();
            getCards().stream().forEach(
                    p -> {
                        if (!list1.contains(p.getCardNumber())) {
                            list1.add(p.getCardNumber());
                        } else {
                            if (!list2.contains(p.getCardNumber())) {
                                list2.add(p.getCardNumber());
                            }
                        }
                    }
            );
//        Collections.sort(repeatNumber);
            //System.out.println(repeatNumber);
            switch (list1.size()) {
                case 4:
                    setCardsLevel(2);
                    repeatNumber.add(list2.get(0));
                    break;
                case 3:
                    if (list2.size() == 2) {
                        repeatNumber = list2;
                        Collections.sort(repeatNumber);
                        setCardsLevel(3);
                    } else {
                        setTribleNumber(list2.get(0));
                        setCardsLevel(4);
                    }
                    break;
                default:
                    if (isStraight(list1)) {
                        setCardsLevel(5);
                        setStraightNumber(list1.get(0));
                    } else {
                        setCardsLevel(1);
                    }
            }
            System.out.println(repeatNumber);
        }
    }

    public boolean isStraight(List<Integer>list){
        Collections.sort(list);
        if(list.get(4)-list.get(0)==4)
            return true;
        else
            return false;
    }
    public boolean isFlush(){
        Set set=new HashSet();
        getCards().stream().forEach(
                p->set.add(p.getCardColor())
        );
        if(set.size()==1)
            return true;
        else
            return false;
    }

    public int getTribleNumber() {
        return tribleNumber;
    }

    public void setTribleNumber(int tribleNumber) {
        this.tribleNumber = tribleNumber;
    }

    public int getStraightNumber() {
        return straightNumber;
    }

    public void setStraightNumber(int straightNumber) {
        this.straightNumber = straightNumber;
    }
}
