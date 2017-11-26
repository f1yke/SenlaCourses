package com.senla.hotel.repositories;

import java.util.HashMap;
import java.util.Map;

public class PropertyRepository {
    private Map<Object, Object> properties;

    private static PropertyRepository propertyRepository;

    public static PropertyRepository getInstance() {
        if (propertyRepository == null) {
            propertyRepository = new PropertyRepository();
        }
        return propertyRepository;
    }

    public PropertyRepository() {
        properties = new HashMap<>();
    }

    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }

    public Map<Object, Object> getProperties() {
        return properties;
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }
}