package com.epam.blokhina.factory.parsers.impl;

import com.epam.blokhina.factory.parsers.PathKeeper;
import com.epam.blokhina.game.City;
import org.apache.poi.util.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Before;
import org.powermock.api.mockito.PowerMockito;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * Created by Yevheniia_Blokhina on 5/19/2015.
 */
public class JsonParserTest {

    private static final String FILE_NAME = "D:\\IdeaProjects\\Cities\\src\\test\\resources\\cities.json";
    private static final String ELEMENT = "Алексеевка";

    private JsonParser jsonParser;

    @BeforeTest
    public void setUp() throws Exception {
        jsonParser = new JsonParser();
    }

    @Test
    public void testParse() throws Exception {

        FileReader fr = new FileReader(FILE_NAME);
        PowerMockito.whenNew(FileReader.class).withArguments(anyString()).thenReturn(fr);
        Map<City, Boolean> cities;
        cities = jsonParser.parseDocument();
        City city = new City(ELEMENT);
        Assert.assertTrue(cities.containsKey(city));

    }
}

