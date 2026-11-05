
import java.util.Scanner;

public class StudentResultCardGenerator {

    static class Student {
        String name;
        int[] marks;

        Student(String name, int[] marks) {
            this.name = name;
            this.marks = marks;
        }

        double calculateAverage() {
            int total = 0;

            for (int mark : marks) {
                total += mark;
            }

            return (double) total / marks.length;
        }

        char calculateGrade(double average) {
            if (average >= 90) {
                return 'A';
            } else if (average >= 75) {
                return 'B';
            } else if (average >= 60) {
                return 'C';
            } else if (average >= 40) {
                return 'D';
            } else {
                return 'F';
            }
        }

        void displayResult() {
            double average = calculateAverage();
            char grade = calculateGrade(average);

            System.out.printf("%s: Average %.1f, Grade %c%n",
                    name.toUpperCase(), average, grade);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        int[] marks = new int[3];

        System.out.println("Enter marks for 3 subjects (0-100):");

        for (int i = 0; i < 3; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();

            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks. Try again.");
                i--;
            }
        }

        Student student = new Student(name, marks);

        System.out.println("\n----- STUDENT RESULT -----");
        student.displayResult();

        sc.close();
    }
}
