package com.epam.blokhina.factory;

import org.apache.log4j.Logger;
import com.epam.blokhina.factory.parsers.InterfaceParser;
import com.epam.blokhina.factory.parsers.PathKeeper;
import com.epam.blokhina.factory.parsers.impl.*;
import com.sun.org.apache.xml.internal.utils.WrongParserException;

import java.util.ResourceBundle;

/**
 * Created by Yevheniia_Blokhina on 5/15/2015.
 */
public class ParseFactory {
    private static final Logger LOGGER = Logger.getLogger(ParseFactory.class);
    public static InterfaceParser createPowerParser() {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(PathKeeper.propertiesFile);
        String type = resourceBundle.getString(PathKeeper.parserChoice);
        switch (type) {
            case "txt":
                LOGGER.info("Txt Parser returned");
                return new TxtParser();
            case "xml":
                LOGGER.info("Txt Parser returned");
                return new JsonParser();
            case "json":
                LOGGER.info("Txt Parser returned");
                return new XmlParser();
            case "xls":
                LOGGER.info("Txt Parser returned");
                return new XlsParser();
            case "jdbc":
                LOGGER.info("Txt Parser returned");
                return new SqlParser();
            default:
                LOGGER.error("ParseFactory: Parser not found.");
                throw new WrongParserException("Parser not found");
        }
    }
}
