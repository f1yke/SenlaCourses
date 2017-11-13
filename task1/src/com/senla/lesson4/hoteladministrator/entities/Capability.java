package com.senla.lesson4.hoteladministrator.entities;

public class Capability extends Entity {
    private String name;
    private Double price;
    private static int lastId = 0;

    public Capability() {
        setId(lastId);
        lastId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getId()).append(" ").append(getName()).append(" ").append(getPrice());
        return sb.toString();
    }
}