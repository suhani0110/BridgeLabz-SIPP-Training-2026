import java.util.Scanner;

public class NumberChecker1 {

    public static int countDigits(int number) {

        int count = 0;

        while (number > 0) {
            count++;
            number /= 10;
        }

        return count;
    }

    public static int[] storeDigits(int number) {

        int count = countDigits(number);

        int[] digits = new int[count];

        for (int i = count - 1; i >= 0; i--) {

            digits[i] = number % 10;
            number /= 10;

        }

        return digits;
    }

    public static boolean isDuckNumber(int[] digits) {

        for (int i = 1; i < digits.length; i++) {

            if (digits[i] == 0)
                return true;

        }

        return false;
    }

    public static boolean isArmstrong(int number, int[] digits) {

        int sum = 0;

        for (int digit : digits)
            sum += Math.pow(digit, digits.length);

        return sum == number;
    }

    public static int[] largestSecondLargest(int[] digits) {

        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int digit : digits) {

            if (digit > largest) {

                second = largest;
                largest = digit;

            }
            else if (digit > second && digit != largest) {

                second = digit;

            }

        }

        return new int[]{largest, second};
    }

    public static int[] smallestSecondSmallest(int[] digits) {

        int smallest = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int digit : digits) {

            if (digit < smallest) {

                second = smallest;
                smallest = digit;

            }
            else if (digit < second && digit != smallest) {

                second = digit;

            }

        }

        return new int[]{smallest, second};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number: ");
        int number = sc.nextInt();

        int[] digits = storeDigits(number);

        System.out.println("Digits Count = " + digits.length);
        System.out.println("Duck Number = " + isDuckNumber(digits));
        System.out.println("Armstrong = " + isArmstrong(number, digits));

        int[] large = largestSecondLargest(digits);
        int[] small = smallestSecondSmallest(digits);

        System.out.println("Largest = " + large[0]);
        System.out.println("Second Largest = " + large[1]);
        System.out.println("Smallest = " + small[0]);
        System.out.println("Second Smallest = " + small[1]);

        sc.close();
    }
}