import java.util.Comparator;

public class ComparatorByName implements Comparator<Country>{
    public int compare(Country a, Country b) {
        String a1 = a.getName();
        String a2 = b.getName();
        return a1.compareTo(a2);
    }
}
