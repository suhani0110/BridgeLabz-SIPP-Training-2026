import java.util.Scanner;

public class VowelConsonantCount {

    static String check(char ch) {

        ch = Character.toLowerCase(ch);

        if ("aeiou".indexOf(ch) >= 0)
            return "Vowel";

        if (Character.isLetter(ch))
            return "Consonant";

        return "Not a Letter";
    }

    static int[] countVC(String text) {

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {

            String result =
                    check(text.charAt(i));

            if (result.equals("Vowel"))
                vowels++;

            else if (result.equals("Consonant"))
                consonants++;
        }

        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        int[] result = countVC(text);

        System.out.println(
                "Vowels = " + result[0]);

        System.out.println(
                "Consonants = " + result[1]);

        sc.close();
    }
}