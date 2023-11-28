public class City implements Comparable<City> {
    private String name;
    private String state;
    private double latitude;
    private double longitude;

    public City(String name, String state, double latitude, double longitude) {
        this.name = name;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String toString() {
        return "[" + name + " " + state + " " + latitude + " " + longitude + "]";
    }

    public boolean equals(Object o) {
        if(this.equals(o)) {
            return true;
        }
        return false;
    }

    public int compareTo(City c) {
        if(this.getName().compareTo(c.getName()) > 1) {
            return 1;
        } else if(this.getName().compareTo(c.getName()) < 1) {
            return -1;
        } else {
            return 0;
        }
    }
}
