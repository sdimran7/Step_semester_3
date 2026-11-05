
import java.util.*;

abstract class Vehicle {
    int hours;

    Vehicle(int hours) {
        this.hours = hours;
    }

    abstract double calculateCharge();
}

class Bike extends Vehicle {
    Bike(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return hours * 10;
    }
}

class Car extends Vehicle {
    Car(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return 30 + (hours - 1) * 20;
    }
}

class Truck extends Vehicle {
    Truck(int hours) {
        super(hours);
    }

    double calculateCharge() {
        return Math.max(100, hours * 50);
    }
}

public class ParkingCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== CAMPUS PARKING SYSTEM =====");
        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();

        Vehicle[] vehicles = new Vehicle[n];

        System.out.println("\nVehicle types: BIKE, CAR, TRUCK");

        for (int i = 0; i < n; i++) {
            System.out.println("\nVehicle " + (i + 1));

            System.out.print("Enter vehicle type: ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter parking hours (1-24): ");
            int hours = sc.nextInt();

            switch (type) {
                case "BIKE" -> vehicles[i] = new Bike(hours);
                case "CAR" -> vehicles[i] = new Car(hours);
                case "TRUCK" -> vehicles[i] = new Truck(hours);
                default -> {
                    System.out.println("Invalid type! Enter this vehicle again.");
                    i--;
                    continue;
                }
            }
        }

        double total = 0;

        System.out.println("\n===== PARKING CHARGES =====");

        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();

            System.out.printf("%s: %.2f%n",
                    v.getClass().getSimpleName().toUpperCase(), charge);

            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
