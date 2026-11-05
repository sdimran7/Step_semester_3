
import java.util.*;

abstract class Question {
    String correctAnswer, studentAnswer;
    double points;

    Question(String correct, String student, double points) {
        this.correctAnswer = correct;
        this.studentAnswer = student;
        this.points = points;
    }

    abstract double evaluate();
}

class MCQ extends Question {
    MCQ(String c, String s, double p) {
        super(c, s, p);
    }

    double evaluate() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class TF extends Question {
    TF(String c, String s, double p) {
        super(c, s, p);
    }

    double evaluate() {
        return correctAnswer.equals(studentAnswer) ? points : 0;
    }
}

class Essay extends Question {
    Essay(String c, String s, double p) {
        super(c, s, p);
    }

    double evaluate() {
        String[] keywords = correctAnswer.split(",");
        int count = 0;

        for (String word : keywords) {
            if (studentAnswer.toLowerCase()
                    .contains(word.trim().toLowerCase())) {
                count++;
            }
        }

        if (count >= 2) {
            return points * 0.75;
        } else if (count == 1) {
            return points * 0.50;
        }

        return 0;
    }
}

public class ExaminationGrader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            String[] parts = line.split("\"");
            String type = line.substring(0, line.indexOf(' '));

            String correct = parts[3];
            String student = parts[5];

            double points = Double.parseDouble(
                    parts[parts.length - 1].trim());

            Question q;

            switch (type) {
                case "MCQ":
                    q = new MCQ(correct, student, points);
                    break;

                case "TF":
                    q = new TF(correct, student, points);
                    break;

                default:
                    q = new Essay(correct, student, points);
            }

            double score = q.evaluate();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
        sc.close();
    }
}
