
import java.util.*;
import java.time.LocalDate;

abstract class Subscription {
    String name;
    LocalDate startDate;

    Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidity();

    LocalDate calculateRenewalDate() {
        return startDate.plusDays(getValidity());
    }
}

class Basic extends Subscription {
    Basic(String name, LocalDate date) {
        super(name, date);
    }

    int getValidity() {
        return 30;
    }
}

class Standard extends Subscription {
    Standard(String name, LocalDate date) {
        super(name, date);
    }

    int getValidity() {
        return 90;
    }
}

class Premium extends Subscription {
    Premium(String name, LocalDate date) {
        super(name, date);
    }

    int getValidity() {
        return 365;
    }
}

public class StreamingPlanRenewal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== STREAMING PLAN RENEWAL =====");
        System.out.print("Enter number of subscribers: ");
        int n = sc.nextInt();

        Subscription[] subscribers = new Subscription[n];

        System.out.println("\nAvailable plans: BASIC, STANDARD, PREMIUM");
        System.out.println("Enter date in YYYY-MM-DD format.");

        for (int i = 0; i < n; i++) {
            System.out.println("\nSubscriber " + (i + 1));

            System.out.print("Enter plan type: ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter subscriber name: ");
            String name = sc.next();

            System.out.print("Enter start date (YYYY-MM-DD): ");
            LocalDate date = LocalDate.parse(sc.next());

            switch (type) {
                case "BASIC" ->
                    subscribers[i] = new Basic(name, date);

                case "STANDARD" ->
                    subscribers[i] = new Standard(name, date);

                case "PREMIUM" ->
                    subscribers[i] = new Premium(name, date);

                default -> {
                    System.out.println("Invalid plan! Enter this subscriber again.");
                    i--;
                    continue;
                }
            }
        }

        System.out.println("\n===== SUBSCRIPTION RENEWAL DATES =====");

        for (Subscription s : subscribers) {
            System.out.println(s.name + ": " + s.calculateRenewalDate());
        }

        sc.close();
    }
}
