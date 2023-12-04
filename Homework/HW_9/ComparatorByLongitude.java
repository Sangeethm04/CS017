import java.util.Comparator;
/**
 * ComparatorByLongitude class
 */
public class ComparatorByLongitude implements Comparator<City> {
    /**
     * compare method to compare two cities by longitude from extending Comparator
     * @param a city a
     * @param b city b
     * @return int comparison
     */
    public int compare(City a, City b) {
        Double alat = a.getLongitude();
        Double blat = b.getLongitude();
        return alat.compareTo(blat);
    }
}
