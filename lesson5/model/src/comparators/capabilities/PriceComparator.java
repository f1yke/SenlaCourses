package comparators.capabilities;

import entities.Capability;

import java.util.Comparator;

public class PriceComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability c1, Capability c2) {
        if (c1 != null && c2 != null) {
            return c1.getPrice().compareTo(c2.getPrice());
        } else if (c1 != null && c2 == null) {
            return 1;
        } else {
            return -1;
        }
    }
}