import java.util.Scanner;

public class ChocolateDistribution {

    public static int[] findRemainderAndQuotient(int numberOfChocolates, int numberOfChildren) {

        int chocolatesPerChild = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;

        return new int[]{chocolatesPerChild, remainingChocolates};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of chocolates: ");
        int chocolates = sc.nextInt();

        System.out.print("Enter number of children: ");
        int children = sc.nextInt();

        if (children == 0) {
            System.out.println("Number of children cannot be zero.");
        } else {

            int[] result = findRemainderAndQuotient(chocolates, children);

            System.out.println("Each child gets = " + result[0] + " chocolates");
            System.out.println("Remaining chocolates = " + result[1]);
        }

        sc.close();
    }
}