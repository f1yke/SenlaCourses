package com.senla.hotel.comparators.clients;

import com.senla.hotel.entities.Client;

import java.util.Comparator;

public class NameComparator implements Comparator<Client> {
    @Override
    public int compare(Client c1, Client c2) {
        if (c1 != null && c2 != null) {
            return c1.getName().compareTo(c2.getName());
        } else if (c1 != null && c2 == null) {
            return 1;
        } else {
            return -1;
        }
    }
}