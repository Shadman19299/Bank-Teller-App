package Bank;

/**
 * Factory class for creating different types of transactions.
 */

public class ProcessTransaction {

    /**
     * Creates a transaction based on customer position.
     * 
     * @param customerName     Name of the customer
     * @param customerPosition Position in queue
     * @return Transaction object (either Deposit or Withdrawal)
     */
    public static Transaction createTransaction(String customerName, int customerPosition) {
        if (customerPosition % 3 == 0 && customerPosition % 5 == 0) {
            return new Withdrawal(customerName, 250.00);
        } else if (customerPosition % 5 == 0) {
            return new Deposit(customerName, 475.00);
        } else if (customerPosition % 3 == 0){
            return new Deposit(customerName, 225.00);
        }
        else {
            return new Deposit(customerName, 100.00);
        }
    }
}
