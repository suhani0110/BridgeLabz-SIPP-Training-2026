import java.util.Scanner;

public class NestedTryCatchDemo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = {20, 40, 60, 80};

        System.out.print("Enter index: ");
        int index = sc.nextInt();

        System.out.print("Enter divisor: ");
        int divisor = sc.nextInt();

        try {

            try {

                int value = arr[index];

                try {

                    System.out.println("Result = " + value / divisor);

                } catch (ArithmeticException e) {

                    System.out.println("Cannot divide by zero!");

                }

            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("Invalid array index!");

            }

        } finally {

            sc.close();

        }
    }
}