package org.example.crossroad;

public abstract class Crossroad {

    private final Street firstStreet;
    private final Street secondStreet;
    private final CrossroadType type;

    public Crossroad(String firstStreetName, String secondStreetName, CrossroadType type) {
        firstStreet = new Street(firstStreetName);
        secondStreet = new Street(secondStreetName);
        this.type = type;
    }

    public boolean isContainsStreetName(String streetName) {
        return null != (firstStreet.name.equals(streetName) ? firstStreet :
                secondStreet.name.equals(streetName) ? secondStreet : null);
    }

    public Street getFirstStreet() {
        return firstStreet;
    }

    public Street getSecondStreet() {
        return secondStreet;
    }

    public CrossroadType getType() {
        return type;
    }

    //inner class. can be static.
    public class Street {

        private final String name;
        private final boolean first;

        public Street(String name) {
            this.name = name;
            this.first = initFirst();
        }

        private boolean initFirst() {

            //local class
            class SequenceSetter {

                boolean isFirstStreet() {
                    return firstStreet == null;
                }
            }

            return new SequenceSetter().isFirstStreet();
        }

        public String getName() {
            return name;
        }

        public boolean isFirst() {
            return first;
        }
    }
}
