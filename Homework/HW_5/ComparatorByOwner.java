import java.util.Comparator;
/**
 * ComparatorByOwner class
 */
public class ComparatorByOwner implements Comparator < BankAccount > {
    /**
     * compare method for comparator for owner
     * @param b1
     * @param b2
     * @return int
     */
    public int compare(BankAccount b1, BankAccount b2) {
        return b1.getOwner().compareTo(b2.getOwner());
    }
}