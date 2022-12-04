package org.example;

import java.util.List;

public class Main {
  //  Office office = Office.getOffice();//
    public static void main(String[] args) {


        Game game= new Game();
        Generator.makePlayers(League.FIRST);
        Generator.makePlayers(League.SECOND);
        Generator.makePlayers(League.PRIME);

//        for (int i = 0; i < 5; i++){
        game.makeGame(PlayerManager.getInstance().getPlayersByLeague(League.SECOND));
        System.out.println();
        game.makeGame(PlayerManager.getInstance().getPlayersByLeague(League.FIRST));
        System.out.println();
        game.makeGame(PlayerManager.getInstance().getPlayersByLeague(League.PRIME));
//        System.out.println("Leaders Second league");
//        game.getLeaders(game.makeGame(PlayerManager.getInstance().getPlayersByLeague(League.SECOND)));
    }
}