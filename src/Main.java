import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean playAgain = false;
        char playerA;
        char playerB;
        String trash = "";
        String response;
        Scanner in = new Scanner(System.in);
        do {
            // Collect playerA's move
            playerA = promptForMove(in, "Player A, enter your move R/P/S: ");
            // Collect playerB's move
            playerB = promptForMove(in, "Player B, enter your move R/P/S: ");
            // When playerA is "R"
            // When playerA is "P"
            // When playerA is "S"


            // Force the user to type Y or N
            do {
                System.out.print("Play again? Y/N: ");
                response = in.nextLine().trim();
            } while (!response.equalsIgnoreCase("Y") && !response.equalsIgnoreCase("N"));
            playAgain = response.equalsIgnoreCase("Y");
        } while (playAgain);

        in.close(); // Releases system resources by cleanly shutting down the Scanner
        System.out.println("Thanks for playing!");
    }

    // A private subclass to handle getting valid input from the players
    private static char promptForMove(Scanner in, String prompt) {
        while (true) { // will continue indefinitely until a "move" is returned
            System.out.print(prompt);
            String input = in.nextLine()
                    .trim() // gets rid of extra whitespace
                    .toUpperCase();
            if (input.isEmpty()) continue; // don't throw an error if the user just hits enter.

            char move = input.charAt(0); // grab the first character in case they enter something like "rock"
            if (move == 'R' || move == 'P' || move == 'S') {
                return move;
            }
        }
    }
}