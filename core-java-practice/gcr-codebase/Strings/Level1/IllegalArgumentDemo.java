import java.util.Scanner;

public class IllegalArgumentDemo {

    static void generateException(String text) {

        System.out.println(text.substring(5, 2));
    }

    static void handleException(String text) {

        try {

            System.out.println(text.substring(5, 2));

        } catch (RuntimeException e) {

            System.out.println(
                    "Illegal Argument Exception Handled");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.next();

        // generateException(text);

        handleException(text);

        sc.close();
    }
}