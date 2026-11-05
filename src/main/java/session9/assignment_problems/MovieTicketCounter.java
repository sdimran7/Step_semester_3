
import java.util.*;

abstract class Ticket {
    int count;

    static final double CONVENIENCE_FEE = 20.0;

    Ticket(int count) {
        this.count = count;
    }

    abstract double getPrice();

    double calculateAmount() {
        return (getPrice() + CONVENIENCE_FEE) * count;
    }
}

class Regular extends Ticket {
    Regular(int count) {
        super(count);
    }

    double getPrice() {
        return 150;
    }
}

class Premium extends Ticket {
    Premium(int count) {
        super(count);
    }

    double getPrice() {
        return 250;
    }
}

class Recliner extends Ticket {
    Recliner(int count) {
        super(count);
    }

    double getPrice() {
        return 400;
    }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== MOVIE TICKET COUNTER =====");

        System.out.print("Enter number of bookings: ");
        int n = sc.nextInt();

        double total = 0;

        System.out.println("\nSeat types: REGULAR, PREMIUM, RECLINER");

        for (int i = 1; i <= n; i++) {
            System.out.println("\nBooking " + i);

            System.out.print("Enter seat type: ");
            String seat = sc.next().toUpperCase();

            System.out.print("Enter number of tickets: ");
            int count = sc.nextInt();

            if (count <= 0) {
                System.out.println("Ticket count must be positive!");
                return;
            }

            Ticket ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new Regular(count);
                    break;

                case "PREMIUM":
                    ticket = new Premium(count);
                    break;

                case "RECLINER":
                    ticket = new Recliner(count);
                    break;

                default:
                    System.out.println("Invalid seat type!");
                    return;
            }

            double amount = ticket.calculateAmount();
            total += amount;

            System.out.printf(Locale.US,
                "%s: %.2f%n", seat, amount);
        }

        System.out.printf(Locale.US,
            "\nTotal: %.2f%n", total);

        sc.close();
    }
}
