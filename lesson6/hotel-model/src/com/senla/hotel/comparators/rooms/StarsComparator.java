package com.senla.hotel.comparators.rooms;

import com.senla.hotel.entities.Room;

import java.util.Comparator;

public class StarsComparator implements Comparator<Room> {
    @Override
    public int compare(Room r1, Room r2) {
        if (r1 != null && r2 != null) {
            return r1.getCountStars().compareTo(r2.getCountStars());
        } else if (r1 != null && r2 == null) {
            return 1;
        } else {
            return -1;
        }
    }
}