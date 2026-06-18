import java.util.Scanner;

public class HospitalBillingSystem {

    static int[] bills = {1000, 2500, 3200};

    public static void payBill(double balance, double amount)
            throws InsufficientFundsException {

        if (balance < amount) {
            throw new InsufficientFundsException("Payment failed! Insufficient Funds.");
        }

        System.out.println("Payment Successful.");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter patient index: ");
            int index = Integer.parseInt(sc.nextLine());

            System.out.print("Enter number of items: ");
            int items = Integer.parseInt(sc.nextLine());

            int perItemCost = bills[index] / items;

            System.out.println("Per Item Cost = " + perItemCost);

            System.out.print("Enter account balance: ");
            double balance = Double.parseDouble(sc.nextLine());

            payBill(balance, bills[index]);

        }

        catch (ArithmeticException e) {
            System.out.println("Bill cannot have zero items.");
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid patient index.");
        }

        catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers.");
        }

        catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}