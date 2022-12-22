package org.example;

import com.github.javafaker.Faker;

import java.lang.reflect.Constructor;
import java.util.*;

public class Generator {
    static Random rnd = new Random();
    static Faker faker = new Faker();
    static int max = 25;

    public static void makePlayers(League league) {
        if (league.equals(League.SECOND)) {
            for (int i = 0; i < max; i++)
                PlayerManager.getInstance().addPlayer(new Player(UUID.randomUUID(), faker.name().lastName(), rnd.nextInt(15, 21)));
        }
        if (league.equals(League.PRIME)) {
            for (int i = 0; i < max; i++)
                PlayerManager.getInstance().addPlayer(new Player(UUID.randomUUID(), faker.name().lastName(), rnd.nextInt(21, 31)));
        }
        if (league.equals(League.PRIME)) {
            for (int i = 0; i < max; i++)
                PlayerManager.getInstance().addPlayer(new Player(UUID.randomUUID(), faker.name().lastName(), rnd.nextInt(31, 100)));
        }
    }
}
