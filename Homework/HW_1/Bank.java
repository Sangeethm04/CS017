/**
 * class Bank
 */
public class Bank {
    private BankAccount[] accounts;
    private int count;
    public Bank() {
        accounts = new BankAccount[50];
        count = 0;
    }
    /**
     * Adds account to array of BankAccount
     * @param ba
     */
    public void addAccount(BankAccount ba) {
        accounts[count] = ba;
        count++;
    }
    /**
     * Finds account using number
     * @param number
     * @return
     */
    public BankAccount findAccount(long number) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getNumber() == number) {
                return accounts[i];
            }
        }
        return null;
    }


    /**
     * 
     * @param numberOrBalance
     */
    public void sortAccounts(boolean numberOrBalance) {
        for (int i = 1; i < count; i++) {
            if (numberOrBalance) {

                BankAccount key = accounts[i];
                int j = i - 1;
                while (j >= 0 && accounts[j].getNumber() > key.getNumber()) {
                    accounts[j + 1] = accounts[j];
                    j = j - 1;
                }
                accounts[j + 1] = key;
            } else {
                BankAccount key = accounts[i];
                int j = i - 1;
                while (j >= 0 && accounts[j].getBalance() > key.getBalance()) {
                    accounts[j + 1] = accounts[j];
                    j = j - 1;
                }
                accounts[j + 1] = key;
            }
        }

    }

    /**
     * @return String of attributes
     */
    public String toString() {
        System.out.println("Type\t\tNumber\t\tOwner\t\t\t\tBalance\t\tInterest/InvestmentType");
        String out = "";
        for (int i = 0; i < count; i++) {
            out += accounts[i].toString();
        }
        return out;
    }
}