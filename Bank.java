package com.example;
import java.util.*;

public class Bank {

    private TreeMap<Integer, Account> accounts;
    private Scanner scanner;

    public Bank() {
        accounts = new TreeMap<>();
        scanner = new Scanner(System.in);
    }

    public void createAccount() {
        System.out.println("Enter account name: ");
        String name = scanner.nextLine();

        System.out.println("Enter account number: ");
        int accountNumber = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter account balance: ");
        double balance = Double.parseDouble(scanner.nextLine());

        Account account = new Account(name, accountNumber, balance);
        accounts.put(accountNumber, account);

        System.out.println("Account created successfully.");
    }

    public void deposit() {
        System.out.println("Enter account number: ");
        int accountNumber = Integer.parseInt(scanner.nextLine());

        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Enter amount to deposit: ");
        double amount = Double.parseDouble(scanner.nextLine());

        Account account = accounts.get(accountNumber);
        account.deposit(amount);

        System.out.println("Deposit successful. New balance: " + account.getBalance());
    }

    public void withdraw() {
        System.out.println("Enter account number: ");
        int accountNumber = Integer.parseInt(scanner.nextLine());

        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Enter amount to withdraw: ");
        double amount = Double.parseDouble(scanner.nextLine());

        Account account = accounts.get(accountNumber);

        if (!account.withdraw(amount)) {
            System.out.println("Insufficient funds.");
            return;
        }

        System.out.println("Withdrawal successful. New balance: " + account.getBalance());
    }

    public void checkBalance() {
        System.out.println("Enter account number: ");
        int accountNumber = Integer.parseInt(scanner.nextLine());

        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found.");
            return;
        }

        Account account = accounts.get(accountNumber);
        System.out.println("Current balance: " + account.getBalance());
    }

    public void displayAllAccounts() {
        System.out.println("List of all accounts:");

        for (Map.Entry<Integer, Account> entry : accounts.entrySet()) {
            int accountNumber = entry.getKey();
            Account account = entry.getValue();
            System.out.println(accountNumber + ": " + account.getName() + " (" + account.getBalance() + ")");
        }
    }

    public void run() {
        while (true) {
            System.out.println();
            System.out.println("1. Create account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check balance");
            System.out.println("5. Display all accounts");
            System.out.println("6. Exit");

            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    displayAllAccounts();
                    break;
                case 6:
                    scanner.close();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.run();
    }
}
 class Account {
    private String name;
    private int accountNumber;
    private double balance;

    public Account(String name, int accountNumber, double balance) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
