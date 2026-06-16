import java.util.Scanner;

public class StudentGrade2DArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int students = sc.nextInt();

        double[][] marks = new double[students][3];
        double[] percentage = new double[students];
        String[] grade = new String[students];

        for (int i = 0; i < students; i++) {

            for (int j = 0; j < 3; j++) {
                marks[i][j] = sc.nextDouble();
            }

            percentage[i] =
                    (marks[i][0] +
                            marks[i][1] +
                            marks[i][2]) / 3;

            if (percentage[i] >= 90)
                grade[i] = "A";
            else if (percentage[i] >= 75)
                grade[i] = "B";
            else if (percentage[i] >= 50)
                grade[i] = "C";
            else
                grade[i] = "F";
        }

        for (int i = 0; i < students; i++) {

            System.out.println(
                    percentage[i] + " "
                            + grade[i]);
        }

        sc.close();
    }
}