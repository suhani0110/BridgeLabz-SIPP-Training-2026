import java.util.Scanner;

public class ReverseNumberArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long number = sc.nextLong();
        long temp = number;

        int count = 0;

        while (temp != 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];

        temp = number;

        for (int i = 0; i < count; i++) {
            digits[i] = (int)(temp % 10);
            temp /= 10;
        }

        System.out.print("Reverse Number: ");

        for (int digit : digits) {
            System.out.print(digit);
        }

        sc.close();
    }
}