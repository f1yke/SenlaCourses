package comparators.rooms;

import entities.Room;

import java.util.Comparator;

public class PriceComparator implements Comparator<Room> {
    @Override
    public int compare(Room r1, Room r2) {
        if (r1 != null && r2 != null) {
            return r1.getPrice().compareTo(r2.getPrice());
        } else if (r1 != null && r2 == null) {
            return 1;
        } else {
            return -1;
        }
    }
}