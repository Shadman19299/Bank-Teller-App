package Bank;
/**
 * Base exception class for all banking-related exceptions.
 * Serves as the parent class for more specific banking exceptions.
 */
public class BankException extends Exception {

    /**
     * Constructs a new BankException with the given message.
     *
     * @param message The exception message.
     */
    public BankException(String message) {
        super(message);
    }
}
