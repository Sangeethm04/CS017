import java.util.Comparator;

public class ComparatorByNumber implements Comparator < BankAccount > {
    public int compare(BankAccount a, BankAccount b) {
        Long numA = a.getNumber();
        Long numB = b.getNumber();
        return numA.compareTo(numB);
    }
}