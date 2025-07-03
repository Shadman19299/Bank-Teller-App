[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/tcv9K4Do)
# Intro to Superior Java Week 1 Challenge

Follow the instruction from Canvas [CC 3.1 - Java Bank Teller App Challenge](https://awstechu.instructure.com/courses/778/modules/items/142642)

Commit your code here.


######################Code Description###############


# Solution1: Simple Implementation
**myMain.java** and **Teller.java** are the two Java files that fulfills the minimum project requirements, which are the following : 
1. A Teller class that keeps track of:
    - Window number
    - Drawer balance
    - List of customers served
    - List of transactions
2. Two main functions:
    - processCustomers: Handles the distribution of customers and their transactions
    - printTellerReport: Generates the detailed report for each teller
3. The program will:
    - Alternate customers between tellers
    - Process withdrawals for every third customer ($250)
    - Process deposits of $475 for every fifth customer
    - Process deposits of $100 for all other customers
    - Track all transactions and balances
    - Generate a detailed report for each teller

However, this solution has the following problems:
1. All transaction logic is hardcoded within the Teller class. Adding a new type of transaction would require modifying existing code.
2. Mixes transaction processing, creation, and business rules all within the Teller class.
3. Transaction logic is tightly coupled with the Teller class, making it difficult to reuse in other contexts.
4. Changes to transaction rules require modifying the Teller class, risking introduction of bugs.
5. Testing is more difficult as all functionality is combined.
6. All code in one file, making it harder to manage in a larger production situation.
7. Limited ability to add specific error handling for different transaction types.
8. Finally, overall portability of the Solution is very poor.
   
# Solution 2: Implementation with concept of Polymorphism
This is the reason, I created a second solution under the **Bank Package**, which does the following things:

1. Abstract Transaction Class: Creates a base class for all transaction types with abstract methods that must be implemented by subclasses.

2. Concrete Transaction Classes: Deposit and Withdrawal classes extend the Transaction class. Each implements its own version of processAmount and getTransactionDescription

3. ProcessTransiction: Implements the pattern to create appropriate transaction types. Encapsulates the logic for determining transaction type based on customer position

4. It provide private fields with appropriate getters and setters. It has better separation of concerns between classes

5. Each class has a specific responsibility such as, Transaction processing is separated from transaction creation and reporting is handled separately from transaction processing. 

6. This second solutoion is a comprehensive system designed to manage daily banking operations through a dual-teller setup. The application begins by initializing two teller windows, each with a starting balance of $2,500, and processes a preset list of regular customers with predefined transaction patterns. After handling the initial customer base, it transitions into an interactive service mode where new customers can perform deposits or withdrawals. The system operates within a 15-minute window, simulating regular banking hours, and alternates transactions between the two tellers to ensure balanced workload distribution.

7. This solution implements error handling through custom exceptions, managing scenarios such as insufficient funds, invalid inputs, and transaction errors. 

8. When the bank closes (After 15 minute of active session) or there are no more customers, the system generates a final report detailing all transactions and drawer balances, providing a complete overview of the day's operations before gracefully shutting down. 

Following is the Workflow of the Application: 

   1. Application starts
   2. Processes preset customers
   3. Displays initial report
   4. Begins interactive service
   5. For each new customer:
      - Enter customer details
      - Select transaction type
      - Enter amount
      - View result
   6. Continue until:
      - No more customers, or
      - Bank closing time
   7. Display final report

