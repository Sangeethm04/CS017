import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


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

    public Bank(String filename) {
        accounts = new BankAccount[100];
        count = readAccounts(filename);
    }

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

    public void saveAccount(String filename) {
        File file = new File(filename);
        try {
            PrintWriter filewriter = new PrintWriter(file);
            for (int i = 0; i < count; i++) {
                filewriter.print(accounts[i]);
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