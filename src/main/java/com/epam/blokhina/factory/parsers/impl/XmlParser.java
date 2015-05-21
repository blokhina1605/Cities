package com.epam.blokhina.factory.parsers.impl;

import com.epam.blokhina.game.City;
import com.epam.blokhina.factory.parsers.InterfaceParser;

import com.epam.blokhina.factory.parsers.PathKeeper;
import org.apache.log4j.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yevheniia_Blokhina on 5/15/2015.
 */
public class XmlParser implements InterfaceParser {
    private static final Logger LOGGER = Logger.getLogger(XmlParser.class);

    public Map<City, Boolean> parseDocument() {
        Map<City, Boolean> cities = new HashMap<>();
        try {
            SAXBuilder builder = new SAXBuilder();
            City city;
            Document document = builder.build(PathKeeper.xmlSource);
            Element rootNode = document.getRootElement();
            List<Element> nodes = rootNode.getChildren("Cities");

            for (Element node : nodes) {
                city = new City(node.getChildText("City"));
                cities.put(city, false);
            }
            return cities;

        } catch (IOException | JDOMException io) {
            LOGGER.error("File not found." + io);

        }
        return null;
    }
}
