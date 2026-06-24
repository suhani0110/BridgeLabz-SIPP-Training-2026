public class Author extends Book {

    private String authorName;
    private String bio;

    public Author(String title,
                  int publicationYear,
                  String authorName,
                  String bio) {

        super(title, publicationYear);

        this.authorName = authorName;
        this.bio = bio;
    }

    public void displayInfo() {

        System.out.println("Title: " + title);
        System.out.println("Publication Year: "
                + publicationYear);
        System.out.println("Author: "
                + authorName);
        System.out.println("Bio: " + bio);
    }
}