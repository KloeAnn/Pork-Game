package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PorkGame {
    private List<Player> players;

    public PorkGame(String c) {
        int middleIndex=(c.length()-1)/2;
        Player player1 = new Player(c.substring(0, middleIndex));
        Player player2 = new Player(c.substring(middleIndex+1));
        this.players = Arrays.asList(player1, player2);
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
            System.out.println(level1.getCardsLevel());
            System.out.println(level2.getCardsLevel());
            return compareResult(level1.getCardsLevel(),level2.getCardsLevel());
        }else{
            switch (level1.getCardsLevel()){
                case 6:
                    return compareWhenLevelIs6(level1,level2);
                case 3:
                    return compareWhenLevelIs3(level1,level2);
                case 2:
                    return compareWhenLevelIs2(level1,level2);
                case 1:
                    return compareWhenLevelIs1(level1,level2);
                default:{
                    System.out.println(level1.getCardsLevel());
                    System.out.println(level2.getCardsLevel());
                    return compareResult(level1.getMaxCard(),level2.getMaxCard());
                }

            }
        }
    }

    public String compareWhenLevelIs6(Level level1,Level level2){
        System.out.println(level1.getCardsLevel());
        System.out.println(level2.getCardsLevel());
        List<Integer> list1 = level1.getFlushNumber();
        List<Integer> list2 = level2.getFlushNumber();
        return compareMutiTimes(list1,list2);
    }

    public String compareWhenLevelIs3(Level level1,Level level2){
        System.out.println(level1.getCardsLevel());
        System.out.println(level2.getCardsLevel());
        List<Integer> list1 =level1.getNoRepeatNumber();
        list1.addAll(level1.getRepeatNumber());
        List<Integer> list2 =level2.getNoRepeatNumber();
        list2.addAll(level2.getRepeatNumber());
        return compareMutiTimes(list1,list2);
    }

    public String compareWhenLevelIs2(Level level1,Level level2){
        System.out.println(level1.getCardsLevel());
        System.out.println(level2.getCardsLevel());
        List<Integer> list1 =level1.getNoRepeatNumber();
        list1.add(level1.getRepeatNumber().get(0));
        List<Integer> list2 =level2.getNoRepeatNumber();
        list2.add(level2.getRepeatNumber().get(0));
        return compareMutiTimes(list1,list2);
    }

    public String compareWhenLevelIs1(Level level1,Level level2){
        System.out.println(level1.getCardsLevel());
        System.out.println(level2.getCardsLevel());
        List<Integer> list1 =level1.getNoRepeatNumber();
        List<Integer> list2 =level2.getNoRepeatNumber();
        return compareMutiTimes(list1,list2);
    }

    public String compareMutiTimes(List<Integer>list1,List<Integer>list2){
        for(int i=list1.size()-1;i>=0;i--){
            String result=compareResult(list1.get(i),list2.get(i));
            if(!result.equals("This game is a draw"))
                return result;
        }
        return "This game is a draw";
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