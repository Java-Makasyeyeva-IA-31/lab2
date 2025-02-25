package org.example.locality;

import static org.example.locality.LocalityType.CITY;

public class City extends Locality {

    private static int nameDefaultCount = 0;

    public City() {
        super("Undefined_city_" + ++nameDefaultCount, CITY, 1000);
    }

    public City(String name, int population) {
        super(name, CITY, population);
    }

    @Override
    public String greetings() {
        return super.greetings() + " People!!!";
    }
}
