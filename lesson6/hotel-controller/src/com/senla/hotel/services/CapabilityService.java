package com.senla.hotel.services;

import com.senla.hotel.entities.Capability;
import com.senla.hotel.repositories.CapabilityRepository;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CapabilityService {
    private CapabilityRepository capabilityRepository;

    public CapabilityService(String path) {
        capabilityRepository = CapabilityRepository.getInstance(path);
    }

    public List<Capability> getAllCapabilities() {
        return capabilityRepository.getCapabilities();
    }

    public boolean changePrice(int id, Double price) {
        Capability capability = capabilityRepository.getCapabilityById(id);
        if (capability != null) {
            capability.setPrice(price);
            return true;
        } else {
            return false;
        }
    }

    public void addCapability(String name, double price) {
        Capability capability = new Capability();
        capability.setName(name);
        capability.setPrice(price);
        capabilityRepository.addCapability(capability);
    }

    public Capability getCapability(int id) {
        return capabilityRepository.getCapabilityById(id);
    }

    public void sortCapabilities(List<Capability> capabilities, Comparator<Capability> comparator) {
        Collections.sort(capabilities, comparator);
    }

    public void sortCapabilities(Comparator<Capability> comparator) {
        Collections.sort(capabilityRepository.getCapabilities(), comparator);
    }

    public void writeToFile(String path) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(capabilityRepository.getCapabilities());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}