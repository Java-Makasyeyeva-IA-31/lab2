package org.example.locality;

import org.example.crossroad.Crossroad;

import java.util.ArrayList;
import java.util.List;

public abstract class Locality {

    private String name;
    private LocalityType type;
    private int population;

    private final List<Crossroad> crossroads = new ArrayList<>();

    public Locality(String name, LocalityType type, int population) {
        this.name = name;
        this.type = type;
        this.population = population;
    }

    public String greetings() {
        return "Hello from " + name + ".";
    }

    @Override
    public String toString() {
        return "Locality name: " + name + " and population: " + population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalityType getType() {
        return type;
    }

    public void setType(LocalityType type) {
        this.type = type;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void addCrossroad(Crossroad crossroad) {
        crossroads.add(crossroad);
    }

    public List<Crossroad> getCrossroads() {
        return crossroads;
    }
}
