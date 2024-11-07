package BankingApplication;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private double balance;
    private String address;
    private String contactNumber;
    private List<String> transactionHistory;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, String accountType, String address, String contactNumber) {
        if (!isValidAccountNumber(accountNumber)) {
            throw new IllegalArgumentException("Account Number must be between 8 and 16 digits");
        }
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.address = address;
        this.contactNumber = contactNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    // Validation method for account number
    private boolean isValidAccountNumber(String accountNumber) {
        return accountNumber.matches("\\d{8,16}");
    }

    // Getter methods for account information
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public String getAccountType() {
        return accountType;
    }
    public double getBalance() {
        return balance;
    }
    public String getContactNumber() {
        return contactNumber;
    }

    // Setter methods
    public void setAddress(String address) {
        this.address = address;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }

    // Transfer money
    public void transfer(BankAccount toAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            transactionHistory.add("Transferred " + amount + " to " + toAccount.getAccountNumber());
            toAccount.transactionHistory.add("Received " + amount + " from " + this.getAccountNumber());
        } else {
            System.out.println("Transfer failed. Insufficient balance or invalid amount.");
        }
    }

    // Display account information
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: " + balance);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contactNumber);
    }

    // Display transaction history
    public void displayTransactionHistory() {
        System.out.println("Transaction history for Account: " + accountNumber);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
