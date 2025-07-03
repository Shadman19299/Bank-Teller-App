package Bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages teller operations and customer processing in the lobby.
 */
public class TellerLobbyManagement {
    private List<Teller> tellers;
    private boolean isFirstTeller = true;

    /**
     * Initializes lobby management with two tellers.
     */
    public TellerLobbyManagement() {
        tellers = new ArrayList<>();
        tellers.add(new Teller(1));
        tellers.add(new Teller(2));
    }

    /**
     * Processes a batch of customers.
     * 
     * @param customers Array of customer names
     * @throws InvalidTransactionException
     */
    public void processCustomers(String[] customers) throws InvalidTransactionException {
        for (int i = 0; i < customers.length; i++) {
            Teller currentTeller = tellers.get(i % 2);
            Transaction transaction = ProcessTransaction.createTransaction(customers[i], i + 1);
            currentTeller.processTransaction(transaction);
        }
    }

    /**
     * Gets the next available teller in rotation.
     * 
     * @return Teller object
     */
    public Teller getNextTeller() {
        Teller selectedTeller = tellers.get(isFirstTeller ? 0 : 1);
        isFirstTeller = !isFirstTeller; // Toggle for next time
        return selectedTeller;
    }

    /**
     * Gets the teller with the highest drawer balance.
     * 
     * @return Teller object with highest balance
     */
    public Teller getTellerWithHighestBalance() {
        Teller highestBalanceTeller = tellers.get(0);
        for (Teller teller : tellers) {
            if (teller.getDrawerBalance() > highestBalanceTeller.getDrawerBalance()) {
                highestBalanceTeller = teller;
            }
        }
        return highestBalanceTeller;
    }

    /**
     * Prints detailed report of all teller activities.
     */
    public void printReport() {
        for (Teller teller : tellers) {
            System.out.println("\nTeller Window " + teller.getWindowNumber() + " Report");
            System.out.println("----------------------------------------");

            System.out.println("Customers served:");
            List<Transaction> tellerTransactions = teller.getTransactions();
            for (int i = 0; i < tellerTransactions.size(); i++) {
                System.out.println((i + 1) + ". " + tellerTransactions.get(i).getCustomerName());
            }

            System.out.println("\nTransactions:");
            for (Transaction transaction : tellerTransactions) {
                System.out.println("- " + transaction.getTransactionDescription());
            }

            System.out.printf("\nFinal drawer balance: $%.2f\n", teller.getDrawerBalance());
        }
    }
}
