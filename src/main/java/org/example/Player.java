package org.example;

import com.github.javafaker.Name;

import java.util.UUID;

public class Player {
    private String name;
    private UUID playerId;
    private int age;
    League league;
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

    public UUID getPlayerId() {
        return playerId;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public League getLeague() {
        return league;
    }

    public  int getScore(){
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
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
