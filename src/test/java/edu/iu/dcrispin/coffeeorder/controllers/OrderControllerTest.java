package edu.iu.dcrispin.coffeeorder.controllers;

import edu.iu.dcrispin.coffeeorder.repository.OrderRepository;
import edu.iu.dcrispin.coffeeorder.model.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderControllerTest {

    /*
    @BeforeAll
    static void setup() throws IOException {
        Files.deleteIfExists(Paths.get("db.txt"));
    }

    @AfterAll
    static void cleanup() throws IOException {
        Files.delete(Paths.get("db.txt"));
    }
    */

    @Test
    void add() throws Exception {
        OrderRepository ordo = new OrderRepository();
        System.out.println(new OrderData("Dark roast", new ArrayList<>(List.of("Milk"))).beverage());
        System.out.println(ordo.add(new OrderData("Dark roast", new ArrayList<>(List.of("Milk")))).description());

        OrderData d1 = new OrderData("Dark roast", new ArrayList<>(List.of()));
        OrderData d2 = new OrderData("Espresso", new ArrayList<>(List.of()));
        OrderData d3 = new OrderData("House Blend", new ArrayList<>(List.of()));
        OrderData d4 = new OrderData("Decaf", new ArrayList<>(List.of()));

        assertEquals(d1.beverage(), ordo.add(d1).description());
        assertEquals(d2.beverage(), ordo.add(d2).description());
        assertEquals(d3.beverage(), ordo.add(d3).description());
        assertEquals(d4.beverage(), ordo.add(d4).description());

        OrderData d5 = new OrderData("Dark roast", new ArrayList<>(List.of("Milk")));
        OrderData d6 = new OrderData("Espresso", new ArrayList<>(List.of("Milk")));
        OrderData d7 = new OrderData("House Blend", new ArrayList<>(List.of("Milk")));
        OrderData d8 = new OrderData("Decaf", new ArrayList<>(List.of("Milk")));

        OrderData c1 = new OrderData("Dark roast", new ArrayList<>(List.of("Milk", "Soy", "Whip", "Mocha")));
        OrderData c2 = new OrderData("Espresso", new ArrayList<>(List.of("Milk", "Soy", "Whip", "Mocha")));
        OrderData c3 = new OrderData("House Blend", new ArrayList<>(List.of("Milk", "Soy", "Whip", "Mocha")));
        OrderData c4 = new OrderData("Decaf", new ArrayList<>(List.of("Milk", "Soy", "Whip", "Mocha")));

        assertEquals("Dark roast, Milk", ordo.add(d5).description());
        assertEquals("Espresso, Milk", ordo.add(d6).description());
        assertEquals("House Blend, Milk", ordo.add(d7).description());
        assertEquals("Decaf, Milk", ordo.add(d8).description());

        assertEquals("Dark roast, Milk, Soy, Whip, Mocha", ordo.add(c1).description());
        assertEquals("Espresso, Milk, Soy, Whip, Mocha", ordo.add(c2).description());
        assertEquals("House Blend, Milk, Soy, Whip, Mocha", ordo.add(c3).description());
        assertEquals("Decaf, Milk, Soy, Whip, Mocha", ordo.add(c4).description());

        assert(Math.abs(1.99 - ordo.add(d1).cost()) < 0.1);
        assert(Math.abs(2.39 - ordo.add(d5).cost()) < 0.1);
        assert(Math.abs(1.65 + 0.27 + 0.25 + 0.4 + 0.3 - ordo.add(c3).cost()) < 0.1);
        assert(Math.abs(1.28 + 0.27 + 0.25 + 0.4 + 0.3 - ordo.add(c4).cost()) < 0.1);

    }
}