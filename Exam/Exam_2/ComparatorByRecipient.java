import java.util.Comparator;

public class ComparatorByRecipient implements Comparator < Message > {
    public int compare(Message c1, Message c2) {
        String rec1 = c1.getRecipient();
        String rec2 = c2.getRecipient();

        return rec1.compareTo(rec2);
    }
}