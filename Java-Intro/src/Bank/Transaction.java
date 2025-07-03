package Bank;

/**
 * Abstract base class for all bank transactions.
 */
public abstract class Transaction {
    protected String customerName;
    protected double money;

    /**
     * Creates a new transaction.
     * 
     * @param customerName Name of the customer
     * @param money        Amount involved in transaction
     */
    public Transaction(String customerName, double money) {
        this.customerName = customerName;
        this.money = money;
    }

    /**
     * Processes the transaction amount.
     * 
     * @param currentBalance Current balance
     * @return Updated balance after transaction
     */
    abstract double processAmount(double currentBalance);

    /**
     * Gets transaction description.
     * 
     * @return Formatted transaction description
     */
    abstract String getTransactionDescription();

    // Getter methods
    public String getCustomerName() {
        return customerName;
    }

    public double getMoney() {
        return money;
    }
}