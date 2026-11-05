
import java.util.Scanner;

public class ClassAttendanceTracker {

    static int[] attendanceSummary(int[] days) {
        int present = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                currentStreak++;

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new int[]{present, longestStreak};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of days: ");
        int n = sc.nextInt();

        if (n < 1 || n > 100) {
            System.out.println("Invalid number of days.");
            sc.close();
            return;
        }

        int[] days = new int[n];

        System.out.println("Enter attendance for each day (1 = Present, 0 = Absent):");

        for (int i = 0; i < n; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            days[i] = sc.nextInt();

            if (days[i] != 0 && days[i] != 1) {
                System.out.println("Enter only 0 or 1. Try again.");
                i--;
            }
        }

        int[] result = attendanceSummary(days);

        System.out.println("Present: " + result[0]);
        System.out.println("Longest streak: " + result[1]);

        sc.close();
    }
}
