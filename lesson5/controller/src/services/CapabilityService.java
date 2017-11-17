package services;

import comparators.capabilities.PriceComparator;
import entities.Capability;
import repositories.CapabilityRepository;
import utils.TextWorker;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CapabilityService {
    private CapabilityRepository capabilityRepository;

    public CapabilityService() {
        capabilityRepository = CapabilityRepository.getInstance();
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

    public void writeToFile() throws IOException {
        TextWorker worker = new TextWorker();
        File file = new File("in_capabilities.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        worker.writeToFile(getAllCapabilities(), file.getPath());
    }
}