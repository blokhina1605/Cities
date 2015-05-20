package com.epam.blokhina.players;

import com.epam.blokhina.game.City;
import com.epam.blokhina.game.Game;

/**
 * Created by Yevheniia_Blokhina on 5/14/2015.
 */
public class Comp extends Player {
    private City city = null;

    public Comp() {
    }

    public Comp(String name) {
        super(name);
    }

    public City getCity() {
        return city;
    }

    @Override
    public String sayCity() {
        city = null;
        for (City city1 : cities.keySet()) {
            if (checkCity(city1)) break;
        }
        if (city == null) {
            new Game().endGame();
        }
        setGameSettings(city);
        printCity(city);
        return city.getName();
    }

    @Override
    public boolean checkCity(City city1) {
        if (getPrevCity().getLastLetter() == city1.getFirstLetter() && !cities.get(city1)) {
            city = city1;
            LOGGER.info(getName() + " made the move: " + city.getName());
            return true;
        }
        return false;
    }


    private void printCity(City city) {
        System.out.println(city.getName());
    }

//    @Override
//    public boolean checkCity(City city) {
//        return getPrevCity().getLastLetter() == city.getFirstLetter() && !cities.get(city);
//    }


}
