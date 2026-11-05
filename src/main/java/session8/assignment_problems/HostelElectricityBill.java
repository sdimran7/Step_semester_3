
import java.util.*;

abstract class Room {
    int units;

    Room(int units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Single extends Room {
    Single(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 8;
    }
}

class Shared extends Room {
    int occupants;

    Shared(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * 6.0) / occupants;
    }
}

class AC extends Room {
    AC(int units) {
        super(units);
    }

    double calculateBill() {
        return units * 10 + 200;
    }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== HOSTEL ELECTRICITY BILL =====");
        System.out.print("Enter number of rooms: ");
        int n = sc.nextInt();

        Room[] rooms = new Room[n];

        System.out.println("\nRoom types: SINGLE, SHARED, AC");

        for (int i = 0; i < n; i++) {
            System.out.println("\nRoom " + (i + 1));

            System.out.print("Enter room type: ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter electricity units: ");
            int units = sc.nextInt();

            switch (type) {
                case "SINGLE" -> rooms[i] = new Single(units);

                case "SHARED" -> {
                    System.out.print("Enter number of occupants (2-4): ");
                    int occupants = sc.nextInt();
                    rooms[i] = new Shared(units, occupants);
                }

                case "AC" -> rooms[i] = new AC(units);

                default -> {
                    System.out.println("Invalid room type! Enter this room again.");
                    i--;
                    continue;
                }
            }
        }

        double total = 0;

        System.out.println("\n===== ELECTRICITY BILL DETAILS =====");

        for (Room r : rooms) {
            double bill = r.calculateBill();

            System.out.printf("%s: %.2f%n",
                    r.getClass().getSimpleName().toUpperCase(), bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
