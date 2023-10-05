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
        //write recursive method to find account by calling on the findaccount method again
        return findAccount(number, size());
    }

    public BankAccount findAccount(long number, int size) {
        if (size == 0) {
            return null;
        } else if (number == accounts[size - 1].getNumber()) {
            return accounts[size - 1];
        } else {
            return findAccount(number, size - 1);
        }
    }

    /**
     * getting total funds in bank accounts
     * @return double of total
     */
    public double getTotalFunds() {
        double total = 0;
        for (int i = 0; i < size(); i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }

    /**
     * checks if bank is closeable
     * @return boolean of if it is true/false
     */
    public boolean isCloseable() {
        if (getTotalFunds() > 2000000 || size() < 100) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * returns bank accounts that are closeable 
     * @return BankAccount[] which are closeable
     */
    public BankAccount[] getCloseableAccounts() {
        BankAccount[] tempAccounts = new BankAccount[count];
        int count = 0;
        for (int i = 0; i < size(); i++) {
            if (accounts[i].isCloseable()) {
                tempAccounts[count] = accounts[i];
                count++;
            }
        }
        BankAccount[] closeableAccounts = new BankAccount[count];

        for (int i = 0; i < size(); i++) {
            if (tempAccounts[i] != null) {
                closeableAccounts[i] = tempAccounts[i];
            }
        }

        return closeableAccounts;
    }

    /**
     * removes account in array 
     * @param number of bankaccount
     * @return if it was removed
     */
    public boolean removeAccount(long number) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getNumber() == number) {
                for (int j = i; j < count; j++) {
                    accounts[j] = accounts[j + 1];
                }
                count--;
                return true;
            }
        }
        return false;
    }


    /**
     * Uses java array functions to sort array with compareTo
     */
    public void sortAccounts() {
        java.util.Arrays.sort(accounts, 0, count);
    }

    public void mergeSort() {
        mergeSort(accounts);
    }


    public void mergeSort(BankAccount[] list) {
        mergeSort(list, count);
    }

    /**
  Merge sort method
  @param list to be sorted
  @param size # of items to sort
    */

    public void mergeSort(BankAccount[] list, int size) {
        if (size > 1) { // length==1: base case
            // split list into two halves
            BankAccount[] firstHalf = new BankAccount[size / 2];
            BankAccount[] secondHalf = new BankAccount[size - (size / 2)];
            // copy the first half of list into the array firstHalf
            System.arraycopy(list, 0, firstHalf, 0, size / 2);
            // copy the second half of list into the array secondtHalf
            System.arraycopy(list, size / 2, secondHalf, 0, size - (size / 2));
            // recursive call on each half
            mergeSort(firstHalf, size / 2);
            mergeSort(secondHalf, size - (size / 2));
            // merge the sorted halves back into list
            merge(firstHalf, secondHalf, list);
        }
    }
    /**
      merge method used by mergeSort
      @param list where the merged elements will be stored
      @param list1 the first sorted list to be merged
      @param list2 the second sorted list to be merged
    */
    public void merge(BankAccount[] list1, BankAccount[] list2, BankAccount[] list) {
        int list1Index = 0;
        int list2Index = 0;
        int listIndex = 0;
        while (list1Index < list1.length && list2Index < list2.length) {
            // order array by owners name
            if (list1[list1Index].getOwner().compareTo(list2[list2Index].getOwner()) < 0)
                list[listIndex++] = list1[list1Index++];
            else
                list[listIndex++] = list2[list2Index++];
        }
        // copy the remaining elements of list1 if list1 is longer than list2
        while (list1Index < list1.length)
            list[listIndex++] = list1[list1Index++];
        // copy the remaining elements of list2 if list2 is longer than list1
        while (list2Index < list2.length)
            list[listIndex++] = list2[list2Index++];
    }

    /**
     * string of attributes
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