/**
 * class Checking extends BankAccount
 */
public class Checking extends BankAccount {
    public Checking(long number, String owner, double balance) {
        super(number, owner, balance);
    }
    /**
     * @return String of formatted attributes
     */
    @Override
    public String toString() {
        String out = "Checking\t" + super.toString() + "\n";
        return out;
    }
}
