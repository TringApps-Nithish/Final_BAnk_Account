package getter;

import functions.Functions;

import java.util.logging.Logger;
import java.util.Scanner;

public class Getter {
    private Scanner sc = new Scanner(System.in);
    private Logger l = Logger.getLogger("Getter");
    private Functions x = new Functions();

    public void run() {
        while (true) {
            l.info("\n 1. Create account\n 2. Deposit\n 3. Withdraw\n 4. Check balance\n 5 Exit");
            l.info("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> x.createAccount();
                case 2 -> x.deposit();
                case 3 -> x.withdraw();
                case 4 -> x.checkBalance();
                case 5 -> {
                    sc.close();
                    l.info("Exiting...");
                    return;
                }
                default -> l.info("Invalid choice.");

            }
        }
    }
}
