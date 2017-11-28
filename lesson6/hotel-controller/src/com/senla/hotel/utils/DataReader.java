package com.senla.hotel.utils;

import com.senla.hotel.entities.Entity;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private Logger logger = Logger.getLogger(DataReader.class);

    public List<? extends Entity> readObjects(String path) {
        List<? extends Entity> entities = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return entities = (List<? extends Entity>) ois.readObject();
        } catch (Exception e) {
            logger.error(e);
        }
        return entities;
    }
}