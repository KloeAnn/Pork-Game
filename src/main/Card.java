package main;

import com.sun.media.jfxmedia.effects.EqualizerBand;
import com.sun.org.apache.xpath.internal.operations.Equals;

import java.util.Arrays;
import java.util.List;

public class Card implements Comparable<Card> {
    private int cardNumber;
    private String cardColor;

    public Card(String card) {
        String cardNumber=card.split("")[0];
        String cardColor=card.split("")[1];
//        System.out.println(card);
        this.cardNumber = transformCardNumber(cardNumber);
        this.cardColor = cardColor;
    }

    public String getCardColor() {
        return cardColor;
    }


    public int getCardNumber() {
        return cardNumber;
    }

    public int transformCardNumber(String str) {
        if (str.equals("2")|| str.equals("3")||str.equals("4")|| str.equals("5")|| str.equals("6")||str.equals("7")||str.equals("8")||str.equals("9")) {
            return Integer.parseInt(str);
        } else {
            switch (str) {
                case "T":
                    return 10;
                case "J":
                    return 11;
                case "Q":
                    return 12;
                case "K":
                    return 13;
                default:
                    return 14;
            }
        }
    }

    @Override
    public int compareTo(Card card ){
        if(this.getCardNumber() >= card.getCardNumber()){
            return 1;
           }else {
            return -1;
        }
    }


}
