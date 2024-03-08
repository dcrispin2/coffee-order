package edu.iu.dcrispin.coffeeorder.model;

import java.util.List;

public record OrderData(String beverage, List<String> condiments) {
    @Override
    public String beverage() {
        return beverage;
    }

    @Override
    public List<String> condiments() {
        return condiments;
    }

    public OrderData {
    }
}
