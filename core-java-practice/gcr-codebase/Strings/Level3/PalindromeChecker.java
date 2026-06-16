import java.util.Scanner;

public class PalindromeChecker {

    static boolean method1(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {

            if (text.charAt(start) != text.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }

    static boolean recursive(String text,
                             int start,
                             int end) {

        if (start >= end)
            return true;

        if (text.charAt(start) != text.charAt(end))
            return false;

        return recursive(text,
                start + 1,
                end - 1);
    }

    static String reverse(String text) {

        String rev = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            rev += text.charAt(i);
        }

        return rev;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        boolean result1 = method1(text);
        boolean result2 =
                recursive(text, 0,
                        text.length() - 1);

        boolean result3 =
                text.equals(reverse(text));

        System.out.println("Method1 = " + result1);
        System.out.println("Method2 = " + result2);
        System.out.println("Method3 = " + result3);

        sc.close();
    }
}