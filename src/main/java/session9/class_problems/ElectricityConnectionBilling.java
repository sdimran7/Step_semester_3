
import java.util.*;

abstract class Connection {
    double units;

    Connection(double units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Home extends Connection {
    Home(double units) {
        super(units);
    }

    double calculateBill() {
        if (units <= 100)
            return units * 5;

        return 500 + (units - 100) * 7;
    }
}

class Shop extends Connection {
    Shop(double units) {
        super(units);
    }

    double calculateBill() {
        return units * 8 + 100;
    }
}

class Factory extends Connection {
    Factory(double units) {
        super(units);
    }

    double calculateBill() {
        return Math.max(units * 6, 1000);
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== ELECTRICITY CONNECTION BILLING =====");

        System.out.print("Enter number of connections: ");
        int n = sc.nextInt();

        double total = 0;

        System.out.println("\nTypes: HOME, SHOP, FACTORY");

        for (int i = 1; i <= n; i++) {
            System.out.println("\nConnection " + i);

            System.out.print("Enter connection type: ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter units consumed: ");
            double units = sc.nextDouble();

            if (units < 0) {
                System.out.println("Units cannot be negative!");
                return;
            }

            Connection connection;

            switch (type) {
                case "HOME":
                    connection = new Home(units);
                    break;

                case "SHOP":
                    connection = new Shop(units);
                    break;

                case "FACTORY":
                    connection = new Factory(units);
                    break;

                default:
                    System.out.println("Invalid connection type!");
                    return;
            }

            double bill = connection.calculateBill();
            total += bill;

            System.out.printf(Locale.US,
                "%s: %.2f%n", type, bill);
        }

        System.out.printf(Locale.US,
            "\nTotal: %.2f%n", total);

        sc.close();
    }
}
