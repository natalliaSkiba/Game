package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Generator.makePlayers(League.FIRST);
        Generator.makePlayers(League.SECOND);
        Generator.makePlayers(League.PRIME);

        Map<League, List<Player> >playerMap = new HashMap<>();

        for (int i = 1; i <= 2; i++) {
            System.out.println("Game " + i);

                for (League league: League.values()){
                    List<Player> players =  PlayerManager.getInstance().getPlayersByLeague(league);
                    System.out.println(league);
                    game.makeGame(players);
                    playerMap.put(league,players);
                }
      }
        System.out.println("*******" + playerMap);
        game.movePlayerBetweenLeague(playerMap);
    }
}
