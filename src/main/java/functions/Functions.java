package functions;

import assigingvalues.*;

import java.util.logging.Logger;
import java.util.*;

public class Functions {
    private TreeMap<Integer, Assignvalues> accounts = new TreeMap<>();
    private Scanner sc = new Scanner(System.in);
    private Logger l = Logger.getLogger("Functions");
    private int accountnumber;
    private double amount;
    private String getname = " Enter Account Holder Name : ";
    private String getaccountnumber = " Enter Account Number : ";
    private String error = "Account Not Faound...";

    public void createAccount() {
        l.info(getname);
        String name = sc.next();
        l.info(getaccountnumber);
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
        try {
            l.info(getname);
            accountnumber = sc.nextInt();
            if (accounts.containsKey(accountnumber)) {
                l.info("Enter Amount to Deposit : ");
                amount = sc.nextDouble();
                Assignvalues accountwithdraw = accounts.get(accountnumber);
                if (amount > accountwithdraw.getBalance())
                    throw new InsufficientFundException();

                else {
                    if (amount > 20000)
                        throw new OverAmountException();
                    else {
                        accountwithdraw.withdraw(amount);
                        l.info("WithDrawed successful. New balance: " + accountwithdraw.getBalance());
                    }
                }
            } else
                l.info(error);
        } catch (InsufficientFundException e) {
            l.info("Insufficient Funds....");
        } catch (OverAmountException e) {
            l.info("You can WithDraw Less than 20000 at a Time....");
        }
    }

    public void checkBalance() {
        l.info(getaccountnumber);
        accountnumber = sc.nextInt();

        if (accounts.containsKey(accountnumber)) {
            Assignvalues accountdisplay = accounts.get(accountnumber);
            l.info("\n Account Number : " + accountdisplay.getAccountNumber() + " Current balance : "
                    + accountdisplay.getBalance());
        } else
            l.info(error);
    }

    public void display() {
        l.info(getaccountnumber);
        accountnumber = sc.nextInt();

        if (accounts.containsKey(accountnumber)) {
            Assignvalues accountdisplay = accounts.get(accountnumber);
            l.info("----- Account Details -----");
            l.info("\n Account Holder Name : " + accountdisplay.getName() + "\n Account Number : "
                    + accountdisplay.getAccountNumber() + "\n Current balance : " + accountdisplay.getBalance());
        } else
            l.info(error);
    }
}