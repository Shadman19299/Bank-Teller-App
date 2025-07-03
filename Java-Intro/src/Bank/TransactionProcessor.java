package Bank;

/**
 * Processes different types of bank transactions.
 */
public class TransactionProcessor {
    private static final double MinimumBalance = 0;
    private static final double MaxTransaction = 100000.00;

    /**
     * Processes a transaction based on its type.
     * 
     * @param teller       Teller processing the transaction
     * @param customerName Name of the customer
     * @param type         Type of transaction
     * @param moneyamount  Amount involved
     * @return boolean indicating success of transaction
     * @throws BankException
     */
    public boolean processTransaction(Teller teller, String customerName, TransactionType type, double moneyamount)
            throws BankException {
        validateTransaction(moneyamount);

        if (type == TransactionType.Withdrawal) {
            return processWithdrawal(teller, customerName, moneyamount);
        } else {
            return processDeposit(teller, customerName, moneyamount);
        }
    }

    private void validateTransaction(double moneyamount) throws InvalidInputException {
        if (moneyamount > MaxTransaction) {
            throw new InvalidInputException("Transaction amount exceeds the maximum limit of " + MaxTransaction);
        }
    }

    /**
     * Processes a withdrawal transaction.
     * 
     * @param teller       Teller processing the withdrawal
     * @param customerName Name of the customer
     * @param moneyAmount  Amount to withdraw
     * @return boolean indicating success of withdrawal
     * @throws InvalidTransactionException
     */
    private boolean processWithdrawal(Teller teller, String customerName, double moneyAmount)
            throws InsufficientFundsException, InvalidTransactionException {
        if (teller.getDrawerBalance() - moneyAmount < MinimumBalance) {
            throw new InsufficientFundsException(
                    "Insufficient funds in teller drawer. Please visit another teller");
        }
        Transaction withdrawal = new Withdrawal(customerName, moneyAmount);
        teller.processTransaction(withdrawal);
        return true;
    }

    /**
     * Processes a deposit transaction.
     * 
     * @param teller       Teller processing the deposit
     * @param customerName Name of the customer
     * @param moneyAmount  Amount to deposit
     * @return boolean indicating success of deposit
     * @throws InvalidTransactionException
     */
    private boolean processDeposit(Teller teller, String customerName, double moneyAmount)
            throws InvalidTransactionException {
        Transaction deposit = new Deposit(customerName, moneyAmount);
        teller.processTransaction(deposit);
        return true;
    }

    /**
     * Displays the result of a transaction.
     * 
     * @param success Whether transaction was successful
     * @param teller  Teller who processed the transaction
     */
    public void displayTransactionResult(boolean success, Teller teller) {
        if (success) {
            System.out.println("Transaction successful");
            System.out.printf("Teller %d current balance: $%.2f\n",
                    teller.getWindowNumber(), teller.getDrawerBalance());
        }
    }
}
