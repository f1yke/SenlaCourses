package com.senla.lesson4.task1.utils;

import com.senla.lesson4.task1.entities.Entity;

public class Printer {
    public static void printArray(Entity[] entities) {
        for (int i = 0; i < entities.length; i++) {
            if (entities[i] != null) {
                System.out.println(entities[i].toString());
            }
        }
        System.out.println();
    }

    public static void printLine(String line) {
        System.out.println(line);
        System.out.println();
    }
}