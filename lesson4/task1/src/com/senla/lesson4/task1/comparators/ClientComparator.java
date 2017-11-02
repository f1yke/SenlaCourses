package com.senla.lesson4.task1.comparators;

import com.senla.lesson4.task1.entities.Client;
import java.util.Comparator;

public class ClientComparator {
    private Comparator<Client> nameComparator = new Comparator<Client>() {
        @Override
        public int compare(Client client1, Client client2) {
            if (client1 != null && client2 != null)
                return client1.getName().compareTo(client2.getName());
            else return 0;
        }
    };

    private Comparator<Client> dateComparator = new Comparator<Client>() {
        @Override
        public int compare(Client client1, Client client2) {
            if (client1 != null && client2 != null)
                return client1.getRoom().getDateEviction().compareTo(client2.getRoom().getDateEviction());
            else return 0;
        }
    };

    public Comparator<Client> getNameComparator() {
        return nameComparator;
    }

    public Comparator<Client> getDateComparator() {
        return dateComparator;
    }
}