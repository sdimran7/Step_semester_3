
import java.util.*;

abstract class Parcel {
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0;
    }

    double calculateTotal() {
        return calculateCharge() + calculateInsurance();
    }
}

interface Insurable {
    double getInsurance(double value);
}

class StandardParcel extends Parcel {
    StandardParcel(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel implements Insurable {
    ExpressParcel(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 80 + 15 * weight;
    }

    public double getInsurance(double value) {
        return value * 0.02;
    }

    double calculateInsurance() {
        return getInsurance(declaredValue);
    }
}

class FragileParcel extends Parcel implements Insurable {
    FragileParcel(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    public double getInsurance(double value) {
        return value * 0.02;
    }

    double calculateInsurance() {
        return getInsurance(declaredValue);
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== PARCEL SHIPPING DESK =====");

        System.out.print("Enter number of parcels: ");
        int n = sc.nextInt();

        double grandTotal = 0;

        System.out.println("\nTypes: STANDARD, EXPRESS, FRAGILE");

        for (int i = 1; i <= n; i++) {
            System.out.println("\nParcel " + i);

            System.out.print("Enter parcel type: ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter weight in kg: ");
            double weight = sc.nextDouble();

            System.out.print("Enter declared value: ");
            double value = sc.nextDouble();

            if (weight < 0 || value < 0) {
                System.out.println("Weight and value cannot be negative!");
                return;
            }

            Parcel parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardParcel(weight, value);
                    break;

                case "EXPRESS":
                    parcel = new ExpressParcel(weight, value);
                    break;

                case "FRAGILE":
                    parcel = new FragileParcel(weight, value);
                    break;

                default:
                    System.out.println("Invalid parcel type!");
                    return;
            }

            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = parcel.calculateTotal();

            grandTotal += total;

            System.out.printf(Locale.US,
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total);
        }

        System.out.printf(Locale.US,
            "\nGrand Total: %.2f%n", grandTotal);

        sc.close();
    }
}
