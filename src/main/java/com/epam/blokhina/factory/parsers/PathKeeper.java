package com.epam.blokhina.factory.parsers;

/**
 * Created by Yevheniia_Blokhina on 5/18/2015.
 */
public interface PathKeeper {


    String propertiesFile = "cities";

    String xmlSource = "src\\main\\resources\\cities.xml";
    String xlsSource = "src\\main\\resources\\cities.xls";
    String txtSource = "src\\main\\resources\\cities.txt";
    String jsonSource = "src\\main\\resources\\cities.json";

    String parserChoice = "factory.parse.choice";

}

