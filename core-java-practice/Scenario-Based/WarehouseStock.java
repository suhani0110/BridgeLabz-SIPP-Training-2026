import java.util.Scanner;

public class WarehouseStock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] stock = new int[n];

        for (int i = 0; i < n; i++) {
            stock[i] = sc.nextInt();
        }

        int min = stock[0];
        int max = stock[0];
        int total = 0;

        for (int num : stock) {
            if (num < min)
                min = num;

            if (num > max)
                max = num;

            total += num;
        }

        System.out.println("Minimum Stock = " + min);
        System.out.println("Maximum Stock = " + max);
        System.out.println("Total Stock = " + total);

        boolean duplicateFound = false;

        System.out.println("Duplicate Values:");

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stock[i] == stock[j]) {
                    duplicateFound = true;
                    System.out.println(stock[i]);
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No duplicates found");
        }

        System.out.print("Enter rotation k: ");
        int k = sc.nextInt();

        k = k % n;

        int[] rotated = new int[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = stock[i];
        }

        System.out.println("Rotated Array:");

        for (int num : rotated) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}