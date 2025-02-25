package org.example;

import org.example.crossroad.Crossroad;
import org.example.crossroad.RegulatedCrossroad;
import org.example.crossroad.UnregulatedCrossroad;
import org.example.locality.City;
import org.example.locality.Locality;
import org.example.locality.LocalityPopulationComparator;
import org.example.locality.Village;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Locality[] localities = {
                getFilledLocality(new City(), "Wall Street", "Michigan Avenue"),
                getFilledLocality(new City("Springfield", 5000), "Broadway", "Wall Street", "Fifth Avenue", "Broadway"),
                getFilledLocality(new Village("Lakeside", 1200), "Bourbon Street", "Beale Street", "Michigan Avenue", "Fifth Avenue"),
        };

        printLocalityGreetings(localities);
        printCrossroadsByStreet(localities, 0, "Broadway");
        printMinMaxPopulation(localities);
        printCopySortedLocalitiesByPopulation(localities);
    }

    private static Locality getFilledLocality(Locality locality, String... streets) {
        boolean regulated = true;

        for (int i = 0; i < streets.length - 1; i += 2) {
            if (regulated) {
                locality.addCrossroad(new RegulatedCrossroad(streets[i], streets[i + 1]));
            } else {
                locality.addCrossroad(new UnregulatedCrossroad(streets[i], streets[i + 1]));
            }
            regulated = !regulated;
        }
        return locality;
    }

    private static void printLocalityGreetings(Locality[] localities) {
        System.out.println("Localities greetings:");

        for (Locality locality : localities) {
            System.out.println(locality.greetings());
        }
    }

    private static void printCrossroadsByStreet(Locality[] localities, int localityIdx, String streetName) {
        Locality locality = localities[localityIdx];
        System.out.println("\nLocality crossroads by " + streetName + ":");

        for (Crossroad crossroad : locality.getCrossroads()) {
            if (crossroad.isContainsStreetName(streetName)) {
                System.out.println(crossroad.getType() + " crossroad with " +
                        crossroad.getFirstStreet().getName() + " and " + crossroad.getSecondStreet().getName());
            }
        }
    }

    private static void printMinMaxPopulation(Locality[] localities) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (Locality locality : localities) {
            max = Math.max(locality.getPopulation(), max);
            min = Math.min(locality.getPopulation(), min);
        }

        System.out.println("\nMax population in localities is: " + max);
        System.out.println("\nMin population in localities is: " + min);
    }

    private static void printCopySortedLocalitiesByPopulation(Locality[] localities) {
        System.out.println("\nUnsorted copy localities: ");
        Locality[] copyLocalities = localities.clone();
        System.out.println(Arrays.toString(copyLocalities));

        System.out.println("\nSorted copy localities: ");
        Arrays.sort(copyLocalities, new LocalityPopulationComparator());
        System.out.println(Arrays.toString(copyLocalities));
    }
}