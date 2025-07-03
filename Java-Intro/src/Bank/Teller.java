package Bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank teller with transaction capabilities.
 */
public class Teller {
    private int windowNumber;
    private double drawerBalance;
    private List<Transaction> transactions;

    /**
     * Creates a new teller with specified window number.
     * 
     * @param windowNumber Teller's window number
     */
    public Teller(int windowNumber) {
        this.windowNumber = windowNumber;
        this.drawerBalance = 2500.00;
        this.transactions = new ArrayList<>();
    }

    /**
     * Processes a transaction.
     * 
     * @param transaction Transaction to process
     */
    public void processTransaction(Transaction transaction) throws InvalidTransactionException {
        if (transaction == null) {
            throw new InvalidTransactionException("Transaction cannot be null");
        }
        
        double newBalance = transaction.processAmount(drawerBalance);
        if (newBalance < 0) {
            throw new InvalidTransactionException("Transaction would result in negative balance");
        }
        
        drawerBalance = newBalance;
        transactions.add(transaction);
    }
    // Getter methods
    public int getWindowNumber() {
        return windowNumber;
    }

    public double getDrawerBalance() {
        return drawerBalance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
