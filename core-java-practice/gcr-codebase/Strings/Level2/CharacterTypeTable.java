import java.util.Scanner;

public class CharacterTypeTable {

    static String getType(char ch) {

        ch = Character.toLowerCase(ch);

        if ("aeiou".indexOf(ch) >= 0)
            return "Vowel";

        if (Character.isLetter(ch))
            return "Consonant";

        return "Not a Letter";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        System.out.println("Character\tType");

        for (int i = 0; i < text.length(); i++) {

            System.out.println(
                    text.charAt(i)
                            + "\t\t"
                            + getType(text.charAt(i)));
        }

        sc.close();
    }
}