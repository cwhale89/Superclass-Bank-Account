package com.christopher.bank; 

public class Banktest {

    public static void main(String[] args) {
        System.out.println("--- Testing BankAccount ---");

        // Create a BankAccount object
        // Assuming BankAccount now has the constructor: BankAccount(String firstName, String lastName, int accountID)
        BankAccount myBankAccount = new BankAccount("Chris", "Whaley", 1001);

        myBankAccount.accountSummary(); // Should show initial balance 0.0

        myBankAccount.deposit(500.00);
        myBankAccount.withdrawal(150.75);
        myBankAccount.withdrawal(400.00); // Should show insufficient funds if balance is not enough

        myBankAccount.accountSummary(); // Should show updated balance

        System.out.println("\n--- Testing CheckingAccount ---");

        // Create a CheckingAccount object
        // Assuming CheckingAccount now has the constructor: CheckingAccount(String firstName, String lastName, int accountID, double interestRate)
        CheckingAccount myCheckingAccount = new CheckingAccount("Bob", "Johnson", 2002, 0.015); // 1.5% interest

        myCheckingAccount.displayAccount(); // Should show initial details (balance 0.0)

        myCheckingAccount.deposit(1000.00);
        myCheckingAccount.withdrawal(200.00); // Standard withdrawal

        myCheckingAccount.displayAccount();

        // This simulates an overdraft scenario:
        // Current balance (after 1000 deposit and 200 withdrawal) is $800.00
        // Trying to withdraw $900.00 will trigger the overdraft fee.
        myCheckingAccount.withdrawal(900.00);

        myCheckingAccount.displayAccount(); // Should show negative balance with overdraft fee

        // Another withdrawal while in overdraft
        myCheckingAccount.withdrawal(50.00);
        myCheckingAccount.displayAccount();
    }
}