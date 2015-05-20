package com.epam.blokhina.factory.parsers;

import com.epam.blokhina.game.City;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yevheniia_Blokhina on 5/15/2015.
 */
public interface InterfaceParser {
     Map<City, Boolean> parseDocument();
}

