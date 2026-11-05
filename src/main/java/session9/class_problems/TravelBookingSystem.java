
import java.util.*;

abstract class Booking {
    double distance;

    static final double BOOKING_FEE = 50.0;

    Booking(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    double calculateTotal() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class Bus extends Booking {
    Bus(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 2.0;
    }
}

class Train extends Booking {
    Train(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 1.5;
    }
}

class Flight extends Booking {
    Flight(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2500 + distance * 4.0;
    }
}

public class TravelBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== TRAVEL BOOKING SYSTEM =====");

        System.out.print("Enter number of bookings: ");
        int n = sc.nextInt();

        System.out.println("\nAvailable modes: BUS, TRAIN, FLIGHT");

        for (int i = 1; i <= n; i++) {
            System.out.println("\nBooking " + i);

            System.out.print("Enter travel mode: ");
            String mode = sc.next().toUpperCase();

            System.out.print("Enter distance in km: ");
            double distance = sc.nextDouble();

            if (distance < 0) {
                System.out.println("Distance cannot be negative!");
                return;
            }

            Booking booking;

            switch (mode) {
                case "BUS":
                    booking = new Bus(distance);
                    break;

                case "TRAIN":
                    booking = new Train(distance);
                    break;

                case "FLIGHT":
                    booking = new Flight(distance);
                    break;

                default:
                    System.out.println("Invalid travel mode!");
                    return;
            }

            System.out.printf(Locale.US,
                "%s: %.2f%n", mode, booking.calculateTotal());
        }

        sc.close();
    }
}
