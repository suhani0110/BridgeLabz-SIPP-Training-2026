import java.io.*;
import java.util.*;

public class SchoolResultPortal {

    public static void main(String[] args) {

        String inputFile = "students.txt";
        String outputFile = "reportcard.txt";

        try {
            // Read from input file
            Scanner scanner = new Scanner(new File(inputFile));

            // Append mode = true (prevents overwriting)
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(outputFile, true));

            writer.write("\n===== REPORT CARD =====\n");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split("\\s+");

                String name = data[0];
                int total = 0;
                int subjects = data.length - 1;

                for (int i = 1; i < data.length; i++) {
                    total += Integer.parseInt(data[i]);
                }

                double average = (double) total / subjects;

                writer.write("Name: " + name);
                writer.write("\nAverage Marks: " +
                        String.format("%.2f", average));
                writer.write("\nResult: " +
                        (average >= 40 ? "PASS" : "FAIL"));
                writer.write("\n------------------------\n");
            }

            scanner.close();
            writer.close();

            System.out.println("Report card generated successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file '" +
                    inputFile + "' not found.");

        } catch (IOException e) {
            System.out.println("File writing error: " +
                    e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Invalid marks format in input file.");
        }
    }
}