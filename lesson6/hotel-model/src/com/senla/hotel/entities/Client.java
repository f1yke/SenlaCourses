package com.senla.hotel.entities;

import java.util.ArrayList;
import java.util.List;

public class Client extends Entity {
    private String name;
    private Room room;
    private List<Capability> capabilities;

    public Client() {
        capabilities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Capability> getCapabilities() {
        return capabilities;
    }

    public void setCapability(Capability capability) {
        capabilities.add(capability);
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
        if (room != null) {
            sb.append(" ").append(room.getNumber());
        }
        return sb.toString();
    }
}