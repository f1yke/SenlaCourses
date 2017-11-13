package com.senla.lesson4.hoteladministrator.services;

import com.senla.lesson4.hoteladministrator.comparators.CapabilityComparator;
import com.senla.lesson4.hoteladministrator.entities.Capability;
import com.senla.lesson4.hoteladministrator.repositories.CapabilityRepository;
import com.senla.lesson4.hoteladministrator.utils.TextWorker;

import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CapabilityService {
    private CapabilityRepository capabilityRepository;

    public CapabilityService() throws ParseException {
        capabilityRepository = new CapabilityRepository();
    }

    public List<Capability> getAllCapabilities() {
        return capabilityRepository.getCapabilities();
    }

    public Capability getClient(int id) {
        return capabilityRepository.getCapabilityById(id);
    }

    public void changePrice(int id, Double price) {
        capabilityRepository.getCapabilityById(id).setPrice(price);
    }

    public int countCapabilities() {
        return capabilityRepository.getCapabilities().size();
    }

    public void addCapability(Capability capability) {
        capabilityRepository.addCapability(capability);
    }

    public Capability getCapability(int id) {
        return capabilityRepository.getCapabilityById(id);
    }

    public void sortCapabilitiesByPrice(List<Capability> capabilities) {
        Collections.sort(capabilities, new CapabilityComparator().getCapabilityByPriceComparator());
    }

    public void sortCapabilities(List<Capability> capabilities, Comparator<Capability> comparator) {
        Collections.sort(capabilities, comparator);
    }

    public void sortCapabilities(Comparator<Capability> comparator) {
        Collections.sort(capabilityRepository.getCapabilities(), comparator);
    }

    public void writeToFile() {
        TextWorker worker = new TextWorker();
        worker.writeToFile(getAllCapabilities(), "D:\\in_capabilities.txt");
    }
}