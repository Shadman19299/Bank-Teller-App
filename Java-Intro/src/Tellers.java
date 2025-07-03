import java.util.ArrayList;
import java.util.List;


/**
 * Represents a bank teller station that processes customer transactions and maintains
 * a cash drawer balance. Each teller has a unique window number and tracks all
 * customer interactions and transactions.
 */
public class Tellers {
    private int windowNumber; //The window number for the teller station
    private double drawerBalance; //The cash drawer balance
    private List<String> customersServed; //List of customers
    private List<String> transactions; //List of transactions


    /**
     * Constructs a new Teller with the specified window number.
     * Initializes the cash drawer with a starting balance of $2,500.00 and
     * creates empty lists for tracking customers and transactions.
     *
     * @param windowNumber The unique identifier for this teller window
     */
    public Tellers(int windowNumber) {
        this.windowNumber = windowNumber;
        this.drawerBalance = 2500.00;
        this.customersServed = new ArrayList<>();
        this.transactions = new ArrayList<>();
    }

    /**
     * Processes a customer transaction based on their position in line.
     * Transaction rules:
     * - Every third customer (position % 3 == 0) withdraws $250
     * - Every fifth customer (position % 5 == 0) deposits $475
     * - All other customers deposit $100
     * 
     * Updates the drawer balance accordingly and records the transaction details.
     *
     * @param customerName The name of the customer being served
     * @param customerPosition The customer's position in the original line (1-based index)
     */

    public void processCustomer(String customerName, int customerPosition) {
        double money;
        String transactionType;

        // Determine transaction type and amount based on customer position
        if (customerPosition % 3 == 0 && customerPosition % 5 == 0) {
            money = 225.00;
            transactionType = "deposit";
            drawerBalance += money;
        } else if (customerPosition % 5 == 0) {
            money = 475.00;
            transactionType = "deposit";
            drawerBalance += money;
        } else if(customerPosition % 3==0){
            money = 250.00;
            transactionType = "withdrawal";
            drawerBalance -= money;
        }
        else{
            money = 100.00;
            transactionType = "deposit";
            drawerBalance += money;
        }

        customersServed.add(customerName);
        transactions.add(String.format("%s - %s: $%.2f", customerName, transactionType, money));
    }

    /**
     * Prints a detailed report of all transactions and activities at this teller window.
     * The report includes:
     * - Teller window number
     * - List of all customers served in order
     * - Details of each transaction processed
     * - Final balance in the cash drawer
     * 
     * Output is formatted for easy reading with appropriate headers and separators.
     */
    public void printReport() {
        System.out.println("\nTeller Window " + windowNumber + " Report");
        System.out.println("----------------------------------------");
        System.out.println("Customers served:");
        for (int i = 0; i < customersServed.size(); i++) {
            System.out.println((i + 1) + ". " + customersServed.get(i));
        }
        
        System.out.println("\nTransactions:");
        for (String transaction : transactions) {
            System.out.println("- " + transaction);
        }
        
        System.out.printf("\nFinal drawer balance: $%.2f\n", drawerBalance);
    }
}


