package com.senla.lesson4.task1.utils;

import com.senla.lesson4.task1.entities.Entity;

public class ArrayWorker {
    public static Entity[] resize(Entity[] entity) {
        Entity[] newEntity = new Entity[entity.length * 2];
        System.arraycopy(entity, 0, newEntity, 0, entity.length);
        return newEntity;
    }
}
