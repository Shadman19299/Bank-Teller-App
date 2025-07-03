package Bank;

/**
 * Exception thrown when there are insufficient funds to complete a transaction.
 * This can occur when:
 * - A withdrawal amount exceeds the teller's drawer balance
 * - The resulting balance would fall below the minimum required balance
 */
public class InsufficientFundsException extends BankException {

    /**
     * Constructs an InsufficientFundsException with the given message.
     *
     * @param message the detail message
     */
    public InsufficientFundsException(String message) {
        super(message);
    }
}