package Bank;

/**
 * Represents a deposit transaction in the banking system.
 * Extends Transaction class.
 */
public class Deposit extends Transaction {

    /**
     * Constructs a new Deposit transaction.
     * @param customerName Name of the customer
     * @param Moneyamount Amount to deposit
     */
    public Deposit(String customerName, double Moneyamount) {
        super(customerName, Moneyamount);
    }

    /**
     * Processes the deposit amount.
     * @param currentBalance Current balance before deposit
     * @return Updated balance after deposit
     */
    @Override
    double processAmount(double currentBalance) {
        return currentBalance + money;
    }

    /**
     * Gets the transaction description.
     * @return Formatted string describing the deposit
     */
    @Override
    String getTransactionDescription() {
        return String.format("%s - deposit: $%.2f", customerName, money);
    }
}



