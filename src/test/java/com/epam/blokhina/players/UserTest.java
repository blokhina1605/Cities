package com.epam.blokhina.players;

import com.epam.blokhina.factory.parsers.impl.JsonParser;
import com.epam.blokhina.game.City;
import org.junit.Before;
import org.powermock.api.mockito.PowerMockito;
import org.testng.Assert;
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

    String[] citiesArr = {"алексеевка", "авдеевка", "алушта", "алупка", "апе", "ельники"};
    User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
//        cities.put(new City("авдеевка"), false);
//        cities.put(new City("алексеевка"), false);
//        cities.put(new City("алушта"), false);
//        cities.put(new City("алупка"), false);
//        cities.put(new City("апе"), false);
    }

    @Test
    public void sayCity() throws Exception {
//
//        Scanner sc = mock(Scanner.class);
//        when(sc.next()).thenReturn(citiesArr[0]);
//        user.sayCity();
//
//        PowerMockito.whenNew(FileReader.class).withArguments(anyString()).thenReturn(fr);
//        Map<City, Boolean> cities;
//        cities = jsonParser.parseDocument();
//        Assert.assertEquals(cities.get(0), FIRST_ELEMENT);
    }
}
