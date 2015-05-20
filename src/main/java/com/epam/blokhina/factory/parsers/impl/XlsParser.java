package com.epam.blokhina.factory.parsers.impl;

import com.epam.blokhina.game.City;
import com.epam.blokhina.factory.parsers.InterfaceParser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import com.epam.blokhina.factory.parsers.PathKeeper;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.util.Map;

/**
 * Created by Yevheniia_Blokhina on 5/15/2015.
 */
public class XlsParser implements InterfaceParser {
    private static final Logger LOGGER = Logger.getLogger(XlsParser.class);
    public Map<City, Boolean> parseDocument() {
        Map<City, Boolean> cities = new HashMap<>();
        HSSFWorkbook workBook;
        try (InputStream in = new FileInputStream(PathKeeper.xlsSource)) {
            workBook = new HSSFWorkbook(in);
            Sheet sheet = workBook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    int cellType = cell.getCellType();
                    if (cellType == Cell.CELL_TYPE_STRING) {
                        cities.put(new City(cell.getStringCellValue()), false);
                    }
                }
            }
            workBook.close();
        } catch (IOException e) {
            LOGGER.error("File not found." + e);
        }
        return cities;
    }
}
