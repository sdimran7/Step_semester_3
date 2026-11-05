
import java.util.Scanner;
import java.util.Arrays;

public class DutyRosterRotation {

    static String[] rotateRoster(String[] names, int k) {
        int n = names.length;
        k = k % n;

        String[] rotated = new String[n];

        for (int i = 0; i < n; i++) {
            rotated[(i + k) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of names: ");
        int n = sc.nextInt();

        if (n < 1 || n > 100) {
            System.out.println("Invalid number of names.");
            sc.close();
            return;
        }

        String[] names = new String[n];

        System.out.println("Enter " + n + " names:");

        for (int i = 0; i < n; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            names[i] = sc.next();
        }

        System.out.print("Enter rotation count k: ");
        int k = sc.nextInt();

        if (k < 0 || k > 1000000000) {
            System.out.println("Invalid rotation count.");
            sc.close();
            return;
        }

        String[] result = rotateRoster(names, k);

        System.out.println("Rotated roster: " + Arrays.toString(result));

        sc.close();
    }
}
