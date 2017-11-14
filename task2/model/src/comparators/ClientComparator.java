package comparators;

import entities.Client;

import java.util.Comparator;

public class ClientComparator {
    private Comparator<Client> nameComparator = (client1, client2) -> {
        if (client1 != null && client2 != null) {
            return client1.getName().compareTo(client2.getName());
        } else {
            return 0;
        }
    };

    public Comparator<Client> getNameComparator() {
        return nameComparator;
    }
}