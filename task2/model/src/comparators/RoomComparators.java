package comparators;

import entities.Room;

import java.util.Comparator;

public class RoomComparators {
    private Comparator<Room> priceComparator = (room1, room2) -> {
        if (room1 != null && room2 != null) {
            return room1.getPrice().compareTo(room2.getPrice());
        } else {
            return 0;
        }
    };

    private Comparator<Room> capacityComparator = (room1, room2) -> {
        if (room1 != null && room2 != null) {
            return room1.getCapacity().compareTo(room2.getCapacity());
        } else {
            return 0;
        }
    };

    private Comparator<Room> starsComparator = (room1, room2) -> {
        if (room1 != null && room2 != null) {
            return room1.getCountStars().compareTo(room2.getCountStars());
        } else {
            return 0;
        }
    };

    public Comparator<Room> getPriceComparator() {
        return priceComparator;
    }

    public Comparator<Room> getCapacityComparator() {
        return capacityComparator;
    }

    public Comparator<Room> getStarsComparator() {
        return starsComparator;
    }
}