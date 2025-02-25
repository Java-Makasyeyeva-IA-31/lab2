package org.example.crossroad;

public class UnregulatedCrossroad extends Crossroad {

    public UnregulatedCrossroad(String firstStreetName, String secondStreetName) {
        super(firstStreetName, secondStreetName, CrossroadType.UNREGULATED);
    }
}
