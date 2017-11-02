package com.senla.lesson4.task1.services;

import com.senla.lesson4.task1.entities.Capability;
import com.senla.lesson4.task1.entities.Entity;
import com.senla.lesson4.task1.repositories.CapabilityRepository;
import com.senla.lesson4.task1.utils.ArrayWorker;
import com.senla.lesson4.task1.utils.Checker;

import java.util.Arrays;

public class CapabilityService {
    private CapabilityRepository capabilityRepository;

    public CapabilityService() {
        capabilityRepository = new CapabilityRepository();
    }

    public Capability[] getAllCapabilities() {
        return capabilityRepository.getCapabilities();
    }

    public Capability getClient(int id) {
        return capabilityRepository.getCapabilityById(id);
    }

    public void changePrice(int id, int price) {
        capabilityRepository.getCapabilityById(id).setPrice(price);
    }

    public int countCapabilities() {
        return capabilityRepository.getCapabilities().length;
    }

    public void addCapability(Capability capability) {
        if (!Checker.checkLength(capabilityRepository.getCapabilities()))
            capabilityRepository.setCapabilities(castEntitiesArray(ArrayWorker.resize(capabilityRepository.getCapabilities())));
        capabilityRepository.addCapability(capability);
    }

    private Capability[] castEntitiesArray(Entity[] entities) {
        Capability[] capabilityArray = Arrays.copyOf(entities, entities.length, Capability[].class);
        return capabilityArray;
    }
}