package com.epam.blokhina.factory.parsers.impl;

import com.epam.blokhina.game.City;
import com.epam.blokhina.factory.parsers.InterfaceParser;
import com.epam.blokhina.factory.parsers.ConnectorDb;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yevheniia_Blokhina on 5/15/2015.
 */
public class SqlParser implements InterfaceParser {
    private static final String SQL_QUERY = "SELECT `Name` FROM `city`";
    private static final Logger LOGGER = Logger.getLogger(SqlParser.class);

    public Map<City, Boolean> parseDocument() {
        Map<City, Boolean> cities = new HashMap<>();
        try (Connection cn = ConnectorDb.getConnection()) {
            LOGGER.info("Connection to database passed successfully");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL_QUERY);
            while (rs.next()) {
                City city = new City(rs.getString("Name"));
                cities.put(city, false);
            }
        } catch (SQLException e) {
            LOGGER.error("SQL Exeption (request or table failed):" + e);
        }
        return cities;
    }

}


