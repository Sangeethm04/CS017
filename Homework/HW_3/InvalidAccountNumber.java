/**
 * custom exception class thrown when an invalid account number is entered
 */
public class InvalidAccountNumber extends Exception {
    public InvalidAccountNumber() {

    }

    /**
     * constructor for InvalidAccountNumber
     * @param messageq
     */
    public InvalidAccountNumber(String message) {
        super(message);
    }
}