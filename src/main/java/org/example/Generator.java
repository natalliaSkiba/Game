package org.example;

import com.github.javafaker.Faker;

import java.lang.reflect.Constructor;
import java.util.*;


public class Generator {


    public static void makePlayers(League league) {
        Random rnd = new Random();
        Faker faker = new Faker();
        int max = 25;

        if (league.equals(League.SECOND)) {
            for (int i = 0; i < max; i++)
                PlayerManager.getInstance().addPlayer(new Player(UUID.randomUUID(), faker.name().lastName(), rnd.nextInt(15, 21)));
        }
        if (league.equals(League.PRIME)) {
            for (int i = 0; i < max; i++)
                PlayerManager.getInstance().addPlayer(new Player(UUID.randomUUID(), faker.name().lastName(), rnd.nextInt(21, 31)));
        }
        if (league.equals(League.PRIME)){
            for (int i = 0; i < max; i++)
                PlayerManager.getInstance().addPlayer(new Player(UUID.randomUUID(),faker.name().lastName(), rnd.nextInt(31,100)));}


    }


}
