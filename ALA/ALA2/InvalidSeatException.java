/**
 * InvalidSeatException is a custom exception class that is thrown when a seat number is invalid
 */
public class InvalidSeatException extends Exception {
    /**
     * deafult constructor for InvalidSeatException
     */
    public InvalidSeatException() {
        super();
    }

    /**
     * Constructor for InvalidSeatException
     * @param message
     */
    public InvalidSeatException(String message) {
        super(message);
    }
}
