package Bank;
/**
 * Exception thrown when a transaction violates banking rules or constraints.
 * This can occur in situations such as:
 * - Invalid transaction amounts (negative or zero)
 * - Exceeding maximum transaction limits
 * - Invalid transaction types
 * - Null transaction objects
 */
public class InvalidTransactionException extends BankException {
    
    /**
     * Constructs a new InvalidTransactionException with the specified error message.
     * @param message The detailed message describing the invalid transaction condition
     */
    public InvalidTransactionException(String message) {
        super(message);
    }
}