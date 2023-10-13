/* 
1. Create a simple banking system with customers, accounts, and transactions.

Here's a basic outline of the classes:
●	Customer: Represents a bank customer with attributes such as a customer ID, name, and contact information.
●	Account: Represents a bank account with attributes like an account number, account holder (linked to a Customer), balance, and methods for depositing and withdrawing money.
●	Bank: Acts as the main class that manages customers and their accounts. It provides methods to add customers, create accounts, perform transactions, and display account details. Also, this class should contains two small methods such as find customer and find account by their respective ID.
Note: Call the methods of depositing and withdrawing (In Account Class) while performing transaction in Bank Class.*/

import java.util.ArrayList;
import java.util.List;

class Customer {
    private int customerId;
    private String name;
    private String contactInfo;

    public Customer(int customerId, String name, String contactInfo) {
        this.customerId = customerId;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }
}

class Account {
    private int accountNumber;
    private Customer accountHolder;
    private double balance;

    public Account(int accountNumber, Customer accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }
}

class Bank {
    private List<Customer> customers;
    private List<Account> accounts;

    public Bank() {
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public Account createAccount(Customer accountHolder, double initialBalance) {
        int accountNumber = accounts.size() + 1;
        Account account = new Account(accountNumber, accountHolder, initialBalance);
        accounts.add(account);
        return account;
    }

    public Customer findCustomer(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    public Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    public void performTransaction(int accountNumber, String transactionType, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            if (transactionType.equals("deposit")) {
                account.deposit(amount);
            } else if (transactionType.equals("withdraw")) {
                account.withdraw(amount);
            } else {
                System.out.println("Invalid transaction type");
            }
        } else {
            System.out.println("Account not found");
        }
    }

    public void displayAccountDetails(int accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getAccountHolder().getName());
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Customer customer1 = new Customer(1, "Raju", "1234567890");
        Customer customer2 = new Customer(2, "Jhon", "0987654321");

        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        Account account1 = bank.createAccount(customer1, 1000);
        Account account2 = bank.createAccount(customer2, 500);

        bank.performTransaction(account1.getAccountNumber(), "deposit", 500);
        bank.performTransaction(account2.getAccountNumber(), "withdraw", 200);

        bank.displayAccountDetails(account1.getAccountNumber());
        bank.displayAccountDetails(account2.getAccountNumber());
    }
}