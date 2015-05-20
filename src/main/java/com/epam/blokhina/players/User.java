package com.epam.blokhina.players;

import com.epam.blokhina.game.City;
import com.epam.blokhina.game.Game;

import java.util.Scanner;

/**
 * Created by Yevheniia_Blokhina on 5/14/2015.
 */
public class User extends Player {

    private City city = null;

    public User(String name) {
        super(name);
    }

    public User() {
    }

    @Override
    public String sayCity() {
        boolean flag = false;
        Scanner sc = new Scanner(System.in);
        while (!flag) {
            String cityStr = sc.next().toLowerCase();
            if (cityStr.equals("выход")) new Game().endGame();
            cityStr.replaceAll("\\w|\\d", "");
            this.city = new City(cityStr);
            flag = checkCity(this.city);
        }
        setGameSettings(city);
        LOGGER.info(getName() + " made the move: " + city.getName());
        return city.getName();
    }


    @Override
    public boolean checkCity(City city) {
        if (cities.containsKey(city)) {
            if (city.getFirstLetter() != prevCity.getLastLetter()) {
                System.out.println("This city does not begin on the last letter of the previous one`s");
                LOGGER.error(getName() + " made the wrong move: " + city.getName());
                return false;
            } else if (cities.get(city)) {
                System.out.println("This city has already called");
                LOGGER.error(getName() + " made the wrong move: " + city.getName());
                return false;
            } else return true;
        } else {
            System.out.println("This city is not in the database");
            LOGGER.error(getName() + " made the wrong move: " + city.getName());
            return false;
        }
    }

    public City getCity() {
        return city;
    }

}
