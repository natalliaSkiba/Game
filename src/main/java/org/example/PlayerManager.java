package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PlayerManager {
    private List<Player> allPlayers;
    static PlayerManager pm = null;

    public  static PlayerManager getInstance(){
        if (pm == null)
            pm = new PlayerManager();
        return pm;
    }

    private  PlayerManager() {

        allPlayers = new ArrayList<Player>();
    }


    public boolean addPlayer(Player player) {
        for (Player player1 : allPlayers) {
            if (player.getPlayerId().equals(player1.getPlayerId()))
                return false;
        }
        if (assignLeague(player))
            allPlayers.add(player);
        return true;
    }

    public boolean assignLeague(Player player) {
        boolean res = true;
        if (player.getAge() >= 15 && player.getAge() <= 20)
            player.setLeague(League.SECOND);
        else if (player.getAge() >= 21 && player.getAge() <= 30)
            player.setLeague(League.FIRST);
        else if (player.getAge() >= 31 && player.getAge() <= 100)
            player.setLeague(League.PRIME);
        else res = false;
        return res;

    }

    public List<Player> getPlayersByLeague(League league){
        List<Player> playerList = new LinkedList<>();
        for (Player player : allPlayers){
            if (player.getLeague().equals(league))
                playerList.add(player);
        }
        return playerList;
    }





//    List<Player> timeSecond;
//    List<Player> timePrime;
//    List<Player> getTimePrime;
//
//    public static List<Player> generateTimeSecond() {
//     List <Player> timeSecond= new ArrayList<>();
//    for (Player player: Generator.makePlayer(10,16)) {
//            timeSecond.add(player);
//        }
//       return List.copyOf(timeSecond);
//
//    }
//    public static List<Player> generateFirst() {
//        List <Player> timeFirst= new ArrayList<>();
//        for (Player player: Generator.makePlayer(17,31)) {
//            timeFirst.add(player);
//        }
//        return List.copyOf(timeFirst);
//
//    }
//    public static List<Player> generatePrime() {
//        List <Player> timePrime= new ArrayList<>();
//        for (Player player: Generator.makePlayer(31,100)) {
//            timePrime.add(player);
//        }
//        return List.copyOf(timePrime);
//
//    }

}
