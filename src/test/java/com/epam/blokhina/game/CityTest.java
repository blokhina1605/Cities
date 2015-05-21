package com.epam.blokhina.game;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Yevheniia_Blokhina on 5/19/2015.
 */
public class CityTest {
    City city;

    @Test(groups = "positive")
    public void testGetLastLetter() {
        city = new City("Alalo");
        Assert.assertEquals(city.getLastLetter(), 'o');
    }

    @Test(groups = "positive")
    public void testGetLastLetterWithsign() {
        city = new City("Alaloъ");
        Assert.assertEquals(city.getLastLetter(), 'o');
    }

    @Test(groups = "negstive", expectedExceptions = StringIndexOutOfBoundsException.class)
    public void testGetLastLetterWithNoWord() {
        city = new City("");
        city.getLastLetter();
    }

    @Test(groups = "negative")
    public void testGetLastLetterWithDigits() {
        city = new City("1234");
        Assert.assertEquals(city.getLastLetter(), '4');
    }

    @Test(groups = "negstive", expectedExceptions = StringIndexOutOfBoundsException.class)
    public void testGetLastLetterAmongALot() {
        city = new City("ъ");
        city.getLastLetter();
    }

    @Test(groups = "positive")
    public void testGetFirstLetter() {
        city = new City("Aloha");
        Assert.assertEquals(city.getFirstLetter(), 'a');
    }
    @Test(groups = "negative", expectedExceptions = StringIndexOutOfBoundsException.class)
    public void testGetFirstLetterWithNoWord() {
        city = new City("");
        city.getFirstLetter();
    }

}
