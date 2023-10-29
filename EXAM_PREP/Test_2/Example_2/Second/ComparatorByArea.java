import java.util.Comparator;

public class ComparatorByArea implements Comparator<Country>{
    public int compare(Country a, Country b) {
        Double a1 = a.getArea();
        Double a2 = b.getArea();
        return a1.compareTo(a2);
    }
}
