package org.example.locality;

import java.util.Comparator;

public class LocalityPopulationComparator implements Comparator<Locality> {

    @Override
    public int compare(Locality o1, Locality o2) {
        return o1.getPopulation() - o2.getPopulation();
    }
}
