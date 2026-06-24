public class UniversityDemo {

    public static void main(String[] args) {

        GradStudent grad =
                new GradStudent(
                        "Nandini",
                        22,
                        "ST101",
                        9.2,
                        "Machine Learning");

        System.out.println(grad);

        System.out.println("\nIS-A Relationship");

        System.out.println(
                grad instanceof GradStudent);

        System.out.println(
                grad instanceof Student);

        System.out.println(
                grad instanceof Person);
    }
}