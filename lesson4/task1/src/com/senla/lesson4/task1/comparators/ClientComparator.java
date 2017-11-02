package com.senla.lesson4.task1.comparators;

import com.senla.lesson4.task1.entities.Client;
import java.util.Comparator;

public class ClientComparator {
    private Comparator<Client> nameComparator = new Comparator<Client>() {
        @Override
        public int compare(Client client1, Client client2) {
            return client1.getName().compareTo(client2.getName());
        }
    };

    public Comparator<Client> getNameComparator() {
        return nameComparator;
    }
}