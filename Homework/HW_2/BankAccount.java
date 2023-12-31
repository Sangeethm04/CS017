/**
 * Abstract class BankAccount to model the entity Bank
 */
abstract public class BankAccount {

    private long number;
    private String owner;
    protected double balance;

    /**
     * Constructor for the BankAccount class
     * @param number
     * @param owner
     * @param balance
     */
    public BankAccount(long number, String owner, double balance) {
        this.number = number;
        this.owner = owner;
        this.balance = balance;
    }

    /**
     * Accessor for the number
     * @return the account number
     */
    public long getNumber() {
        return number;
    }

    /**
     * Accessor for the owner
     * @return the account owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Accessor for the balance
     * @return the account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Mutator for the number
     * @param number
     */
    public void setNumber(long number) {
        this.number = number;
    }

    /**
     * Mutator for the amount
     * @param owner
     */
    public void deposit(double amount) {
        this.balance += amount;
    }

    /**
     * Mutator for the amount
     * @param amount
     * @return true or false if enough funds
     */
    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        } else {
            this.balance -= amount;
            return true;
        }
    }

    /**
     * Accessor for the Account attributes
     * @return formatted string with the object attributes
     */
    public String toString() {
        String str = String.format("%-10d\t%-30s\t$%-10.2f", number, owner, balance);
        return str;
    }

}