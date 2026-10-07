import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the secret number: ");
        int secretNumber = sc.nextInt();

        System.out.print("Enter maximum number of tries: ");
        int maxTries = sc.nextInt();

        boolean guessed = false;
        int tries = 0;

        while (tries < maxTries) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();

            tries++;

            if (guess > secretNumber) {
                System.out.println("Too high");
            } else if (guess < secretNumber) {
                System.out.println("Too low");
            } else {
                System.out.println("Correct! You guessed it");
                guessed = true;
                break;
            }
        }

        if (!guessed) {
            System.out.println("Out of tries - the number was " + secretNumber);
        }

        sc.close();
    }
}