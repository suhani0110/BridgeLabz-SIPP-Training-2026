import java.util.Scanner;

public class BMIReport {

    static String[] calculateBMI(double weight, double heightCm) {

        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);

        String status;

        if (bmi < 18.5)
            status = "Underweight";
        else if (bmi < 25)
            status = "Normal";
        else if (bmi < 30)
            status = "Overweight";
        else
            status = "Obese";

        return new String[]{
                String.valueOf(heightCm),
                String.valueOf(weight),
                String.format("%.2f", bmi),
                status
        };
    }

    static String[][] generateReport(double[][] persons) {

        String[][] report = new String[10][4];

        for (int i = 0; i < 10; i++) {
            report[i] = calculateBMI(persons[i][0], persons[i][1]);
        }

        return report;
    }

    static void display(String[][] report) {

        System.out.printf("%-10s %-10s %-10s %-15s\n",
                "Height", "Weight", "BMI", "Status");

        for (String[] row : report) {
            System.out.printf("%-10s %-10s %-10s %-15s\n",
                    row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double[][] persons = new double[10][2];

        for (int i = 0; i < 10; i++) {
            persons[i][0] = sc.nextDouble();
            persons[i][1] = sc.nextDouble();
        }

        display(generateReport(persons));

        sc.close();
    }
}