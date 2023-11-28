import java.util.Comparator;

public class ComparatorByLatitude implements Comparator<City> {
    public int compare(City a, City b) {
        Double alat = a.getLatitude();
        Double blat = b.getLatitude();
        return alat.compareTo(blat);
    }
}
