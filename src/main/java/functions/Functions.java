package functions;

import java.util.logging.Logger;

import assigingvalues.*;

import java.util.*;

public class Functions {
    private TreeMap<Integer, Assignvalues> accounts = new TreeMap<>();
    private Scanner sc = new Scanner(System.in);
    private Logger l = Logger.getLogger("Functions");
    private int accountnumber;
    private double amount;

    public void createAccount() {
        l.info("Enter account name: ");
        String name = sc.next();
        l.info("Enter account number: ");
        int accountNumber = sc.nextInt();
        l.info("Enter account balance: ");
        double balance = sc.nextDouble();
        Assignvalues account = new Assignvalues(name, accountNumber, balance);
        accounts.put(accountNumber, account);
        l.info("Account created successfully.");
    }

    public void deposit() {
        l.info("Enter account number: ");
        accountnumber = sc.nextInt();
        if (accounts.containsKey(accountnumber)) {
            l.info("Enter amount to deposit: ");
            amount = sc.nextDouble();
            Assignvalues account = accounts.get(accountnumber);
            account.deposit(amount);
            l.info("Deposit successful. New balance: " + account.getBalance());
        } else
            l.info("Account not found.");

    }

    public void withdraw() {
        l.info("Enter account number: ");
        accountnumber = sc.nextInt();
        if (accounts.containsKey(accountnumber)) {
            l.info("Enter amount to deposit: ");
            amount = sc.nextDouble();
            Assignvalues account = accounts.get(accountnumber);
            if (amount > account.getBalance())
                l.info("Insufficient Fund...");
            else {
                account.withdraw(amount);
                l.info("Deposit successful. New balance: " + account.getBalance());
            }
        } else
            l.info("Account not found.");
    }

    public void checkBalance() {
        l.info("Enter account number: ");
        accountnumber = sc.nextInt();

        if (accounts.containsKey(accountnumber)) {
            Assignvalues account = accounts.get(accountnumber);
            l.info("Account Holder Name " + account.getName());
            l.info("Account Number: " + account.getAccountNumber());
            l.info("" + "Current balance: " + account.getBalance());
        } else
            l.info("Account not found.");
    }

}