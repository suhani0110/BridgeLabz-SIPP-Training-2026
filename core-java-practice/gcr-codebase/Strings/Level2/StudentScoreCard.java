import java.util.Scanner;

public class StudentScoreCard {

    static int[][] generateScores(int students) {

        int[][] scores =
                new int[students][3];

        for (int i = 0; i < students; i++) {

            for (int j = 0; j < 3; j++) {

                scores[i][j] =
                        10 + (int)(Math.random() * 90);
            }
        }

        return scores;
    }

    static String grade(double percentage) {

        if (percentage >= 90)
            return "A";

        if (percentage >= 75)
            return "B";

        if (percentage >= 50)
            return "C";

        return "F";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int students = sc.nextInt();

        int[][] marks =
                generateScores(students);

        System.out.println(
                "Phy Chem Math Total Avg % Grade");

        for (int i = 0; i < students; i++) {

            int total =
                    marks[i][0]
                            + marks[i][1]
                            + marks[i][2];

            double avg = total / 3.0;

            double percentage =
                    Math.round(avg * 100.0) / 100.0;

            System.out.println(
                    marks[i][0] + " "
                            + marks[i][1] + " "
                            + marks[i][2] + " "
                            + total + " "
                            + avg + " "
                            + percentage + " "
                            + grade(percentage));
        }

        sc.close();
    }
}