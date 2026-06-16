import java.util.Scanner;

public class ShortestLongestWord {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] words =
                sc.nextLine().split(" ");

        String shortest = words[0];
        String longest = words[0];

        for (String word : words) {

            if (word.length() < shortest.length())
                shortest = word;

            if (word.length() > longest.length())
                longest = word;
        }

        System.out.println(
                "Shortest Word = " + shortest);

        System.out.println(
                "Longest Word = " + longest);

        sc.close();
    }
}