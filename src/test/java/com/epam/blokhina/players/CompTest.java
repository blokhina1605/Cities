package com.epam.blokhina.players;

import com.epam.blokhina.factory.parsers.impl.JsonParser;
import com.epam.blokhina.game.City;
import org.junit.Before;
import org.powermock.api.mockito.PowerMockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.util.Map;

import static org.mockito.Matchers.anyString;

/**
 * Created by Yevheniia_Blokhina on 5/19/2015.
 */
public class CompTest {


//    @Before
//    public void setUp() throws Exception {
//        jsonParser = new JsonParser();
//    }

//    @Test
//    public void testParse() throws Exception {
////        ClassLoader classLoader = getClass().getClassLoader();
////
////        String file = classLoader.getResource(FILE_NAME).getFile();
//        //  FileReader frMock = mock(FileReader.class);
//        FileReader fr = new FileReader(FILE_NAME);
//        PowerMockito.whenNew(FileReader.class).withArguments(anyString()).thenReturn(fr);
//        Map<City, Boolean> cities;
//        cities = jsonParser.parseDocument();
//        Assert.assertEquals(cities.get(0), FIRST_ELEMENT);
//    }
}
