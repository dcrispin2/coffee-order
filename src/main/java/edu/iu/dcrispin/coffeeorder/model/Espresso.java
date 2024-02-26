package edu.iu.dcrispin.coffeeorder.model;

public class Espresso extends Beverage{
    @Override
    public float cost() {
        return 1.34F;
    }

    @Override
    public String getDescription() {
        return "Espresso";
    }
}
