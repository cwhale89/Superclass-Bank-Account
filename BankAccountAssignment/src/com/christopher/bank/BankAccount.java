// BankAccount.java
package com.christopher.bank;

public class BankAccount {
    private String firstName;
    private String lastName;
    private int accountID;
    protected double balance;

    // Constructor 1: No-argument constructor (initializes balance to zero)
    public BankAccount() {
        this.balance = 0.0;
    }

    // Constructor 2: Constructor with initial details (firstName, lastName, accountID)
    // This is the one that was missing and caused the error in CheckingAccount.java
    public BankAccount(String firstName, String lastName, int accountID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountID = accountID;
        this.balance = 0.0; // Still initialize balance to zero as per original requirement
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Deposit successful. New balance: $" + String.format("%.2f", this.balance));
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdrawal method (basic, overridden in CheckingAccount)
    public void withdrawal(double amount) {
        if (amount > 0) {
            if (this.balance >= amount) {
                this.balance -= amount;
                System.out.println("Withdrawal successful. New balance: $" + String.format("%.2f", this.balance));
            } else {
                System.out.println("Insufficient funds for this withdrawal. Current balance: $" + String.format("%.2f", this.balance));
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    // Setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }

    // accountSummary method
    public void accountSummary() {
        System.out.println("\n--- Account Summary ---");
        System.out.println("Account ID: " + accountID);
        System.out.println("Account Holder: " + firstName + " " + lastName);
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
        System.out.println("-----------------------");
    }
}