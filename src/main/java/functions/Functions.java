package functions;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.Scanner;

public class Functions {
    Logger l = Logger.getLogger("Operation");
    Scanner sc = new Scanner(System.in);
    int accountBalance;

    public void deposit() {
        l.info("\nEnter Amount You Want To Deposit : ");
        int depositAmount = sc.nextInt();
        accountBalance += depositAmount;
    }

    public void withdraw() {
        l.info("\nEnter Amount You Want To WithDraw : ");
        int withdrawAmount = sc.nextInt();
        accountBalance -= withdrawAmount;
    }

    public void balance() {
        l.log(Level.INFO, () -> "\nYour Current Balance : " + accountBalance);
    }

}
