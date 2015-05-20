package com.epam.blokhina.factory.parsers.impl;

import com.epam.blokhina.game.City;
import com.epam.blokhina.factory.parsers.InterfaceParser;
import com.epam.blokhina.factory.parsers.PathKeeper;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yevheniia_Blokhina on 5/15/2015.
 */
public class TxtParser implements InterfaceParser {
    private static final Logger LOGGER = Logger.getLogger(TxtParser.class);

    public Map<City, Boolean> parseDocument() {
        Map<City, Boolean> cities = new HashMap<>();
        File file = new File(PathKeeper.txtSource);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(file)))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                cities.put(new City(line.toLowerCase()), false);
            }
        } catch (IOException e) {
            LOGGER.error("File not found" + e);
        }

        return cities;
    }
}

