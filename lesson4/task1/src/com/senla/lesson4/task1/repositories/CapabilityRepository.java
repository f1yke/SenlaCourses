package com.senla.lesson4.task1.repositories;

import com.danco.training.TextFileWorker;
import com.senla.lesson4.task1.comparators.CapabilityComparator;
import com.senla.lesson4.task1.entities.Capability;
import com.senla.lesson4.task1.utils.Checker;
import com.senla.lesson4.task1.utils.TextWorker;

import java.util.Arrays;

public class CapabilityRepository {
    private Capability[] capabilities;

    public CapabilityRepository(String filePath) {
        capabilities = new TextWorker().getCapabilities(new TextFileWorker(filePath).readFromFile());
    }

    public Capability[] getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Capability[] capabilities) {
        this.capabilities = capabilities;
    }

    public Capability getCapabilityById(int id) {
        for (int i = 0; i < capabilities.length; i++) {
            if (capabilities[i].getId() == id)
                return capabilities[i];
        }
        return null;
    }

    public void addCapability(Capability capability) {
        capabilities[Checker.getPosition(capabilities)] = capability;
    }
}