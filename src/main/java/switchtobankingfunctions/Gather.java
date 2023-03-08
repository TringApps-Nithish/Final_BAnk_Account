package switchtobankingfunctions;

import functions.Functions;

import java.util.logging.Logger;
import java.util.Scanner;

public class Gather {
    private Scanner sc = new Scanner(System.in);
    private Logger l = Logger.getLogger("Getter");
    private Functions nextmove = new Functions();

    public void run() {
        while (true) {
            l.info("\n 1. Create account\n 2. Deposit\n 3. Withdraw\n 4. Check balance\n 5 Enextmoveit");
            l.info("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> nextmove.createAccount();
                case 2 -> nextmove.deposit();
                case 3 -> nextmove.withdraw();
                case 4 -> nextmove.checkBalance();
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
