package org.example.crossroad;

public class RegulatedCrossroad extends Crossroad {

    public RegulatedCrossroad(String firstStreetName, String secondStreetName) {
        super(firstStreetName, secondStreetName, CrossroadType.REGULATED);
    }
}
