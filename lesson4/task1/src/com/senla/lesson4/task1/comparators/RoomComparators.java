package com.senla.lesson4.task1.comparators;

import com.senla.lesson4.task1.entities.Room;
import java.util.Comparator;

public class RoomComparators {
    private Comparator<Room> priceComparator = new Comparator<Room>() {
        @Override
        public int compare(Room room1, Room room2) {
            if (room1 != null && room2 != null)
                return room1.getPrice().compareTo(room2.getPrice());
            else return 0;
        }
    };

    private Comparator<Room> capacityComparator = new Comparator<Room>() {
        @Override
        public int compare(Room room1, Room room2) {
            if (room1 != null && room2 != null)
                return room1.getCapacity().compareTo(room2.getCapacity());
            else return 0;
        }
    };

    private Comparator<Room> starsComparator = new Comparator<Room>() {
        @Override
        public int compare(Room room1, Room room2) {
            if (room1 != null && room2 != null)
                return room1.getCountStars().compareTo(room2.getCountStars());
            else return 0;
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