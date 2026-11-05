
import java.util.*;

abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateBonus();
}

class Fulltime extends Employee {
    Fulltime(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.10;
    }
}

class Parttime extends Employee {
    Parttime(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return salary * 0.05;
    }
}

class Intern extends Employee {
    Intern(String name, double salary) {
        super(name, salary);
    }

    double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== FESTIVAL BONUS CALCULATOR =====");
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        Employee[] employees = new Employee[n];

        System.out.println("\nEmployee types: FULLTIME, PARTTIME, INTERN");

        for (int i = 0; i < n; i++) {
            System.out.println("\nEmployee " + (i + 1));

            System.out.print("Enter employee type: ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter employee name: ");
            String name = sc.next();

            System.out.print("Enter monthly salary: ");
            double salary = sc.nextDouble();

            switch (type) {
                case "FULLTIME" -> employees[i] = new Fulltime(name, salary);
                case "PARTTIME" -> employees[i] = new Parttime(name, salary);
                case "INTERN" -> employees[i] = new Intern(name, salary);
                default -> {
                    System.out.println("Invalid type! Enter this employee again.");
                    i--;
                    continue;
                }
            }
        }

        double total = 0;

        System.out.println("\n===== EMPLOYEE BONUS DETAILS =====");

        for (Employee e : employees) {
            double bonus = e.calculateBonus();

            System.out.printf("%s: %.2f%n", e.name, bonus);
            total += bonus;
        }

        System.out.printf("Total Bonus: %.2f%n", total);
        sc.close();
    }
}
