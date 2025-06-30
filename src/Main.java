import java.util.Scanner;
import java.util.Map;

public class Main {

    private static final Map<String,Character> VALID_MOVES = Map.of(
            "R", 'R',
            "ROCK", 'R',
            "P", 'P',
            "PAPER", 'P',
            "S", 'S',
            "SCISSORS", 'S'
    );

    private static final Map<String,Boolean> VALID_ANSWERS = Map.of(
            "Y", true,
            "YES", true,
            "N", false,
            "NO", false
    );

    public static void main(String[] args) {
        boolean playAgain = false;
        char playerA;
        char playerB;

        Scanner in = new Scanner(System.in);

        do {
            // Collect playerA's move
            playerA = promptForMove(in, "Player A, enter your move R/P/S: ");
            // Collect playerB's move
            playerB = promptForMove(in, "Player B, enter your move R/P/S: ");

            if (playerA == 'R') {
                if (playerB == 'R') {
                    System.out.println("Rock vs Rock. It's a tie!");
                } else if (playerB == 'P') {
                    System.out.println("Paper covers Rock. Player B wins!");
                } else { // playerB == 'S'
                    System.out.println("Rock breaks Scissors. Player A wins!");
                }
            } else if (playerA == 'P') {
                if (playerB == 'R') {
                    System.out.println("Paper covers Rock.  Player A wins!");
                } else if (playerB == 'P') {
                    System.out.println("Paper vs Paper. It's a tie!");
                } else {  // playerB == 'S'
                    System.out.println("Scissors cuts Paper.  Player B wins!");
                }
            } else { // playerA == 'S'
                if (playerB == 'R') {
                    System.out.println("Rock breaks Scissors.  Player B wins!");
                } else if (playerB == 'P') {
                    System.out.println("Scissors cuts Paper.  Player A wins!");
                } else { // playerB == 'S'
                    System.out.println("Scissors vs Scissors.  It's a tie!");
                }
            }

            playAgain = promptForPlayAgain(in);

        } while (playAgain);

        in.close(); // Releases system resources by cleanly shutting down the Scanner
        System.out.println("Thanks for playing!");
    }

    // A private helper method to handle getting valid input from the players
    private static char promptForMove(Scanner in, String prompt) {
        // Force the user to enter a valid move
        while (true) {
            // Print out a prompt for the user to enter their move
            System.out.print(prompt);

            // Grab the input, trim excess whitespace, and make it uppercase
            String userInput = in.nextLine()
                    .trim()
                    .toUpperCase();

            // Don't error out if the user just hits "enter"
            if (userInput.isEmpty()) { continue; }

            // Look up the exact input in our map
            Character move = VALID_MOVES.get(userInput);

            // If the move wasn't listed as a key in the map, the value (ie, "move") will be null.
            // Here we break out of the loop if the user gave a valid move.
            if (move != null) {
                return move;
            }

            // Otherwise it was an invalid move
            System.out.println(userInput + " is an invalid move. " +
                    "Please type R, P, S or rock/paper/scissors.");
        }
    }


    // A private helper method to handle getting a Y or N for playing again
    private static boolean promptForPlayAgain(Scanner in) {
        // Force the user to enter a valid answer
        while (true) {
            System.out.print("Play again? Y/N: ");
            // Take the user's answer, trim off extra whitespace, and make it uppercase.
            String userInput = in.nextLine()
                    .trim()
                    .toUpperCase();

            // don't throw an error if the user just hits enter.
            if (userInput.isEmpty()) continue;

            // Use our map of valid choices to determine if the user gave a valid answer
            Boolean userChoice = VALID_ANSWERS.get(userInput);

            if (userChoice != null) { // the user gave a valid choice
                return userChoice;
            }

            System.out.println( userInput + " is an invalid answer. Please type Y or N." );
        }
    }
}