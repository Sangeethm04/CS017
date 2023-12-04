/**
 * City class that has the attributes of a city.
 */
public class City implements Comparable<City> {
    private String name;
    private String state;
    private double latitude;
    private double longitude;

    /**
     * City constructor
     * @param name
     * @param state
     * @param latitude
     * @param longitude
     */
    public City(String name, String state, double latitude, double longitude) {
        this.name = name;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * getName method
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * getState method
     * @return String state
     */
    public String getState() {
        return state;
    }

    /**
     * getLatitude method
     * @return double latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * getLongitude method
     * @return double longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * toString method
     * @return String representation of City
     */
    public String toString() {
        return "[" + name + " " + state + " " + latitude + " " + longitude + "]\n";
    }

    /**
     * equals method
     * @param o object to compare
     * @return boolean if equal
     */
    public boolean equals(Object o) {
        if(this.equals(o)) {
            return true;
        }
        return false;
    }

    /**
     * compareTo method
     * @param c city to compare
     * @return int of compare
     */
    public int compareTo(City c) {
        if(this.getName().compareTo(c.getName()) > 0) {
            return 1;
        } else if(this.getName().compareTo(c.getName()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
