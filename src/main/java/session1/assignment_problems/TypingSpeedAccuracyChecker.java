import java.util.Scanner;

public class TypingSpeedAccuracyChecker {

    static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        int length = Math.min(original.length(), typed.length());

        for (int i = 0; i < length; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        // Handle extra characters
        if (typed.length() > original.length()) {

            if (firstMismatch == -1)
                firstMismatch = original.length();

        } else if (original.length() > typed.length()) {

            if (firstMismatch == -1)
                firstMismatch = typed.length();
        }

        int total = original.length();

        double accuracy = (matched / (double) total) * 100;

        System.out.println("\n==============================================");
        System.out.println("          TYPING ACCURACY REPORT");
        System.out.println("==============================================");

        System.out.println("Original : " + original);
        System.out.println("Typed    : " + typed);

        System.out.println("----------------------------------------------");

        System.out.printf("Matched  : %d/%d%n", matched, total);
        System.out.printf("Accuracy : %.2f%%%n", accuracy);

        if (firstMismatch == -1) {

            System.out.println("Status   : No Mismatches");

        } else {

            System.out.print("First Mismatch at position "
                    + (firstMismatch + 1));

            if (firstMismatch < original.length()
                    && firstMismatch < typed.length()) {

                System.out.println(" ('"
                        + original.charAt(firstMismatch)
                        + "' vs '"
                        + typed.charAt(firstMismatch)
                        + "')");

            } else if (firstMismatch < original.length()) {

                System.out.println(" (Missing character: '"
                        + original.charAt(firstMismatch)
                        + "')");

            } else {

                System.out.println(" (Extra character: '"
                        + typed.charAt(firstMismatch)
                        + "')");
            }
        }

        System.out.println("==============================================");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("       TYPING SPEED ACCURACY CHECKER");
        System.out.println("==============================================");

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter your typed text: ");
        String typed = sc.nextLine();

        checkTypingAccuracy(original, typed);

        sc.close();
    }
}
