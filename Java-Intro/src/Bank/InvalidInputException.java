package Bank;

/**
 * Exception thrown when user input validation fails.
 * This can occur in situations such as:
 * - Empty or null customer names
 * - Invalid transaction type selections
 * - Invalid numeric input for amounts
 * - Invalid response format for yes/no questions
 */
public class InvalidInputException extends BankException {

    /**
     * Constructs a new InvalidInputException with the given message.
     * @param message Error message
     */
    public InvalidInputException(String message) {
        super(message);
    }
}