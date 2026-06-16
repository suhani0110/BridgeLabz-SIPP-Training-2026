import java.util.Scanner;

public class RockPaperScissors {

    static String computerChoice() {

        int choice =
                (int)(Math.random() * 3);

        if (choice == 0) return "Rock";
        if (choice == 1) return "Paper";

        return "Scissors";
    }

    static String winner(
            String user,
            String computer) {

        if (user.equals(computer))
            return "Draw";

        if ((user.equals("Rock")
                && computer.equals("Scissors"))
                ||
                (user.equals("Paper")
                        && computer.equals("Rock"))
                ||
                (user.equals("Scissors")
                        && computer.equals("Paper")))
            return "User";

        return "Computer";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int games = sc.nextInt();

        int userWins = 0;
        int computerWins = 0;

        for (int i = 1; i <= games; i++) {

            String user = sc.next();

            String computer =
                    computerChoice();

            String result =
                    winner(user, computer);

            if (result.equals("User"))
                userWins++;

            else if
            (result.equals("Computer"))
                computerWins++;

            System.out.println(
                    user + "\t"
                            + computer + "\t"
                            + result);
        }

        System.out.println(
                "User Win % = "
                        + (userWins * 100.0 / games));

        System.out.println(
                "Computer Win % = "
                        + (computerWins * 100.0 / games));

        sc.close();
    }
}