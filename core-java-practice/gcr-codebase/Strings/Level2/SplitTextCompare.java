import java.util.Scanner;

public class SplitTextCompare {

    public static String[] splitText(String text) {

        int words = 1;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                words++;
        }

        String[] result = new String[words];

        int start = 0;
        int index = 0;

        for (int i = 0; i <= text.length(); i++) {

            if (i == text.length() || text.charAt(i) == ' ') {

                result[index++] = text.substring(start, i);
                start = i + 1;
            }
        }

        return result;
    }

    public static boolean compare(String[] a, String[] b) {

        if (a.length != b.length)
            return false;

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i]))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        String[] custom = splitText(text);
        String[] builtin = text.split(" ");

        System.out.println("Arrays Equal = "
                + compare(custom, builtin));

        sc.close();
    }
}