package com.epam.blokhina.players;

import com.epam.blokhina.game.City;
import com.epam.blokhina.factory.ParseFactory;
import com.epam.blokhina.factory.parsers.InterfaceParser;
import org.apache.log4j.Logger;

import java.util.Map;


/**
 * Created by Yevheniia_Blokhina on 5/14/2015.
 */
public abstract class Player {
    

    private String name;
    private int score = 0;

    protected static City prevCity = new City("Guangzhou");

    static InterfaceParser parser = ParseFactory.createPowerParser();
    public static Map<City, Boolean> cities = parser.parseDocument();

    public Player(String name) {
        this.name = name;
    }

    protected Player() {
    }

    public abstract String sayCity();

    public void deleteCity(City city) {
        cities.put(city, true);
    }

    void setGameSettings(City city) {
        setPrevCity(city);
        this.setScore();
        deleteCity(city);
    }

    protected abstract boolean checkCity(City city);

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    private void setScore() {
        int addScore = getPrevCity().getName().length() > 5 && getPrevCity().getName().length() < 10 ? 2 : 3;
        score += addScore;
    }

    public static City getPrevCity() {
        return prevCity;
    }

    public static void setPrevCity(City prevCity) {
        Player.prevCity = prevCity;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
