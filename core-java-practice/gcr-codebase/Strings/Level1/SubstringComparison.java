import java.util.Scanner;

public class SubstringComparison {

    public static String getSubstring(String text,
                                      int start,
                                      int end) {

        String result = "";

        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }

        return result;
    }

    public static boolean compareStrings(String a,
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

        String text = sc.next();
        int start = sc.nextInt();
        int end = sc.nextInt();

        String custom = getSubstring(text, start, end);
        String builtin = text.substring(start, end);

        System.out.println("Custom = " + custom);
        System.out.println("BuiltIn = " + builtin);
        System.out.println("Equal = " +
                compareStrings(custom, builtin));

        sc.close();
    }
}