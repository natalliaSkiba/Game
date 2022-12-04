package org.example;

import java.util.*;

public class Game {

    public static void printPlayers(List<Player> players) {

        for (Player player : players) {


            System.out.println(String.format
                    ("Player name: %s,  year: %d , score: %d , league %s",
                            player.getName(), player.getAge(), player.getScore(), player.getLeague()));

        }

    }

    // вернуть список трех игроков
    public List<Player> makeGame(List<Player> players) {

        for (int i = 0; i < players.size() - 1; i++) {
            Player p1 = players.get(i);
            for (int j = i + 1; j < players.size(); j++) {
                Player p2 = players.get(j);
                resultGame(p1, p2);
            }
        }
        Collections.sort(players, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o2.getScore() - o1.getScore();
            }
        });
       printPlayers(players);
        System.out.println(" " + players.size());
        System.out.println("Leaders ++++++++++++++++++++++++++++++");
         printPlayers(getLeaders(players));
       System.out.println("__________________________________________");
//        printPlayers(getLosers(players));
        return players;

//        System.out.println("Leaders");
//        List<Player> playersLeaders = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            changeLeaguePlus(players.get(i));
//            playersLeaders.add(players.get(i));
//        }
//        printPlayers(playersLeaders);
//
//        System.out.println("Losers");
//        List<Player> playersLosers = new ArrayList<>();
//        int l =  players.size() + 3;
//        System.out.println(l + " " + players.size());
//        for (int i = players.size(); i < players.size() - 3; i--) {
//            changeLeagueMinus(players.get(i));
//            playersLosers.add(players.get(i));
//        }
//        printPlayers(playersLosers);
//
//        System.out.println("newLeague");
//        printPlayers(players);

    }


    public void changeLeaguePlus(Player player) {
           if (player.getLeague().equals(League.SECOND)){
            player.setLeague(League.FIRST);
        player.setScore(0);}

        else if (player.getLeague().equals(League.FIRST)){
            player.setLeague(League.PRIME);
        player.setScore(0);}

    }

//    public void changeLeagueMinus(List<Player> player) {
//
//        if (player.().equals(League.PRIME))
//            player.setLeague(League.FIRST);
//
//        else if (player.getLeague().equals(League.FIRST))
//            player.setLeague(League.SECOND);
//    }


    public List<Player> getLeaders(List<Player> players) {
        List<Player> playersLeaders = new ArrayList<>();
        for (int i = 0; i < 3; i++) {

            playersLeaders.add(players.get(i));
            changeLeaguePlus(players.get(i));
        }
        return playersLeaders;
    }
//    public List<Player> getLosers(List<Player> players) {
//        List<Player> playersLosers = new ArrayList<>();
//        int j = 10;
//        int a = j - 3 ;
//        System.out.println(j + " " + a);
//        for (int i = a; i <= j; i++) {
////
//           playersLosers.add(players.get(i));
//////            changeLeaguePlus(players.get(i));
//        }
//        return playersLosers;
//    }

    public void resultGame(Player p1, Player p2) {
        if (Math.random() > 0.5)
            p2.addScore(1);
        else p1.addScore(1);

    }
}
