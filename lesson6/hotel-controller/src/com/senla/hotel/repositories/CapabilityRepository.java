package com.senla.hotel.repositories;

import com.senla.hotel.entities.Capability;
import com.senla.hotel.utils.DataReader;
import org.apache.log4j.Logger;

import java.util.List;

public class CapabilityRepository {
    private List<Capability> capabilities;
    private Logger logger = Logger.getLogger(CapabilityRepository.class);
    private int lastId;

    private static CapabilityRepository capabilityRepository;

    public static CapabilityRepository getInstance() {
        if (capabilityRepository == null) {
            capabilityRepository = new CapabilityRepository();
        }
        return capabilityRepository;
    }

    private CapabilityRepository() {
        PropertyRepository propertyRepository = PropertyRepository.getInstance();
        capabilities = (List<Capability>) new DataReader().readObjects((String) propertyRepository.getProperty("capabilityPath"));
        lastId = getLastId();
    }

    private Integer getLastId() {
        Integer lastId = -1;
        if (capabilities.size() > 0) {
            lastId = capabilities.get(capabilities.size() - 1).getId();
        }
        return lastId;
    }

    public List<Capability> getCapabilities() {
        return capabilities;
    }

    public Capability getCapabilityById(int id) {
        Capability capability = null;
        for (int i = 0; i < capabilities.size(); i++) {
            if (capabilities.get(i).getId() == id) {
                capability = capabilities.get(i);
                break;
            }
        }
        return capability;
    }

    public void addCapability(Capability capability) {
        lastId++;
        capability.setId(lastId);
        capabilities.add(capability);
    }

    public boolean updateCapability(Capability capability) {
        for (int i = 0; i < capabilities.size(); i++) {
            if (capabilities.get(i).getId() == capability.getId()) {
                capabilities.set(i, capability);
                return true;
            }
        }
        return false;
    }
}