
import java.util.Scanner;

public class ExamScoreBandCounter {

    static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int upperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (scores[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int countInBand(int[] scores, int low, int high) {
        int first = lowerBound(scores, low);
        int last = upperBound(scores, high);

        return last - first;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        if (n < 1 || n > 1000000) {
            System.out.println("Invalid number of students.");
            sc.close();
            return;
        }

        int[] scores = new int[n];

        System.out.println("Enter " + n + " scores in ascending order:");

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();

            if (scores[i] < 0 || scores[i] > 100 ||
                (i > 0 && scores[i] < scores[i - 1])) {
                System.out.println("Invalid score or order. Enter again.");
                i--;
            }
        }

        System.out.print("Enter lower limit: ");
        int low = sc.nextInt();

        System.out.print("Enter upper limit: ");
        int high = sc.nextInt();

        if (low < 0 || high > 100 || low > high) {
            System.out.println("Invalid range.");
        } else {
            int result = countInBand(scores, low, high);
            System.out.println("Students in score band: " + result);
        }

        sc.close();
    }
}
