
import java.util.*;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTime extends Staff {
    double salary;

    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double calculatePay() {
        return salary;
    }
}

class Hourly extends Staff {
    double hours, rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double calculatePay() {
        if (hours <= 40)
            return hours * rate;

        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== WEEKLY STAFF PAY =====");
        System.out.print("Enter number of staff members: ");
        int n = sc.nextInt();

        double total = 0;

        System.out.println("\nStaff types: FULLTIME, HOURLY, INTERN");

        for (int i = 1; i <= n; i++) {
            System.out.println("\nStaff " + i);

            System.out.print("Enter staff type: ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter staff name: ");
            String name = sc.next();

            Staff staff;

            switch (type) {
                case "FULLTIME":
                    System.out.print("Enter weekly salary: ");
                    staff = new FullTime(name, sc.nextDouble());
                    break;

                case "HOURLY":
                    System.out.print("Enter hours worked: ");
                    double hours = sc.nextDouble();

                    System.out.print("Enter hourly rate: ");
                    double rate = sc.nextDouble();

                    staff = new Hourly(name, hours, rate);
                    break;

                case "INTERN":
                    System.out.print("Enter stipend: ");
                    staff = new Intern(name, sc.nextDouble());
                    break;

                default:
                    System.out.println("Invalid staff type!");
                    return;
            }

            double pay = staff.calculatePay();
            total += pay;

            System.out.printf(Locale.US,
                "%s: %.2f%n", staff.name, pay);
        }

        System.out.printf(Locale.US,
            "\nTotal Payroll: %.2f%n", total);

        sc.close();
    }
}
