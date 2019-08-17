package main;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Level {
    private List<Card>cards;
    private int cardsLevel;
    private List<Integer> repeatNumber;
    private List<Integer> noRepeatNumber;
    private int tribleNumber;
    private int straightNumber;
    private List<Integer> flushNumber;
    private int fullHouseNumber;
    private int straightFlushNumber;

    public Level(String c) {
        if(c.length()==2){
            Card card = new Card(c);
            this.cards = Arrays.asList(card);
            setCardsLevel(1);

            setNoRepeatNumber(card.getCardNumber());
        }else{
            System.out.println(c.split("_")[0]);
            this.cards=new ArrayList<>();

            for(String s:c.split("_")){
                this.cards.add(new Card(s));
            }

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
            case 5:
                return getStraightNumber();
            case 8:
                return getFullHouseNumber();
            case 9:
                return getStraightFlushNumber();
            default:
                return getTribleNumber();
        }
    }

    public void calculateCardsLevel(){
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
        Collections.sort(list1);
        Collections.sort(list2);
            switch (list1.size()) {
                case 4:
                    setCardsLevel(2);
                    repeatNumber.add(list2.get(0));
                    setNoRepeatNumber(list1,list2);
                    break;
                case 3:
                    if (list2.size() == 2) {
                        setRepeatNumber(list2);
                        Collections.sort(getRepeatNumber());
                        setNoRepeatNumber(list1,list2);
                        setCardsLevel(3);
                    } else {
                        setTribleNumber(list2.get(0));
                        setCardsLevel(4);
                    }
                    break;
                case 2:
                    if(list2.size()==1){
                        setCardsLevel(8);
                        setFullHouseNumber(list2.get(0));
                    }else {
                        setCardsLevel(7);
                        int size=getCards().stream().filter(
                                p->p.getCardNumber()==list2.get(0)
                        ).collect(Collectors.toList()).size();

                        if(size==2){
                            repeatNumber=Arrays.asList(list2.get(0));
                            setTribleNumber(list2.get(1));
                        }else {
                            repeatNumber=Arrays.asList(list2.get(1));
                            setTribleNumber(list2.get(0));
                        }
                    }
                    break;
                default:
                    if (isStraight(list1)) {
                        if(isFlush()){
                            setCardsLevel(9);
                            setStraightFlushNumber(list1.get(0));
                        }else {
                            setCardsLevel(5);
                            setStraightNumber(list1.get(0));
                        }
                    } else {
                        if(isFlush()){
                            setCardsLevel(6);
                            setFlushNumber(list1);
                        }else {
                            setCardsLevel(1);
                            setNoRepeatNumber(list1);
                        }
                    }
            }
    }

    public boolean isStraight(List<Integer>list){
        Collections.sort(list);
        return(list.get(4)-list.get(0)==4 ? true : false);
    }
    public boolean isFlush(){
        Set set=new HashSet();
        getCards().stream().forEach(
                p->set.add(p.getCardColor())
        );
        return(set.size()==1 ? true : false);
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

    public List<Integer> getFlushNumber() {
        return flushNumber;
    }

    public void setFlushNumber(List<Integer> flushNumber) {
        this.flushNumber = flushNumber;
    }

    public int getFullHouseNumber() {
        return fullHouseNumber;
    }

    public void setFullHouseNumber(int fullHouseNumber) {
        this.fullHouseNumber = fullHouseNumber;
    }

    public int getStraightFlushNumber() {
        return straightFlushNumber;
    }

    public void setStraightFlushNumber(int straightFlushNumber) {
        this.straightFlushNumber = straightFlushNumber;
    }

    public List<Integer> getNoRepeatNumber() {
        return noRepeatNumber;
    }

    public void setNoRepeatNumber(List<Integer>list1,List<Integer>list2) {

        if(list2.size()==2) {
            this.noRepeatNumber=new ArrayList<>();
            this.noRepeatNumber.add(list1.stream().filter(
                    p -> p != list2.get(0) && p != list2.get(1)
            ).collect(Collectors.toList()).get(0));
        }else {
            this.noRepeatNumber=list1.stream().filter(
                    p -> p != list2.get(0)
            ).collect(Collectors.toList());
        }

    }

    public void setNoRepeatNumber(List<Integer>list1) {

        this.noRepeatNumber=list1;

    }

    public void setNoRepeatNumber(int num) {

        this.noRepeatNumber=Arrays.asList(num);

    }
}
