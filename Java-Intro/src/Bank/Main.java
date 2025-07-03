package Bank;
/**
 * @author Shadman Rabbi 
 * /

/**
 * Main entry point for the banking application.
 */
public class Main {

    /**
     * Main method to start the banking application.
     * @param args Command line arguments (not used)
     * @throws InvalidTransactionException 
     */
         public static void main(String[] args) throws InvalidTransactionException {
        BankOperation bankOperation = new BankOperation();
        bankOperation.getRegularCustomers();
        bankOperation.StartTellerService();
    }
}