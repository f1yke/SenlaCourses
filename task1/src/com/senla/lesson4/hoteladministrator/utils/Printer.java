package com.senla.lesson4.hoteladministrator.utils;

import com.senla.lesson4.hoteladministrator.entities.Entity;

import java.util.List;

public class Printer {
    public static void printArray(List<? extends Entity> entities) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) != null) {
                System.out.println(entities.get(i).toString());
            }
        }
        System.out.println();
    }

    public static void printLine(String line) {
        System.out.println(line);
    }
}