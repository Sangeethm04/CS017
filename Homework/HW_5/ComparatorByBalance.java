import java.util.Comparator;

public class ComparatorByBalance implements Comparator < BankAccount > {
    public int compare(BankAccount b1, BankAccount b2) {
        Double bal1 = b1.getBalance();
        Double bal2 = b2.getBalance();
        return bal1.compareTo(bal2);
    }
}