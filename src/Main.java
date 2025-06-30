import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean playAgain = false;
        String playerA = "";
        String playerB = "";
        String trash = "";
        String response;
        Scanner in = new Scanner(System.in);
        do {


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
}