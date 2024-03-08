package edu.iu.dcrispin.coffeeorder.model;

public record Receipt(String description, float cost, int id) {
    @Override
    public String description() {
        return description;
    }

    @Override
    public float cost() {
        return cost;
    }

    @Override
    public int id() {
        return id;
    }
}
