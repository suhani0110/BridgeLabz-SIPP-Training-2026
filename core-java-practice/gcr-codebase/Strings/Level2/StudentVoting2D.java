import java.util.Random;

public class StudentVoting2D {

    static int[] generateAges(int n) {

        Random random = new Random();

        int[] ages = new int[n];

        for (int i = 0; i < n; i++) {
            ages[i] = random.nextInt(90);
        }

        return ages;
    }

    public static void main(String[] args) {

        int[] ages = generateAges(10);

        System.out.println("Age\tCanVote");

        for (int age : ages) {

            boolean canVote = age >= 18;

            System.out.println(age
                    + "\t"
                    + canVote);
        }
    }
}