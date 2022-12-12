package org.example;

import java.util.*;
import java.util.function.BiConsumer;

public class Game {

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

    public void resultGame(Player p1, Player p2) {
        if (Math.random() > 0.5)
            p2.addScore(1);
        else p1.addScore(1);

    }

    public void movePlayerBetweenLeague(Map<League, List<Player>> map) {
        Map<League, List<Player>> leaders = new HashMap<>();
        List<Player> leadersList = new ArrayList<>();
        List<Player> losersList = new ArrayList<>();
        for (Map.Entry<League, List<Player>> player : map.entrySet()) {
            if (player.getKey().equals(League.SECOND))
                for (int i = 0; i < 3; i++) {
                    PlayerManager.getInstance().changeLeague(map.get(League.SECOND).get(i), League.FIRST);
                    leadersList.add(map.get(League.SECOND).get(i));
                    map.get(League.SECOND).get(i).setLeague(League.FIRST);

                }
            if (player.getKey().equals(League.FIRST))
                for (int i = 0; i < 3; i++) {
                    PlayerManager.getInstance().changeLeague(map.get(League.FIRST).get(i), League.PRIME);
                    leadersList.add(map.get(League.FIRST).get(i));
                    map.get(League.FIRST).get(i).setLeague(League.PRIME);
                }

            if (player.getKey().equals(League.FIRST))
                for (int i = map.get(League.FIRST).size() - 3; i < map.get(League.FIRST).size(); i++) {
                    PlayerManager.getInstance().changeLeague(map.get(League.FIRST).get(i), League.SECOND);
                    losersList.add(map.get(League.FIRST).get(i));
                    map.get(League.FIRST).get(i).setLeague(League.SECOND);
                }
            if (player.getKey().equals(League.PRIME))
                for (int i = map.get(League.PRIME).size() - 3; i < map.get(League.PRIME).size(); i++) {
                    PlayerManager.getInstance().changeLeague(map.get(League.PRIME).get(i), League.FIRST);
                    losersList.add(map.get(League.PRIME).get(i));
                    map.get(League.PRIME).get(i).setLeague(League.FIRST);
                }
        }
        System.out.println("______Leaders________");

        printPlayers(leadersList);
        System.out.println("______Losers________");
        printPlayers(losersList);
        System.out.println("________sort leaders by scores ");
        Collections.sort(leadersList, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o2.getScore() - o1.getScore();
            }
        });
        printPlayers(leadersList);
    }
}
