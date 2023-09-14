/**
 * class Investment extends BankAccount
 */
public class Investment extends BankAccount {
    private String type;

    public Investment(long number, String owner, double balance, String type) {
        super(number, owner, balance);
        this.type = type;
    }

    /**
     * accessor method for type
     * @return type of investment
     */
    public String getType() {
        return type;
    }

    /**
     * mutator method for type
     * @param type 
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * calculate profit or loss
     * @return double with amount loss/profit
     */
    public double getProfitOrLoss() {
        double number = Math.random();
        double amount;
        if (number < 0.5) {
            amount = (balance * 0.05);
            balance -= amount;
            return -amount;
        } else {
            amount = (balance * 0.05);
            balance += amount;
            return amount;
        }

    }

    /**
     * method to return formatted attributes
     * @return String of formatted attributes
     */
    @Override
    public String toString() {
        String out = "Investment\t" + super.toString();
        out += String.format("\t%s\n", type);
        return out;
    }
}