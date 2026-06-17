public class Palindrome {

    static boolean check(String str, int start, int end) {
        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return check(str, start + 1, end - 1);
    }

    public static void main(String[] args) {
        String s = "madam";

        if (check(s, 0, s.length() - 1))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}