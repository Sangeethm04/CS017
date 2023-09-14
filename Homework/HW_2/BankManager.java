import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * class BankManager
 */
public class BankManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank myBank = new Bank("accounts.txt");
        int operation = 0;
        while (operation != 5) {
            System.out.println("1: View accounts");
            System.out.println("2: Manage account");
            System.out.println("3: Sort accounts by number");
            System.out.println("4: Sort accounts by balance");
            System.out.println("5: Exit");
            operation = input.nextInt();
            switch (operation) {
                case 1:
                    System.out.println(myBank.toString());
                    break;
                case 2:
                    System.out.println("Enter account number");
                    long accountNumber = input.nextLong();
                    try {
                        checkAccountNumber(accountNumber);
                        BankAccount account = myBank.findAccount(accountNumber);
                        int manageOperation = 0;
                        System.out.println("Account found. Balance = $" + account.getBalance());
                        while (manageOperation != 5) {
                            System.out.println();
                            System.out.println("Select an operation:");
                            System.out.println("1: Withdraw");
                            System.out.println("2: Deposit");
                            System.out.println("3: Apply monthly interest");
                            System.out.println("4: Apply investment profit/loss");
                            System.out.println("5: Return to main menu");
                            manageOperation = input.nextInt();
                            switch (manageOperation) {
                                case 1:
                                    System.out.println("Enter an amount:");
                                    double amount = input.nextDouble();
                                    if (account.withdraw(amount)) {
                                        System.out.println("Withdrawal Successful. The new balance: $" + account.getBalance());
                                    } else {
                                        System.out.println("Withdrawal failed. The available balance: $" + account.getBalance());
                                    }
                                    break;
                                case 2:
                                    System.out.println("Enter an amount:");
                                    amount = input.nextDouble();
                                    account.deposit(amount);
                                    System.out.println("Deposit Successful. The new balance: $" + account.getBalance());
                                    break;
                                case 3:
                                    if (account instanceof Savings) {
                                        Savings savingsAccount = (Savings) account;
                                        savingsAccount.applyMonthlyInterestRate();
                                        System.out.println("Monthly interest = $" + savingsAccount.getMonthlyInterest() + ". The new balance: $" + savingsAccount.getBalance());
                                    } else {
                                        System.out.println("Cannot get the monthly interest. Not a savings account.");
                                    }
                                    break;
                                case 4:
                                    if (account instanceof Investment) {
                                        Investment investmentAccount = (Investment) account;
                                        double change = investmentAccount.getProfitOrLoss();
                                        investmentAccount.deposit(change);
                                        System.out.println("New balance: " + investmentAccount.getBalance());
                                    } else {
                                        System.out.println("Cannot get the profit/loss. Not an investment account.");
                                    }
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Invalid operation");
                                    break;
                            }
                        }
                    } catch (InvalidAccountNumber e) {
                        System.out.println(e.getMessage());
                        break;
                    }

                    break;
                case 3:
                    myBank.sortAccounts(true);
                    System.out.println(myBank.toString());
                    break;
                case 4:
                    myBank.sortAccounts(false);
                    System.out.println(myBank.toString());
                    break;
                case 5:
                    myBank.saveAccount("accounts.txt");
                    break;
                default:
                    System.out.println("Invalid operation");
                    break;
            }
        }

    }

    public static boolean checkAccountNumber(long accountNumber) throws InvalidAccountNumber {
        String accountNum = String.valueOf(accountNumber);
        if (accountNum.matches("\\d{10}")) {
            return true;
        } else {
            throw new InvalidAccountNumber("Invalid Bank Account number (must be 10 digits)");
        }
    }
}