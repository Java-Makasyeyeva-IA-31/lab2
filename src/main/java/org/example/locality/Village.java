package org.example.locality;

import static org.example.locality.LocalityType.VILLAGE;

public class Village extends Locality {

    private static int nameDefaultCount = 0;

    public Village() {
        super("Undefined_village_" + ++nameDefaultCount, VILLAGE, 100);
    }
    public Village(String name, int population) {
        super(name, VILLAGE, population);
    }
}
