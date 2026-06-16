import java.util.Scanner;

public class DeckOfCards {

    static String[] initializeDeck() {

        String[] suits =
                {"Hearts","Diamonds",
                        "Clubs","Spades"};

        String[] ranks =
                {"2","3","4","5","6","7",
                        "8","9","10","Jack",
                        "Queen","King","Ace"};

        String[] deck =
                new String[52];

        int index = 0;

        for (String suit : suits) {

            for (String rank : ranks) {

                deck[index++] =
                        rank + " of " + suit;
            }
        }

        return deck;
    }

    static void shuffle(String[] deck) {

        int n = deck.length;

        for (int i = 0; i < n; i++) {

            int randomCard =
                    i + (int)(Math.random()
                            * (n - i));

            String temp = deck[i];
            deck[i] = deck[randomCard];
            deck[randomCard] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int players = sc.nextInt();
        int cardsPerPlayer = sc.nextInt();

        String[] deck =
                initializeDeck();

        shuffle(deck);

        if (players * cardsPerPlayer > 52) {

            System.out.println(
                    "Cannot distribute cards");
            return;
        }

        String[][] hands =
                new String[players]
                        [cardsPerPlayer];

        int cardIndex = 0;

        for (int i = 0; i < players; i++) {

            for (int j = 0;
                 j < cardsPerPlayer;
                 j++) {

                hands[i][j] =
                        deck[cardIndex++];
            }
        }

        for (int i = 0; i < players; i++) {

            System.out.println(
                    "\nPlayer " + (i + 1));

            for (int j = 0;
                 j < cardsPerPlayer;
                 j++) {

                System.out.println(
                        hands[i][j]);
            }
        }

        sc.close();
    }
}