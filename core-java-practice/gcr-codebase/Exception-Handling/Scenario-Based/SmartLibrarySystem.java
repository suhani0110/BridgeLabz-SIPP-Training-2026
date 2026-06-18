public class SmartLibrarySystem {

    static String books[] = {"Java", "Python", null, "C++"};

    public static int getBookLength(int index) {

        try {

            return books[index].length();

        }

        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Invalid book index!");

            return -1;

        }

        catch (NullPointerException e) {

            System.out.println("Book entry is empty!");

            return -1;

        }

    }

    public static void main(String[] args) {

        System.out.println("Length = " + getBookLength(0));

        System.out.println("Length = " + getBookLength(2));

        System.out.println("Length = " + getBookLength(6));

    }

}