import java.util.Comparator;

public class ComparatorByLongitude implements Comparator<City> {
    public int compare(City a, City b) {
        Double alat = a.getLongitude();
        Double blat = b.getLongitude();
        return alat.compareTo(blat);
    }
}
