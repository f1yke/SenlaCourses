package com.senla.hotel.utils;

import com.senla.hotel.entities.Entity;
import org.apache.log4j.Logger;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class DataWriter {
    private Logger logger = Logger.getLogger(DataWriter.class);

    public void writeObject(List<? extends Entity> entities, String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(entities);
        } catch (Exception e) {
            logger.error(e);
        }
    }
}