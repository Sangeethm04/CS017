import java.util.Comparator;

public class ComparatorByDate implements Comparator < Message > {
    public int compare(Message c1, Message c2) {
        Date rec1 = c1.getDate();
        Date rec2 = c2.getDate();

        return rec1.compareTo(rec2);
    }
}