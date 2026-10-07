import java.util.Scanner;

public class LoginAttemptSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the correct access code: ");
        String correctCode = sc.nextLine();

        String[] attempts = new String[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter attempt " + (i + 1) + ": ");
            attempts[i] = sc.nextLine();
        }

        boolean accessGranted = false;

        for (int i = 0; i < attempts.length; i++) {
            if (attempts[i].equals(correctCode)) {
                System.out.println("Access granted on attempt " + (i + 1));
                accessGranted = true;
                break;
            }
        }

        if (!accessGranted) {
            System.out.println("Access denied - all attempts used");
        }

        sc.close();
    }
}