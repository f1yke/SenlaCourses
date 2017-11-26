package utils;

import entities.Entity;

import java.util.List;

public class Printer {
    public static void printArray(List<? extends Entity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) != null) {
                System.out.println((i + 1) + ". " + entities.get(i).toString());
            }
        }
        System.out.println();
    }
}