package Bank;

/**
 * Manages core banking operations and customer transactions.
 */

public class BankOperation {
    private TellerLobbyManagement lobby;
    private InputHandler inputHandler;
    private TimeManager timeManager;
    private TransactionProcessor transactionProcessor;

    /**
     * Initializes a new BankOperation with required components.
     */
    public BankOperation() {
        this.lobby = new TellerLobbyManagement();
        this.inputHandler = new InputHandler();
        this.timeManager = new TimeManager();
        this.transactionProcessor = new TransactionProcessor();
    }

    /**
     * Processes regular customers from initial data.
     * 
     * @throws InvalidTransactionException
     */
    public void getRegularCustomers() throws InvalidTransactionException {
        String[] regularcustomers = InitialCustomerData.getInitialCustomers();
        lobby.processCustomers(regularcustomers);
        lobby.printReport();
    }

    private void handleCustomerTransaction() {
        try {
            String customerName = inputHandler.getCustomerName();
            TransactionType transactionType = inputHandler.getTransictionType();
            double moneyAmount = inputHandler.getTransationAmount();
            Teller selectedTeller = lobby.getNextTeller();

            boolean success = transactionProcessor.processTransaction(
                    selectedTeller, customerName, transactionType, moneyAmount);
            transactionProcessor.displayTransactionResult(success, selectedTeller);

        } catch (InvalidInputException e) {
            System.err.println("Input Error: " + e.getMessage());
            System.out.println("Please try again.");
        } catch (InsufficientFundsException e) {
            System.err.println("Transaction Failed: " + e.getMessage());
        } catch (InvalidTransactionException e) {
            System.err.println("Invalid Transaction: " + e.getMessage());
        } catch (BankException e) {
            System.err.println("Bank Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Handles individual customer transactions.
     */
    // private void handleCustomerTransaction() {
    // String customerName = inputHandler.getCustomerName();
    // TransactionType transactionType = inputHandler.getTransictionType();
    // double moneyAmount = inputHandler.getTransationAmount();

    // // Teller selectedTeller = lobby.getTellerWithHighestBalance();
    // Teller selectedTeller = lobby.getNextTeller();// Needed to alternate between
    // the teller than to select the best
    // // teller as it will create an issue where one teller is selected
    // // over and the other.
    // boolean success = transactionProcessor.processTransaction(selectedTeller,
    // customerName, transactionType,
    // moneyAmount);
    // transactionProcessor.displayTransactionResult(success, selectedTeller);

    // }

    /**
     * Initiates and manages teller services.
     */
    public void StartTellerService() {
        System.out.println("\nStarting teller service...");
        try {
            while (timeManager.isBankOpen()) {
                if (!inputHandler.hasMoreCustomer()) {
                    break;
                }
                handleCustomerTransaction();
            }
        } finally {
            if (!timeManager.isBankOpen()) {
                timeManager.displayClosingMessage();
            }
            System.out.println("\nFinal Bank Status: ");
            lobby.printReport();
            inputHandler.closeScanner();
        }
    }
}
