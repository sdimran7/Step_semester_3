
import java.util.*;

abstract class Student {
    String name;

    static final double TRANSPORT_FEE = 12000;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    abstract boolean usesBus();

    double calculateTotalFee() {
        double total = calculateTuition();

        if (usesBus()) {
            total += TRANSPORT_FEE;
        }

        return total;
    }
}

class DayScholar extends Student {
    DayScholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000;
    }

    boolean usesBus() {
        return true;
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000 + 60000;
    }

    boolean usesBus() {
        return false;
    }
}

class Scholar extends Student {
    Scholar(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000;
    }

    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== COLLEGE FEE COUNTER =====");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        double totalCollected = 0;

        System.out.println("\nTypes: DAY_SCHOLAR, HOSTELLER, SCHOLAR");

        for (int i = 1; i <= n; i++) {
            System.out.println("\nStudent " + i);

            System.out.print("Enter student type: ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter student name: ");
            String name = sc.next();

            Student student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholar(name);
                    break;

                case "HOSTELLER":
                    student = new Hosteller(name);
                    break;

                case "SCHOLAR":
                    student = new Scholar(name);
                    break;

                default:
                    System.out.println("Invalid student type!");
                    return;
            }

            double fee = student.calculateTotalFee();
            totalCollected += fee;

            System.out.printf(Locale.US,
                "%s: %.2f%n", student.name, fee);
        }

        System.out.printf(Locale.US,
            "\nTotal Collected: %.2f%n", totalCollected);

        sc.close();
    }
}
