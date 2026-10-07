import java.util.Arrays;
import java.util.Scanner;

class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed,
                  double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed,
                               boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {

        return Double.compare(
            other.battingAverage,
            this.battingAverage
        );
    }

    boolean isEligible() {

        return isDraftable(matchesPlayed)
                || isDraftable(matchesPlayed, injured);
    }

    String getName() {
        return name;
    }
}

public class FantasyLeagueAutoDraftRankingEngine {

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        for (Player player : players) {

            if (player.isEligible()) {
                draftable[count] = player;
                count++;
            }
        }

        draftable = Arrays.copyOf(draftable, count);

        Arrays.sort(draftable);

        if (draftable.length == 0) {
            return "No players available for draft";
        }

        String result = "";

        for (int i = 0; i < draftable.length; i++) {

            result += (i + 1)
                    + ". "
                    + draftable[i].getName();

            if (i < draftable.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nPlayer " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter matches played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Enter batting average: ");
            double battingAverage = sc.nextDouble();

            System.out.print("Is player injured? (true/false): ");
            boolean injured = sc.nextBoolean();

            sc.nextLine();

            players[i] = new Player(
                name,
                matchesPlayed,
                battingAverage,
                injured
            );
        }

        System.out.println("\nDraft Ranking:");

        System.out.println(
            draftAndRank(players)
        );

        sc.close();
    }
}