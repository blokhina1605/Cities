package com.epam.blokhina.players;

import com.epam.blokhina.factory.parsers.impl.JsonParser;
import com.epam.blokhina.game.City;
import org.junit.Before;
import org.powermock.api.mockito.PowerMockito;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by Yevheniia_Blokhina on 5/19/2015.
 */
public class UserTest {
    final static String PREVIOUS_WORD = "A";

    String[] citiesArr = {"Алексеевка", "Апе", "Ельники", "Ильичевск", "Киев"};
    User user;
    Scanner sc;
    Player player;

    @BeforeTest
    public void setUp() throws Exception {
        user = new User();
        sc = mock(Scanner.class);
        player = mock(Player.class);
    }

    @Test(groups = "positive")
    public void sayCityTest() throws Exception {
       when(Player.getPrevCity()).thenReturn(new City(PREVIOUS_WORD));
        when(sc.next()).thenReturn(citiesArr[0]);
        String city = user.sayCity();
        Assert.assertEquals(city, citiesArr[0]);
    }

    @Test(groups = "negative")
    public void sayCityTestNegative() throws Exception {
        when(Player.getPrevCity()).thenReturn(new City(PREVIOUS_WORD));
        when(sc.next()).thenReturn(citiesArr[2]);
        String city = user.sayCity();
        Assert.assertEquals(city, citiesArr[2]);
    }

}
