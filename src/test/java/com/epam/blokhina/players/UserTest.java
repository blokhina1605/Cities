package com.epam.blokhina.players;


import com.epam.blokhina.game.City;

import org.apache.log4j.Logger;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.testng.PowerMockTestCase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Yevheniia_Blokhina on 5/19/2015.
 */


public class UserTest extends PowerMockTestCase {
    final static String PREVIOUS_WORD = "guangzhou";
    protected static final Logger LOGGER = Logger.getLogger(User.class);


    Map<City, Boolean> cities = new HashMap<>();
    String[] citiesArr = {"Urdaneta", "Fuzhou", "Beijing", "Baotou"};
    User user;
    Player player;
    City checkedCity;

    @BeforeTest
    public void setUp() throws Exception {
        user = new User();
    }

    @Test(groups = "positive", enabled = true)
    public void checkCityTest() throws Exception {
//        PowerMockito.mockStatic(Player.class);
//        PowerMockito.when(Player.getPrevCity()).thenReturn(new City(PREVIOUS_WORD));
        Player.setPrevCity(new City(PREVIOUS_WORD));
        City city = new City(citiesArr[0]);
        //   String prew = Player.getPrevCity().getName();
        Assert.assertTrue(user.checkCity(city));
    }

//    @Test(groups = "negative", description = "")
//    public void testCheckWrongCity() {
//        checkedCity = new City(NOT_IN_DB_CITY);
//        Assert.assertFalse(user.checkCity(checkedCity));
//    }

}
