package com.epam.blokhina.players;

import com.epam.blokhina.game.City;
import org.testng.Assert;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;

/**
 * Created by Yevheniia_Blokhina on 5/19/2015.
 */
public class CompTest {

    final static String NEXT_CITY = "uyar";
  //
    final static String WRONG_CITY = "Chuansha";


    Comp mockedComp;
    Comp comp2;
    City city;
    City checkedCity;


    @BeforeTest
    public void setUp() throws Exception {
        mockedComp = mock(Comp.class);
        comp2 = new Comp();
        city = mock(City.class);
    }

    @Test(groups = "positive")
    public void testSayCity() throws Exception {
        // when(mockedComp.checkCity(anyObject())).thenReturn(true);
        String sayCity = comp2.sayCity();
        Assert.assertEquals(sayCity, NEXT_CITY);
    }

    @Test(groups = "positive")
    public void testCheckCity() {
        checkedCity = new City(NEXT_CITY);
        Assert.assertTrue(comp2.checkCity(checkedCity));
    }

    @Test
    public void testCheckCalledCity() {
        checkedCity = new City(WRONG_CITY);
        Assert.assertFalse(comp2.checkCity(checkedCity));
    }
}
