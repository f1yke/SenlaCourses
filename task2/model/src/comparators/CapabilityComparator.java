package comparators;

import entities.Capability;

import java.util.Comparator;

public class CapabilityComparator {
    private Comparator<Capability> capabilityByPriceComparator = (capability1, capability2) -> {
        if (capability1 != null && capability2 != null) {
            return capability1.getPrice().compareTo(capability2.getPrice());
        } else {
            return 0;
        }
    };

    public Comparator<Capability> getCapabilityByPriceComparator() {
        return capabilityByPriceComparator;
    }
}