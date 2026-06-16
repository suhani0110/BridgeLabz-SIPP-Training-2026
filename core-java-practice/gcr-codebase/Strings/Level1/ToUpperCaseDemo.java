import java.util.Scanner;

public class ToUpperCaseDemo {

    static String convertUpper(String text) {

        String result = "";

        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                ch = (char)(ch - 32);
            }

            result += ch;
        }

        return result;
    }

    static boolean compareStrings(String a,
                                  String b) {

        if (a.length() != b.length())
            return false;

        for (int i = 0; i < a.length(); i++) {

            if (a.charAt(i) != b.charAt(i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String custom = convertUpper(text);
        String builtin = text.toUpperCase();

        System.out.println(custom);
        System.out.println(builtin);

        System.out.println(
                compareStrings(custom, builtin));

        sc.close();
    }
}