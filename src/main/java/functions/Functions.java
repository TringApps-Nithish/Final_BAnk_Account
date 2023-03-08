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
    private String getname = "Enter Account Holder Name : ";
    private String error = "Account Not Faound...";

    public void createAccount() {
        l.info(getname);
        String name = sc.next();
        l.info("Enter Account Number : ");
        int accountNumber = sc.nextInt();
        l.info("Enter Initial Account balance : ");
        double balance = sc.nextDouble();
        Assignvalues account = new Assignvalues(name, accountNumber, balance);
        accounts.put(accountNumber, account);
        l.info("Account created successfully.");
    }

    public void deposit() {
        l.info(getname);
        accountnumber = sc.nextInt();
        if (accounts.containsKey(accountnumber)) {
            l.info("Enter Amount to Deposit : ");
            amount = sc.nextDouble();
            Assignvalues accountdeposit = accounts.get(accountnumber);
            accountdeposit.deposit(amount);
            l.info("Deposit successful. New balance: " + accountdeposit.getBalance());
        } else
            l.info(error);

    }

    public void withdraw() {
        l.info(getname);
        accountnumber = sc.nextInt();
        if (accounts.containsKey(accountnumber)) {
            l.info("Enter Amount to Deposit : ");
            amount = sc.nextDouble();
            Assignvalues accountwithdraw = accounts.get(accountnumber);
            if (amount > accountwithdraw.getBalance())
                l.info("Insufficient Fund...");
            else {
                accountwithdraw.withdraw(amount);
                l.info("Deposit successful. New balance: " + accountwithdraw.getBalance());
            }
        } else
            l.info(error);
    }

    public void checkBalance() {
        l.info("Enter Account Number : ");
        accountnumber = sc.nextInt();

        if (accounts.containsKey(accountnumber)) {
            Assignvalues accountdisplay = accounts.get(accountnumber);
            l.info("Account Holder Name : " + accountdisplay.getName());
            l.info("Account Number : " + accountdisplay.getAccountNumber());
            l.info("Current balance : " + accountdisplay.getBalance());
        } else
            l.info(error);
    }

}