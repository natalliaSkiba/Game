package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class PlayerManager {
    private List<Player> allPlayers;
    static PlayerManager pm = null;
    public List<Player> allPlayersSortByScore = new ArrayList<>();

    public static PlayerManager getInstance() {
        if (pm == null)
            pm = new PlayerManager();
        return pm;
    }

    private PlayerManager() {
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

    public List<Player> getPlayersByLeague(League league) {
        List<Player> playerList = new LinkedList<>();
        for (Player player : allPlayers) {
            if (player.getLeague().equals(league))
                playerList.add(player);
        }
        return playerList;
    }

    public List<Player> getAllPlayersSortByScore(List<Player> player) {
        for (int i = 0; i < player.size() ;i++){
            allPlayersSortByScore.add(player.get(i));}

        allPlayersSortByScore.sort(new ComparePlayers());

        return allPlayersSortByScore;
   }
    public class ComparePlayers implements Comparator<Player> {

        @Override
        public int compare(Player o1, Player o2) {
            return o2.getScore() - o1.getScore();
        }
    }



}





