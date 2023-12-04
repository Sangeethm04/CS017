import java.util.Comparator;

/**
 * ComparatorByLatitude class
 */
public class ComparatorByLatitude implements Comparator<City> {
    /**
     * compare method to compare two cities by latitude from extending Comparator
     * @param a city a
     * @param b city b
     * @return int comparison
     */
    public int compare(City a, City b) {
        Double alat = a.getLatitude();
        Double blat = b.getLatitude();
        return alat.compareTo(blat);
    }
}
