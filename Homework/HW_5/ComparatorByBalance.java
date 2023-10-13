import java.util.Comparator;
/**
 * ComparatorByBalance class
 */
public class ComparatorByBalance implements Comparator < BankAccount > {
    /**
     * compare method for comparator
     * @param b1
     * @param b2
     * @return int
     */
    public int compare(BankAccount b1, BankAccount b2) {
        Double bal1 = b1.getBalance();
        Double bal2 = b2.getBalance();
        return bal1.compareTo(bal2);
    }
}