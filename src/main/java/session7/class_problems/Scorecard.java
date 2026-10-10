
import java.util.Scanner;

class Scorecard {
    private final boolean[] results;
    private int answerCount;

    Scorecard(int totalQuestions) {
        if (totalQuestions < 0) {
            totalQuestions = 0;
        }
        results = new boolean[totalQuestions];
        answerCount = 0;
    }

    void recordAnswer(boolean correct) {
        if (answerCount < results.length) {
            results[answerCount] = correct;
            answerCount++;
        } else {
            System.out.println("Cannot record more answers");
        }
    }

    int getScore() {
        int score = 0;

        for (int i = 0; i < answerCount; i++) {
            if (results[i]) {
                score++;
            }
        }

        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter total number of questions: ");
        int total = sc.nextInt();

        if (total < 0) {
            System.out.println("Invalid question count");
            sc.close();
            return;
        }

        Scorecard scorecard = new Scorecard(total);

        for (int i = 0; i < total; i++) {
            System.out.print("Was answer " + (i + 1) + " correct? (true/false): ");
            boolean correct = sc.nextBoolean();
            scorecard.recordAnswer(correct);
        }

        System.out.println("Total score: " + scorecard.getScore());

        sc.close();
    }
}
