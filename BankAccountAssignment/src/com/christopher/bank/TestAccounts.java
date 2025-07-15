// TestAccounts.java
package com.christopher.bank;

public class TestAccounts { // Class name matches file name: TestAccounts.java
    public static void main(String[] args) {
        System.out.println("--- Testing BankAccount ---");
        // Creating BankAccount using the no-argument constructor
        BankAccount myBankAccount = new BankAccount();
        myBankAccount.setFirstName("Alice");
        myBankAccount.setLastName("Smith");
        myBankAccount.setAccountID(1001);

        myBankAccount.accountSummary(); // Should show balance 0.0

        myBankAccount.deposit(500.00);
        myBankAccount.withdrawal(150.75);
        myBankAccount.withdrawal(400.00); // Should show insufficient funds

        myBankAccount.accountSummary(); // Should show updated balance

        System.out.println("\n--- Testing CheckingAccount ---");
        // Creating CheckingAccount using the parameterized constructor
        CheckingAccount myCheckingAccount = new CheckingAccount("Bob", "Johnson", 2002, 0.015); // 1.5% interest

        myCheckingAccount.displayAccount(); // Should show initial details

        myCheckingAccount.deposit(1000.00);
        myCheckingAccount.withdrawal(200.00); // Standard withdrawal (800.00 remaining)

        myCheckingAccount.displayAccount();

        // Overdraft scenario: current balance 800.00, trying to withdraw 900.00
        // Balance becomes 800 - 900 = -100, then -100 - 30 = -130
        myCheckingAccount.withdrawal(900.00);

        myCheckingAccount.displayAccount(); // Should show negative balance with overdraft fee

        // Another withdrawal with negative balance
        myCheckingAccount.withdrawal(50.00); // Balance -130 - 50 = -180, then -180 - 30 = -210
        myCheckingAccount.displayAccount();
    }
}