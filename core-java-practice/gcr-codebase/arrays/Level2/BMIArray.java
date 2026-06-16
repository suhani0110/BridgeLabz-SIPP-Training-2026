import java.util.Scanner;

public class BMIArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int persons = sc.nextInt();

        double[] weight = new double[persons];
        double[] height = new double[persons];
        double[] bmi = new double[persons];
        String[] status = new String[persons];

        for (int i = 0; i < persons; i++) {

            weight[i] = sc.nextDouble();
            height[i] = sc.nextDouble();

            bmi[i] = weight[i] /
                    Math.pow(height[i] / 100, 2);

            if (bmi[i] < 18.5)
                status[i] = "Underweight";
            else if (bmi[i] < 25)
                status[i] = "Normal";
            else if (bmi[i] < 30)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }

        for (int i = 0; i < persons; i++) {

            System.out.println("Person " + (i + 1));
            System.out.println("Height = " + height[i]);
            System.out.println("Weight = " + weight[i]);
            System.out.println("BMI = " + bmi[i]);
            System.out.println("Status = " + status[i]);
        }

        sc.close();
    }
}