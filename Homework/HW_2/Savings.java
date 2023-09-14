/**
 * class Savings extends BankAccount
 */
public class Savings extends BankAccount {
    private double yearlyInterestRate;

    /**
     * constructor for savings class
     * @param number
     * @param owner
     * @param balance
     * @param yInterestRate
     */
    public Savings(long number, String owner, double balance, double yInterestRate) {
        super(number, owner, balance);
        this.yearlyInterestRate = yInterestRate;
    }

    /**
     * accessor method
     * @return double of the interest rate
     */
    public double getYearlyInterest() {
        return yearlyInterestRate;
    }

    /**
     * method to calculate monthly interest rate and add to balance
     * @return double of monthly interest rate
     */
    public double getMonthlyInterest() {
        double amount = ((((yearlyInterestRate / 12) / 100) * balance));
        balance += amount;
        return amount;
    }

    /**
     * mutator method
     * @param y interest rate
     */
    public void setYearlyInterestRate(double y) {
        this.yearlyInterestRate = y;
    }

    /**
     * method to apply monthly interest rate
     */
    public void applyMonthlyInterestRate() {
        balance += getMonthlyInterest();
    }

    /**
     * method to return formatted attributes
     * @return String of formatted attributes
     */
    @Override
    public String toString() {
        String out = "Savings\t\t" + super.toString();
        out += String.format("\t%.2f\n", yearlyInterestRate);
        return out;
    }
}