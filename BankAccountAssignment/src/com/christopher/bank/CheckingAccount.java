// CheckingAccount.java
package com.christopher.bank;

public class CheckingAccount extends BankAccount {
    private double interestRate;
    private static final double OVERDRAFT_FEE = 30.00;

    // Constructor 1: No-argument constructor for CheckingAccount
    public CheckingAccount() {
        super(); // Calls the BankAccount() (no-arg) constructor
        this.interestRate = 0.0; // Default interest rate
    }

    // Constructor 2: Constructor with all details for CheckingAccount,
    // which then calls the parameterized constructor of BankAccount.
    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID); // Calls BankAccount's new constructor
        this.interestRate = interestRate;
    }

    // Setter for interestRate
    public void setInterestRate(double interestRate) {
        if (interestRate >= 0) {
            this.interestRate = interestRate;
        } else {
            System.out.println("Interest rate cannot be negative.");
        }
    }

    // Getter for interestRate
    public double getInterestRate() {
        return interestRate;
    }

    // Overriding the withdrawal method to implement overdraft logic
    // This fulfills the "processWithdrawal()" requirement.
    @Override
    public void withdrawal(double amount) {
        if (amount > 0) {
            if (this.balance >= amount) {
                // If sufficient funds, call the superclass withdrawal
                super.withdrawal(amount);
            } else {
                // Overdraft scenario
                this.balance -= amount; // Subtract the requested amount
                this.balance -= OVERDRAFT_FEE; // Subtract the overdraft fee
                System.out.println("Withdrawal of $" + String.format("%.2f", amount) + " processed.");
                System.out.println("OVERDRAFT FEE of $" + String.format("%.2f", OVERDRAFT_FEE) + " applied.");
                System.out.println("New balance (including fee): $" + String.format("%.2f", this.balance));
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // displayAccount method
    public void displayAccount() {
        System.out.println("\n--- Checking Account Details ---");
        System.out.println("Account ID: " + getAccountID()); // Using getter from superclass
        System.out.println("Account Holder: " + getFirstName() + " " + getLastName()); // Using getters from superclass
        System.out.println("Current Balance: $" + String.format("%.2f", getBalance())); // Using getter from superclass
        System.out.println("Interest Rate: " + String.format("%.2f", (interestRate * 100)) + "%");
        System.out.println("-------------------------------");
    }
}