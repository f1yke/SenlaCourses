package com.senla.lesson4.task1.entities;

import com.senla.lesson4.task1.utils.ArrayWorker;
import com.senla.lesson4.task1.utils.Checker;

public class Client extends Entity {
    private String name;
    private Room room;
    private Capability[] capabilities;

    public Client() {
        capabilities = new Capability[10];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(" ").append(getName());
        if (room != null) sb.append(" ").append(room.getId());
        return sb.toString();
    }


    public Capability[] getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(Capability[] capabilities) {
        this.capabilities = capabilities;
    }
}