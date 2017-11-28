package com.senla.hotel.services;

import com.senla.hotel.repositories.PropertyRepository;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyService {

    private PropertyRepository propertyRepository;
    private Logger logger = Logger.getLogger(PropertyService.class);

    public PropertyService() {
        propertyRepository = PropertyRepository.getInstance();
    }

    public void readProperties() {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("hotel-controller/resources/config.properties")) {
            properties.load(fis);
            propertyRepository.setProperty("roomPath", properties.getProperty("roomsPath"));
            propertyRepository.setProperty("clientPath", properties.getProperty("clientPath"));
            propertyRepository.setProperty("capabilityPath", properties.getProperty("capabilityPath"));
            propertyRepository.setProperty("historyPath", properties.getProperty("historyPath"));
            propertyRepository.setProperty("isChangeStatus", properties.getProperty("isChangeStatus"));
            propertyRepository.setProperty("countEntry", properties.getProperty("countEntry"));
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public Object getProperty(String key) {
        return propertyRepository.getProperty(key);
    }
}
