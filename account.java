package account;

import java.util.ArrayList;

public class Account {
    private String dealerID;
    private String msisdn;
    private String mpin;
    private double balance;
    private String status;

    private ArrayList<String> transactionHistory = new ArrayList<>(); 

    public Account(String dealerID, String msisdn, String mpin, double balance, String status) {
        this.dealerID = dealerID;
        this.msisdn = msisdn;
        this.mpin = mpin;
        this.balance = balance;
        this.status = status;
        transactionHistory.add("Account created: Initial Balance: " + balance);
    }

    public boolean verifypin(String enteredpin) {
        return this.mpin.equals(entered pin);
    }

    public void deposit(double amount, String remarks) {
        this.balance += amount;
        transactionHistory.add("Deposit: Amount: " + amount + " Remarks: " + remarks);
    }

    public boolean withdraw(double amount, String remarks) {
        if (amount > this.balance) {
            return false;
        }
        this.balance -= amount;
        transactionHistory.add("Withdraw: Amount: " + amount + " Remarks: " + remarks);
        return true;
    }

    public void showAccountDetails() {
        System.out.println("Dealer ID: " + dealerID);
        System.out.println("MSISDN: " + msisdn);
        System.out.println("Balance: " + balance);
        System.out.println("Status: " + status);
    }

    public void showTransactionHistory() {
        System.out.println("Transaction History for Dealer ID " + dealerID + ":");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public double getBalance() {
        return this.balance;
    }

    public String getDealerID() {
        return this.dealerID;
    }
}
