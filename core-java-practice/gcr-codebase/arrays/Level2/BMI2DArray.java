import java.util.Scanner;

public class BMI2DArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int persons = sc.nextInt();

        double[][] personData = new double[persons][3];
        String[] status = new String[persons];

        for (int i = 0; i < persons; i++) {

            personData[i][0] = sc.nextDouble(); // weight
            personData[i][1] = sc.nextDouble(); // height

            while (personData[i][0] <= 0 ||
                    personData[i][1] <= 0) {

                System.out.println("Enter Positive Values");

                personData[i][0] = sc.nextDouble();
                personData[i][1] = sc.nextDouble();
            }

            personData[i][2] =
                    personData[i][0] /
                            Math.pow(personData[i][1] / 100, 2);

            if (personData[i][2] < 18.5)
                status[i] = "Underweight";
            else if (personData[i][2] < 25)
                status[i] = "Normal";
            else if (personData[i][2] < 30)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        for (int i = 0; i < persons; i++) {

            System.out.println(
                    personData[i][0] + " "
                            + personData[i][1] + " "
                            + personData[i][2] + " "
                            + status[i]);
        }

        sc.close();
    }
}