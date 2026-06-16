import java.util.Scanner;

public class NumberFormatDemo {

    static void generateException(String text) {

        int number = Integer.parseInt(text);

        System.out.println(number);
    }

    static void handleException(String text) {

        try {

            int number = Integer.parseInt(text);

            System.out.println(number);

        } catch (NumberFormatException e) {

            System.out.println(
                    "NumberFormatException Handled");

        } catch (RuntimeException e) {

            System.out.println(
                    "RuntimeException Handled");
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