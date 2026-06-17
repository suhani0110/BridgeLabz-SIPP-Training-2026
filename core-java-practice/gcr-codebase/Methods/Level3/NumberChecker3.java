import java.util.Scanner;

public class NumberChecker3 {

    public static int[] storeDigits(int number) {

        String str = String.valueOf(number);
        int[] digits = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }

        return digits;
    }

    public static int[] reverseArray(int[] digits) {

        int[] reverse = new int[digits.length];

        for (int i = 0; i < digits.length; i++) {
            reverse[i] = digits[digits.length - 1 - i];
        }

        return reverse;
    }

    public static boolean compareArrays(int[] arr1, int[] arr2) {

        if (arr1.length != arr2.length)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }

        return true;
    }

    public static boolean isPalindrome(int[] digits) {

        return compareArrays(digits, reverseArray(digits));
    }

    public static boolean isDuckNumber(int[] digits) {

        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Number: ");
        int number = sc.nextInt();

        int[] digits = storeDigits(number);

        System.out.println("Palindrome = " + isPalindrome(digits));
        System.out.println("Duck Number = " + isDuckNumber(digits));

        sc.close();
    }
}