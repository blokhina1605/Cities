package com.epam.blokhina.players;

import com.epam.blokhina.game.City;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yevheniia on 21.05.2015.
 */
public class PlayerTest {

    Player player;
    City city = new City("Fuzhou");

    @BeforeTest
    public void putMap() {
        player = new User();
    }

    @Test
    public void testDeleteCity() {
        player.deleteCity(city);
        Assert.assertTrue(Player.cities.get(city));
    }
}
