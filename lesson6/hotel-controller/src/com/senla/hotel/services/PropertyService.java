package com.senla.hotel.services;

import com.senla.hotel.repositories.PropertyRepository;

import java.io.*;
import java.util.Properties;

public class PropertyService {

    private PropertyRepository propertyRepository;

    public PropertyService() {
        propertyRepository = PropertyRepository.getInstance();
    }

    public void readProperties() {
        FileInputStream fis;
        Properties properties = new Properties();
        try {
            fis = new FileInputStream("config.properties");
            properties.load(fis);
            propertyRepository.setProperty("roomPath", properties.getProperty("roomsPath"));
            propertyRepository.setProperty("clientPath", properties.getProperty("clientPath"));
            propertyRepository.setProperty("capabilityPath", properties.getProperty("capabilityPath"));
            propertyRepository.setProperty("historyPath", properties.getProperty("historyPath"));
            propertyRepository.setProperty("isChangeStatus", properties.getProperty("isChangeStatus"));
            propertyRepository.setProperty("countEntry", properties.getProperty("countEntry"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getProperty(String key) {
        return propertyRepository.getProperty(key);
    }
}
