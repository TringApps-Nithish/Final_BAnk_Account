package getdate;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Logger;

import functions.Functions;
import setter.setter;

public class Getdate {
    Logger l = Logger.getLogger("Getdata");
    Scanner sc = new Scanner(System.in);
    private int choice = 0;
    TreeMap<Integer, Integer> addAccount = new TreeMap<>();
    Functions function = new Functions();

    public void getDate() {

        l.info(" Enter Your Account Number : ");
        int accountNumber = sc.nextInt();
        // l.info(" Enter Your Account Holder Name : ");
        // String holderName = sc.next();
        l.info(" Enter Your Account Balance : ");
        int balance = sc.nextInt();
        setter adduser = new setter(accountNumber, balance);
        addAccount.put(accountNumber, balance);
        l.info(" 1 -> Create Another Account 2 -> Banking ");
        int nextMove = sc.nextInt();
        if (nextMove == 1)
            getDate();
        else {
            while (choice != 4) {
                l.info(" Service Provided :- \n 1. Deposit \n 2. WithDraw \n 3. Balance \n 4. Exit  ");
                l.info(" Enter Your Choice : ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1 -> function.deposit();
                    case 2 -> function.withdraw();
                    case 3 -> function.balance();
                    case 4 -> {
                        l.info("Exiting ...");
                        l.info("/t----------------------------------------------");
                        l.info(" \n\n 1-> Do you want to Create Another Account (or) 2-> Exit Bank...");
                        int nextStep = sc.nextInt();
                        if (nextStep == 1)
                            getDate();
                        else
                            System.exit(0);
                    }
                    default -> l.info("Invalid Choice...");
                }
            }
        }
    }
}
