package main;

import java.util.Arrays;
import java.util.List;

public class Card {
    private int cardNumber;
    private String cardColor;

    public Card(String card) {
        String cardNumber=card.split("")[0];
        String cardColor=card.split("")[1];
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


}
