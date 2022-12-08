package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        Generator.makePlayers(League.FIRST);
        Generator.makePlayers(League.SECOND);
        Generator.makePlayers(League.PRIME);
        List<Player> playersSecond = new ArrayList<>();
        List<Player> playersFirst = new ArrayList<>();
        List<Player> playersPrime = new ArrayList<>();


        for (int i = 1; i <= 5; i++) {
            System.out.println("Game " + i);
            System.out.println("League.SECOND");
            playersSecond = game.makeGame(PlayerManager.getInstance().getPlayersByLeague(League.SECOND));
            System.out.println("League.FIRST");
            playersFirst = game.makeGame(PlayerManager.getInstance().getPlayersByLeague(League.FIRST));
            System.out.println("League.PRIME");
            playersPrime = game.makeGame(PlayerManager.getInstance().getPlayersByLeague(League.PRIME));


            game.getLeaders(playersSecond);
            game.getLeaders(playersFirst);
            game.getLeaders(playersPrime);

            game.getLosers(playersSecond);
            game.getLosers(playersFirst);
            game.getLosers(playersPrime);

            System.out.println("----------------------------");
        }
        System.out.println("\n Change league UP  \n");
        game.printPlayers(game.getLeaders(playersPrime));
        System.out.println(" \n Change league DOWN  \n");
        game.printPlayers(game.getLosers(playersPrime));

        System.out.println("Sort all players after games \n" );
        PlayerManager.getInstance().getAllPlayersSortByScore(playersSecond);
        PlayerManager.getInstance().getAllPlayersSortByScore(playersFirst);
        game.printPlayers(PlayerManager.getInstance().getAllPlayersSortByScore(playersPrime));

    }
}
