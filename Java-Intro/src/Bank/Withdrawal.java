package Bank;

/**
 * Represents a withdrawal transaction in the banking system.
 * Extends Transaction class.
 */
public class Withdrawal extends Transaction {
    /**
     * Creates a new withdrawal transaction.
     * 
     * @param customerName Name of the customer
     * @param money        Amount to withdraw
     */
    public Withdrawal(String customerName, double money) {
        super(customerName, money);
    }

    /**
     * Processes the withdrawal amount.
     * 
     * @param currentBalance Current balance before withdrawal
     * @return Updated balance after withdrawal
     */
    @Override
    double processAmount(double currentBalance) {
        return currentBalance - money;
    }

    /**
     * Gets the transaction description.
     * 
     * @return Formatted string describing the withdrawal
     */
    @Override
    String getTransactionDescription() {
        return String.format("%s - withdrawal: $%.2f", customerName, money);
    }
}
