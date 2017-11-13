package com.senla.lesson4.task1.comparators;

import com.senla.lesson4.task1.entities.Capability;

import java.util.Comparator;

public class CapabilityComparator {
    private Comparator<Capability> capabilityByPriceComparator = new Comparator<Capability>() {
        @Override
        public int compare(Capability capability1, Capability capability2) {
            if (capability1 != null && capability2 != null)
                return capability1.getPrice().compareTo(capability2.getPrice());
            else return 0;
        }
    };

    public Comparator<Capability> getCapabilityByPriceComparator() {
        return capabilityByPriceComparator;
    }
}