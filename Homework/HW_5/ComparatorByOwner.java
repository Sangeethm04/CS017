import java.util.Comparator;

public class ComparatorByOwner implements Comparator < BankAccount > {
    public int compare(BankAccount b1, BankAccount b2) {
        return b1.getOwner().compareTo(b2.getOwner());
    }
}