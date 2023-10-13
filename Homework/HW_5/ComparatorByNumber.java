import java.util.Comparator;
/**
 * ComparatorByNumber class
 */
public class ComparatorByNumber implements Comparator < BankAccount > {
    /**
     * compare method for comparator for number
     * @param b1
     * @param b2
     * @return int
     */
    public int compare(BankAccount a, BankAccount b) {
        Long numA = a.getNumber();
        Long numB = b.getNumber();
        return numA.compareTo(numB);
    }
}