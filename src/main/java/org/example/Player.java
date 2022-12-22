package org.example;

import com.github.javafaker.Name;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

public class Player {
    @Getter
    private String name;
    private UUID playerId;
    private int age;
    private League league;
    private int score = 0;

    public Player(UUID playerId, String name, int age, League league) {
        this.playerId = playerId;
        this.name = name;
        this.age = age;
        this.league = league;
    }

    public Player(UUID playerId, String name, int age) {
        this.playerId = playerId;
        this.name = name;
        this.age = age;
    }



    public void setLeague(League league) {
        this.league = league;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", league=" + league +
                ", score=" + score +
                '}' + "\n";
    }

    public void addScore(int d){
        score = score + d;
    }
}
