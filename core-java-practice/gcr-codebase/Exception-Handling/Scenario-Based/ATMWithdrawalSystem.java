import java.util.Scanner;

public class ATMWithdrawalSystem {

    static double balance = 5000;

    public static void withdraw(double amount)
            throws InsufficientBalanceException {

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Withdrawal Amount: ₹" + amount +
                            "\nAvailable Balance: ₹" + balance);
        }

        balance -= amount;

        System.out.println("Withdrawal Successful.");
        System.out.println("Remaining Balance = ₹" + balance);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter amount to withdraw: ");

        double amount = sc.nextDouble();

        try {

            withdraw(amount);

        }

        catch (InsufficientBalanceException e) {

            System.out.println(e.getMessage());

        }

        sc.close();

    }

}