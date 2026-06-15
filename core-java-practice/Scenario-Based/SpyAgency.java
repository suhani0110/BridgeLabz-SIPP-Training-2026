import java.util.Scanner;

public class SpyAgency {

    public static String reverse(String str) {
        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }

        return rev;
    }

    public static boolean isPalindrome(String str) {
        String rev = reverse(str);
        return str.equalsIgnoreCase(rev);
    }

    public static boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        int[] freq = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        for (int count : freq) {
            if (count != 0)
                return false;
        }

        return true;
    }

    public static char firstNonRepeating(String str) {

        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return '#';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter secret message: ");
        String message = sc.nextLine();

        System.out.println("Reversed Message = " + reverse(message));

        if (isPalindrome(message))
            System.out.println("Message is Palindrome");
        else
            System.out.println("Message is Not Palindrome");

        int vowels = 0;
        int consonants = 0;

        String lower = message.toLowerCase();

        for (int i = 0; i < lower.length(); i++) {

            char ch = lower.charAt(i);

            if (Character.isLetter(ch)) {

                if (ch == 'a' || ch == 'e' || ch == 'i' ||
                        ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels = " + vowels);
        System.out.println("Consonants = " + consonants);

        System.out.print("Enter intercepted message 1: ");
        String msg1 = sc.nextLine();

        System.out.print("Enter intercepted message 2: ");
        String msg2 = sc.nextLine();

        if (isAnagram(msg1, msg2))
            System.out.println("Messages are Anagrams");
        else
            System.out.println("Messages are Not Anagrams");

        char result = firstNonRepeating(message);

        if (result == '#')
            System.out.println("No non-repeating character found");
        else
            System.out.println("First Non-Repeating Character = " + result);

        sc.close();
    }
}