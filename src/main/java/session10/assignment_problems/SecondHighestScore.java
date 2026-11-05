
import java.util.Scanner;

public class SecondHighestScore {

    static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int n = sc.nextInt();

        if (n < 1 || n > 1000) {
            System.out.println("Invalid number of players.");
            sc.close();
            return;
        }

        int[] scores = new int[n];

        System.out.println("Enter scores (0-100):");

        for (int i = 0; i < n; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            scores[i] = sc.nextInt();

            if (scores[i] < 0 || scores[i] > 100) {
                System.out.println("Invalid score. Try again.");
                i--;
            }
        }

        int result = secondHighest(scores);

        if (result == -1) {
            System.out.println("Second-highest score does not exist.");
        } else {
            System.out.println("Second-highest score: " + result);
        }

        sc.close();
    }
}
