import java.util.Comparator;

public class ComparatorByArea implements Comparator<Country> {
    public int compare(Country c1, Country c2) {
        if (c1.getArea() > c2.getArea()) {
            return 1;
        } else if (c1.getArea() < c2.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }
}