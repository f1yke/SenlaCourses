package com.senla.hotel.entities;

import java.io.Serializable;

public abstract class Entity implements Serializable {
    private Integer id;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}