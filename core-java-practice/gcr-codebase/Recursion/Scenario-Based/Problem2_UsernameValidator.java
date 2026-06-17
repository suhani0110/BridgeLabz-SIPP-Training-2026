public class Problem2_UsernameValidator {

    static boolean isValidUsername(String str, int index) {

        if (index == str.length())
            return true;

        char ch = str.charAt(index);

        if (ch < 'a' || ch > 'z')
            return false;

        return isValidUsername(str, index + 1);
    }

    public static void main(String[] args) {

        String username = "abcdxyz";

        System.out.println(isValidUsername(username, 0));
    }
}