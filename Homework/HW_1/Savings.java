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
     * 
     * @return double of monthly interest rate
     */
    public double getMonthlyInterest() {
       double amount = ((((yearlyInterestRate / 12) / 100) * balance));
       balance+=amount;
        return amount;
    }

    public void setYearlyInterestRate(double y) {
        this.yearlyInterestRate = y;
    }

    public void applyMonthlyInterestRate() {

    }

    @Override
    public String toString() {
        String out = "Savings\t\t" + super.toString();
        out += String.format("\t%.2f\n", yearlyInterestRate);
        return out;
    }
}