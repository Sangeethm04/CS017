import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


/**
 * class Bank to model entity Bank
 */
public class Bank implements Closeable {
    private BankAccount[] accounts;
    private int count;

    /**
     * Default constructor
     */
    public Bank() {
        accounts = new BankAccount[50];
        count = 0;
    }

    /** 
     * constructor for Bank class
     * @param filename
     */
    public Bank(String filename) {
        accounts = new BankAccount[100];
        count = readAccounts(filename);
    }

    public int size() {
        return count;
    }

    /**
     * Reads accounts from file
     * @param filename
     * @return int of count
     */
    private int readAccounts(String filename) {
        File file = new File(filename);
        count = 0;
        try {
            Scanner readFile = new Scanner(file);
            String[] attributes = new String[4];
            while (readFile.hasNextLine()) {

                String newLine = readFile.nextLine();
                attributes = newLine.split("\\|");
                if (attributes[0].equals("Checking")) {
                    accounts[count] = new Checking(Long.valueOf(attributes[1]), attributes[2], Double.parseDouble(attributes[3]));
                }
                if (attributes[0].equals("Savings")) {
                    accounts[count] = new Savings(Long.valueOf(attributes[1]), attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4]));
                }
                if (attributes[0].equals("Investment")) {
                    accounts[count] = new Investment(Long.valueOf(attributes[1]), attributes[2], Double.parseDouble(attributes[3]), attributes[4]);
                }
                count++;
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        }
        return count;


    }


    /**
     * Saves account to file
     * @param filename
     */
    public void saveAccount(String filename) {
        File file = new File(filename);
        try {
            PrintWriter filewriter = new PrintWriter(file);
            for (int i = 0; i < count; i++) {
                if (accounts[i] instanceof Checking) {
                    filewriter.println("Checking|" + accounts[i].getNumber() + "|" + accounts[i].getOwner() + "|" + accounts[i].getBalance());
                } else if (accounts[i] instanceof Savings) {
                    Savings save = (Savings) accounts[i];
                    filewriter.println("Savings|" + accounts[i].getNumber() + "|" + accounts[i].getOwner() + "|" + accounts[i].getBalance() + "|" + save.getYearlyInterest());
                } else if (accounts[i] instanceof Investment) {
                    Investment invest = (Investment) accounts[i];
                    filewriter.println("Investment|" + accounts[i].getNumber() + "|" + accounts[i].getOwner() + "|" + accounts[i].getBalance() + "|" + invest.getType());
                }
            }

            filewriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("cannot write to file");
        }
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

    public double getTotalFunds() {
        double total = 0;
        for (int i = 0; i < size(); i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }

    public boolean isCloseable() {
        if (getTotalFunds() > 2000000 || size() < 100) {
            return false;
        } else {
            return true;
        }
    }

    public BankAccount[] getCloseableAccounts() {
        int count = 0;
        BankAccount[] accountsBank = new BankAccount[50];
        for(int i = 0; i<count; i++) {
            if(accounts[i].isCloseable()) {
                accountsBank[count] = accounts[i]; 
                count++;
            }
        }
        return accountsBank;
    }

    public boolean removeAccount(long number) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getNumber() == number) {
                for(int j = i; j < count-1;j++) {
                    accounts[j] = accounts[j+1];
                }
                return true;
            }
        }
        return false;
    }

    public void sortAccounts() {
        java.util.Arrays.sort(accounts);
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