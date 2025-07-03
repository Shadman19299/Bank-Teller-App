/**
 * @author Shadman Rabbi
 */
/**
 * Main class that handles the bank teller simulation and customer processing.
 * This class manages the distribution of customers between two tellers and displays
 * the results of their transactions.
 */
public class myMain {
    /**
     * Processes an array of customers by distributing them between two tellers and
     * handling their transactions.
     * 
     * The method creates two teller instances and alternates customers between them.
     * Even-indexed customers go to teller1, odd-indexed customers go to teller2.
     * After processing all customers, it prints detailed reports for both tellers.
     *
     * @param customers An array of String containing customer names to be processed
     *                  in the order they appear in line
     */
	public static void processCustomers(String[] customers) {
        Tellers teller1 = new Tellers(1);
        Tellers teller2 = new Tellers(2);
        
        for (int i = 0; i < customers.length; i++) {
            // Determine which teller serves the current customer
            if (i % 2 == 0) {
                teller1.processCustomer(customers[i], i + 1);
            } else {
                teller2.processCustomer(customers[i], i + 1);
            }
        }

        // Print results
        teller1.printReport();
        teller2.printReport();
    }
    /**
     * The main entry point of the program.
     * 
     * Initializes an array of customer names, prints the list of customers in order,
     * and then processes all customer transactions through the teller system.
     * 
     * Transaction rules:
     * - Every third customer makes a withdrawal of $250
     * - Every fifth customer makes a deposit of $475
     * - All other customers make deposits of $100
     *
     * @param args Command line arguments (not used in this implementation)
     */
	public static void main(String[] args) {
		String[] customers = {
            "Jennifer Figueroa",
            "Heather Mcgee",
            "Amanda Schwartz",
            "Nicole Yoder",
            "Melissa Hoffman",
            "Beatrice Helman",
            "Louis Sanders",
            "Catherine Altman",
            "Ralph Estees",
            "Samantha Augustine",
            "Peter Fredricks",
            "David Alters"
        };
        
		for (int i = 0; i < customers.length; i++) {
			System.out.println("Customer " + (i + 1) + ": " + customers[i]);
		}

        processCustomers(customers);

	}

}
