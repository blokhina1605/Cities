package com.epam.blokhina.factory.parsers.impl;

import com.epam.blokhina.game.City;
import com.epam.blokhina.factory.parsers.InterfaceParser;
import com.epam.blokhina.factory.parsers.PathKeeper;
import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yevheniia_Blokhina on 5/15/2015.
 */
public class JsonParser implements InterfaceParser {
    private static final Logger LOGGER = Logger.getLogger(JsonParser.class);

    public Map<City, Boolean> parseDocument() {
        Map<City, Boolean> cities = new HashMap<>();
        try (FileReader reader = new FileReader(PathKeeper.jsonSource)) {
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONArray nodes = (JSONArray) jsonObject.get("city");
            for (Object aCityArr : nodes) {
                City city = new City((String) aCityArr);
                cities.put(city, false);
            }
        } catch (IOException | ParseException e) {
            LOGGER.error("File not found" + e);
        }
        return cities;
    }
}

