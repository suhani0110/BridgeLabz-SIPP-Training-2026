import java.util.Scanner;

public class CharacterFrequencyNestedLoop {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();

        char[] chars = text.toCharArray();
        int[] frequency = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {

            frequency[i] = 1;

            if (chars[i] == '0')
                continue;

            for (int j = i + 1; j < chars.length; j++) {

                if (chars[i] == chars[j]) {

                    frequency[i]++;
                    chars[j] = '0';
                }
            }
        }

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] != '0') {
                System.out.println(chars[i] +
                        " : " + frequency[i]);
            }
        }

        sc.close();
    }
}