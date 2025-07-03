package Bank;

import java.util.Scanner;


/**
 * Handles user input operations for the banking system.
 */
public class InputHandler {
    /** Scanner object for reading user input */
    private Scanner scanner;

    /**
     * Constructs a new InputHandler object with a Scanner for user input.
     */
    public InputHandler() {
        scanner = new Scanner(System.in);
    }

    /**
     * Prompts for and returns the customer's name.
     * @return String containing customer's name
     */
    public String getCustomerName() throws InvalidInputException {
        System.out.print("Enter customer's name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            throw new InvalidInputException("Customer name cannot be empty");
        }
        return name;
    }


    /**
     * Gets the type of transaction from user input.
     * @return TransactionType enum (Deposit or Withdrawal)
     */
    public TransactionType getTransictionType() throws InvalidInputException {
        System.out.println("Select Transaction Type(1 for Deposit, 2 for Withdrawal): ");
        String choice = scanner.nextLine().trim();
        if (!choice.matches("[12]")) {
            throw new InvalidInputException("Invalid transaction type. Please enter 1 or 2");
        }
        return choice.equals("2") ? TransactionType.Withdrawal : TransactionType.Deposit;
    }


    /**
     * Gets the transaction amount from user input.
     * @return double value representing the transaction amount
     */
    public double getTransationAmount() throws InvalidInputException {
        System.out.print("Enter transaction amount: ");

        try {
            String amount = scanner.nextLine();
            double value = Double.parseDouble(amount);
            if (value <= 0) {
                throw new InvalidInputException("Transaction amount must be greater than zero");
            } return value;
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Invalid amount format. Please enter a valid number");
        }
    }

    /**
     * Checks if there are more customers to process.
     * @return boolean true if more customers exist, false otherwise
     */

    public boolean hasMoreCustomer() {
        System.out.print("\n Do you want to add more customer? (Y/N): ");
        String response = scanner.nextLine().trim();
        return response.equalsIgnoreCase("Y");
    }

    /**
     * Closes the Scanner resource.
     */
    public void closeScanner() {
        scanner.close();
    }

}
