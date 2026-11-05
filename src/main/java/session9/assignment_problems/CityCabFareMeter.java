
import java.util.*;

abstract class Cab {
    double km;

    static final double MINIMUM_FARE = 100;

    Cab(double km) {
        this.km = km;
    }

    abstract double calculateBaseFare();

    double calculateFare(boolean night) {
        double fare = Math.max(calculateBaseFare(), MINIMUM_FARE);

        if (night) {
            fare *= 1.20;
        }

        return fare;
    }
}

interface NightService {
    boolean supportsNightService();
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 14;
    }

    public boolean supportsNightService() {
        return true;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 18;
    }

    public boolean supportsNightService() {
        return true;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== CITY CAB FARE METER =====");

        System.out.print("Enter number of trips: ");
        int n = sc.nextInt();

        double total = 0;

        System.out.println("\nCab types: MINI, SEDAN, SUV");
        System.out.println("Travel time: DAY or NIGHT");

        for (int i = 1; i <= n; i++) {
            System.out.println("\nTrip " + i);

            System.out.print("Enter cab type: ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter distance in km: ");
            double km = sc.nextDouble();

            System.out.print("Enter travel time (DAY/NIGHT): ");
            String time = sc.next().toUpperCase();

            if (km < 0) {
                System.out.println("Distance cannot be negative!");
                return;
            }

            if (!time.equals("DAY") && !time.equals("NIGHT")) {
                System.out.println("Invalid travel time!");
                return;
            }

            Cab cab;

            switch (type) {
                case "MINI":
                    cab = new Mini(km);
                    break;

                case "SEDAN":
                    cab = new Sedan(km);
                    break;

                case "SUV":
                    cab = new SUV(km);
                    break;

                default:
                    System.out.println("Invalid cab type!");
                    return;
            }

            if (time.equals("NIGHT") && !(cab instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = cab.calculateFare(time.equals("NIGHT"));
            total += fare;

            System.out.printf(Locale.US,
                "%s: %.2f%n", type, fare);
        }

        System.out.printf(Locale.US, "\nTotal: %.2f%n", total);

        sc.close();
    }
}
