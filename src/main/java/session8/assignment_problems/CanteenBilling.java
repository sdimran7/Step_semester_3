
import java.util.*;

abstract class Customer {
    double amount;

    Customer(double amount) {
        this.amount = amount;
    }

    abstract double calculateBill();
}

class Student extends Customer {
    Student(double amount) {
        super(amount);
    }

    double calculateBill() {
        return amount * 0.90;
    }
}

class Staff extends Customer {
    Staff(double amount) {
        super(amount);
    }

    double calculateBill() {
        return amount * 0.95;
    }
}

class Guest extends Customer {
    Guest(double amount) {
        super(amount);
    }

    double calculateBill() {
        return amount + 10;
    }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== CANTEEN BILLING COUNTER =====");
        System.out.print("Enter number of bills: ");
        int n = sc.nextInt();

        Customer[] customers = new Customer[n];

        System.out.println("\nCustomer types: STUDENT, STAFF, GUEST");

        for (int i = 0; i < n; i++) {
            System.out.println("\nBill " + (i + 1));

            System.out.print("Enter customer type: ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter bill amount: ");
            double amount = sc.nextDouble();

            switch (type) {
                case "STUDENT" -> customers[i] = new Student(amount);
                case "STAFF" -> customers[i] = new Staff(amount);
                case "GUEST" -> customers[i] = new Guest(amount);
                default -> {
                    System.out.println("Invalid type! Enter this bill again.");
                    i--;
                    continue;
                }
            }
        }

        double total = 0;

        System.out.println("\n===== BILL DETAILS =====");

        for (Customer c : customers) {
            double bill = c.calculateBill();
            System.out.printf("%s: %.2f%n",
                    c.getClass().getSimpleName().toUpperCase(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
