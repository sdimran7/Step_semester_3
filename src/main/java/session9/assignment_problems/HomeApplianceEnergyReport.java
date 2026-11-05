
import java.util.*;

abstract class Appliance {
    double hours;

    static final double COST_PER_UNIT = 8.0;

    Appliance(double hours) {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits() {
        return getPower() * hours / 1000.0;
    }

    double calculateCost(double units) {
        return units * COST_PER_UNIT;
    }
}

interface SaverMode {
    double applySaver(double units);
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours);
    }

    double getPower() {
        return 150;
    }
}

class AC extends Appliance implements SaverMode {
    AC(double hours) {
        super(hours);
    }

    double getPower() {
        return 1500;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours);
    }

    double getPower() {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode {
    Washer(double hours) {
        super(hours);
    }

    double getPower() {
        return 500;
    }

    public double applySaver(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== HOME APPLIANCE ENERGY REPORT =====");

        System.out.print("Enter number of appliances: ");
        int n = sc.nextInt();

        double totalCost = 0;

        System.out.println("\nAppliances: FRIDGE, AC, TV, WASHER");
        System.out.println("Saver option: Enter SAVER or press Enter for normal mode.");

        for (int i = 1; i <= n; i++) {
            System.out.println("\nAppliance " + i);

            System.out.print("Enter appliance type: ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter hours used: ");
            double hours = sc.nextDouble();

            if (hours < 0) {
                System.out.println("Hours cannot be negative!");
                return;
            }

            System.out.print("Enter SAVER or NORMAL: ");
            String option = sc.next().toUpperCase();

            if (!option.equals("SAVER") && !option.equals("NORMAL")) {
                System.out.println("Invalid mode!");
                return;
            }

            Appliance appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new Fridge(hours);
                    break;

                case "AC":
                    appliance = new AC(hours);
                    break;

                case "TV":
                    appliance = new TV(hours);
                    break;

                case "WASHER":
                    appliance = new Washer(hours);
                    break;

                default:
                    System.out.println("Invalid appliance!");
                    return;
            }

            boolean saver = option.equals("SAVER");

            if (saver && !(appliance instanceof SaverMode)) {
                System.out.println(type + ": saver mode not supported");
                continue;
            }

            double units = appliance.calculateUnits();

            if (saver) {
                units = ((SaverMode) appliance).applySaver(units);
            }

            double cost = appliance.calculateCost(units);
            totalCost += cost;

            System.out.printf(Locale.US,
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost);
        }

        System.out.printf(Locale.US,
            "\nTotal Cost: %.2f%n", totalCost);

        sc.close();
    }
}
