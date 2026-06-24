public class LibraryDemo {

    public static void main(String[] args) {

        Author author =
                new Author(
                        "Java Programming",
                        2025,
                        "James Gosling",
                        "Creator of Java");

        author.displayInfo();
    }
}