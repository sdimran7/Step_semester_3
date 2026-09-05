import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    static String playRound(String player, String computer) {

        if (player.equals(computer)) {
            return "Draw";
        }

        if ((player.equals("Rock") && computer.equals("Scissors")) ||
            (player.equals("Paper") && computer.equals("Rock")) ||
            (player.equals("Scissors") && computer.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        // Ask user for number of rounds
        System.out.print("Enter number of rounds: ");
        int rounds = sc.nextInt();
        sc.nextLine(); // clear newline

        // Arrays based on number of rounds
        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("\n==============================================");
        System.out.println("          ROCK - PAPER - SCISSORS");
        System.out.println("==============================================");

        for (int i = 0; i < rounds; i++) {

            System.out.println("\nRound " + (i + 1));
            System.out.println("----------------------------------------------");

            System.out.print("Enter your move (Rock/Paper/Scissors): ");
            String player = sc.nextLine().trim();

            // Convert input to proper format
            if (!player.isEmpty()) {
                player = player.substring(0, 1).toUpperCase()
                        + player.substring(1).toLowerCase();
            }

            // Validate input
            while (!player.equals("Rock") &&
                   !player.equals("Paper") &&
                   !player.equals("Scissors")) {

                System.out.print("Invalid input! Enter Rock, Paper or Scissors: ");
                player = sc.nextLine().trim();

                if (!player.isEmpty()) {
                    player = player.substring(0, 1).toUpperCase()
                            + player.substring(1).toLowerCase();
                }
            }

            // Generate computer move
            String computer = moves[random.nextInt(3)];

            // Find result
            String result = playRound(player, computer);

            // Store round details
            playerMoves[i] = player;
            computerMoves[i] = computer;
            results[i] = result;

            System.out.println("Player   : " + player);
            System.out.println("Computer : " + computer);
            System.out.println("Result   : " + result);

            // Update scoreboard
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        // Calculate percentage
        double winPercentage = (wins / (double) rounds) * 100;

        // Final summary
        System.out.println("\n\n==============================================");
        System.out.println("                 FINAL SUMMARY");
        System.out.println("==============================================");

        System.out.printf("%-8s %-15s %-15s %-18s%n",
                "Round", "Player", "Computer", "Result");

        System.out.println("----------------------------------------------");

        for (int i = 0; i < rounds; i++) {
            System.out.printf("%-8d %-15s %-15s %-18s%n",
                    i + 1,
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        System.out.println("----------------------------------------------");
        System.out.println("Total Rounds : " + rounds);
        System.out.println("Wins         : " + wins);
        System.out.println("Losses       : " + losses);
        System.out.println("Draws        : " + draws);
        System.out.printf("Win %%        : %.1f%%%n", winPercentage);
        System.out.println("==============================================");

        sc.close();
    }
}