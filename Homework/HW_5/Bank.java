import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;


/**
 * class Bank to model entity Bank
 */
public class Bank implements Closeable {
    private ArrayList < BankAccount > accounts; 

    /**
     * Default constructor
     */
    //time complexity: O(1)
    public Bank() {
      accounts  = new ArrayList<>();
    }

    /** 
     * constructor for Bank class
     * @param filename
     */
    //time complexity: O(n)
    public Bank(String filename) {
        accounts  = new ArrayList<>(50);
        readAccounts(filename);
    }

    /**
     * getter for count
     * @return int of the # in array
     */
    //time complexity: O(1)
    public int size() {
        return accounts.size();
    }

    /**
     * Reads accounts from file
     * @param filename
     * @return int of count
     */
    //time complexity: O(n)
    private void readAccounts(String filename) {
        File file = new File(filename);
        try {
            Scanner readFile = new Scanner(file);
            String[] attributes = new String[4];
            while (readFile.hasNextLine()) {

                String newLine = readFile.nextLine();
                attributes = newLine.split("\\|");
                if (attributes[0].equals("Checking")) {
                    accounts.add(new Checking(Long.valueOf(attributes[1]), attributes[2], Double.parseDouble(attributes[3])));
                }
                if (attributes[0].equals("Savings")) {
                    accounts.add(new Savings(Long.valueOf(attributes[1]), attributes[2], Double.parseDouble(attributes[3]), Double.parseDouble(attributes[4])));
                }
                if (attributes[0].equals("Investment")) {
                    accounts.add(new Investment(Long.valueOf(attributes[1]), attributes[2], Double.parseDouble(attributes[3]), attributes[4]));
                }
            }
            readFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        }
    }


    /**
     * Saves account to file
     * @param filename
     */
    //time complexity: O(n)
    public void saveAccount(String filename) {
        File file = new File(filename);
        try {
            PrintWriter filewriter = new PrintWriter(file);
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i) instanceof Checking) {
                    filewriter.println("Checking|" + accounts.get(i).getNumber() + "|" + accounts.get(i).getOwner() + "|" + accounts.get(i).getBalance());
                } else if (accounts.get(i) instanceof Savings) {
                    Savings save = (Savings) accounts.get(i);
                    filewriter.println("Savings|" + accounts.get(i).getNumber() + "|" + accounts.get(i).getOwner() + "|" + accounts.get(i).getBalance() + "|" + save.getYearlyInterest());
                } else if (accounts.get(i) instanceof Investment) {
                    Investment invest = (Investment) accounts.get(i);
                    filewriter.println("Investment|" + accounts.get(i).getNumber() + "|" + accounts.get(i).getOwner() + "|" + accounts.get(i).getBalance() + "|" + invest.getType());
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
    //time complexity: O(1)
    public void addAccount(BankAccount ba) {
        accounts.add(ba);
    }
    /**
     * Finds account using number
     * @param number
     * @return
     */
    //time complexity: O(n)
    public BankAccount findAccount(long number) {
        //write recursive method to find account by calling on the findaccount method again
        return findAccount(number, size());
    }

    /**
     * Finds account using number
     * @param number
     * @param size
     * @return BankAccount of the found account
     */
    //time complexity O(n)
    public BankAccount findAccount(long number, int size) {
        if (size == 0) {
            return null;
        } else if (number == accounts.get(size - 1).getNumber()) {
            return accounts.get(size - 1);
        } else {
            return findAccount(number, size - 1);
        }
    }

    /**
     * getting total funds in bank accounts
     * @return double of total
     */
    //time complexity: O(n)
    public double getTotalFunds() {
        double total = 0;
        for (int i = 0; i < size(); i++) {
            total += accounts.get(i).getBalance();
        }
        return total;
    }

    /**
     * checks if bank is closeable
     * @return boolean of if it is true/false
     */
    //time complexity: O(n)
    public boolean isCloseable() {
        if (getTotalFunds() > 2000000 || size() > 100) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * returns bank accounts that are closeable 
     * @return BankAccount[] which are closeable
     */
    //time complexity: O(n)
    public ArrayList < BankAccount > getCloseableAccounts() {
        ArrayList < BankAccount > tempAccounts = new ArrayList < > (accounts.size());
        int count = 0;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).isCloseable()) {
                tempAccounts.set(count, accounts.get(i));
                count++;
            }
        }
        ArrayList < BankAccount > closeableAccounts = new ArrayList < > (count);

        for (int i = 0; i < accounts.size(); i++) {
            if (tempAccounts.get(i) != null) {
                closeableAccounts.set(i, tempAccounts.get(i));
            }
        }

        return closeableAccounts;
    }

    /**
     * removes account in array 
     * @param number of bankaccount
     * @return if it was removed
     */
    //time complexity: O(n)
    public boolean removeAccount(long number) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getNumber() == number) {
                for (int j = i; j < accounts.size() - 2; j++) {
                    accounts.set(j, accounts.get(j + 1));
                }
        
                return true;
            }
        }
        return false;
    }


    /**
     * Uses java array functions to sort array with compareTo
     */
    //time complexity: O(nlogn)
    public void sortAccounts(Comparator < BankAccount > c) {
        Utility.mergeSort(accounts, c);
    }


    /**
     * string of attributes
     * @return String of attributes
     */
    //time complexity: O(n)
    public String toString() {
        System.out.println("Type\t\tNumber\t\tOwner\t\t\t\tBalance\t\tInterest/InvestmentType");
        String out = "";
        for (int i = 0; i < accounts.size(); i++) {
            out += accounts.get(i).toString();
        }
        return out;
    }
}