package com.epam.blokhina.factory.parsers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Yevheniia_Blokhina on 5/15/2015.
 */
public class ConnectorDb {
    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("cities");
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String pass = resource.getString("db.password");
        return DriverManager.getConnection(url, user, pass);
    }

}
