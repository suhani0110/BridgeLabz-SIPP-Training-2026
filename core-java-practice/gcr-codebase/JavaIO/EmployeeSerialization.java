import java.io.*;
import java.util.Scanner;

class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    int employeeId;
    String name;
    String department;
    double salary;

    Employee(int employeeId, String name,
             String department, double salary) {

        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}

public class EmployeeSerialization {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // Input Employee Data
            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, department, salary);

            // Serialization
            ObjectOutputStream oos =
                    new ObjectOutputStream(
                            new FileOutputStream("employee.ser"));

            oos.writeObject(emp);
            oos.close();

            System.out.println("\nEmployee object serialized successfully.");

            // Deserialization
            ObjectInputStream ois =
                    new ObjectInputStream(
                            new FileInputStream("employee.ser"));

            Employee recoveredEmployee =
                    (Employee) ois.readObject();

            ois.close();

            // Display recovered data
            System.out.println("\nRecovered Employee Information");
            System.out.println("Employee ID : "
                    + recoveredEmployee.employeeId);
            System.out.println("Name        : "
                    + recoveredEmployee.name);
            System.out.println("Department  : "
                    + recoveredEmployee.department);
            System.out.println("Salary      : "
                    + recoveredEmployee.salary);

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
        }

        sc.close();
    }
}