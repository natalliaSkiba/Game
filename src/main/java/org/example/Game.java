package org.example;

import java.util.*;

public class Game {
    List<Player> leadersList = new ArrayList<>();
    List<Player> loserList = new ArrayList<>();


    public void printPlayers(List<Player> players) {
        for (Player player : players) {
            System.out.println(String.format
                    ("Player name: %s,  year: %d , score: %d , league %s",
                            player.getName(), player.getAge(), player.getScore(), player.getLeague()));

        }
    }

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

        return players;

    }



    public void changeLeaguePlus(Player player) {
        if (player.getLeague().equals(League.SECOND)) {
            player.setLeague(League.FIRST);
        } else {
            if (player.getLeague().equals(League.FIRST)) {
                player.setLeague(League.PRIME);
            }
        }
    }


    public void changeLeagueMinus(Player player) {

        if (player.getLeague().equals(League.PRIME))
            player.setLeague(League.FIRST);

        else if (player.getLeague().equals(League.FIRST))
            player.setLeague(League.SECOND);

    }


    public List<Player> getLeaders(List<Player> players) {

        for (int i = 0; i < 3; i++) {
            leadersList.add(players.get(i));
            changeLeaguePlus(players.get(i));
        }

        return leadersList;
    }

    public List<Player> getLosers(List<Player> players) {

        int j = players.size() - 3;
        int k = players.size() ;
        for (int i = j; i < k; i++) {
            loserList.add(players.get(i));
            changeLeagueMinus(players.get(i));
        }
        return loserList;
    }

    public void resultGame(Player p1, Player p2) {
        if (Math.random() > 0.5)
            p2.addScore(1);
        else p1.addScore(1);

    }
    public void movePlayerBetweenLeague(Map<League,List<Player>> map){
    List <Player> leaderList = new LinkedList(map.values());
    Set<Map.Entry<League,List<Player>>> player = map.entrySet();
      //  System.out.println("set" +player);


//        List <Player> loserList = new LinkedList(map.values());
//        System.out.println("sort -----" + leaderList);
        Iterator<Map.Entry<League,List<Player>>> itr = map.entrySet().iterator();


    }
}
