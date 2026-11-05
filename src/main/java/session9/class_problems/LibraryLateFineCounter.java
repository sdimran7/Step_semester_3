
import java.util.*;

abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class Book extends LibraryItem {
    Book(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVD extends LibraryItem {
    DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== LIBRARY LATE FINE COUNTER =====");

        System.out.print("Enter number of borrowed items: ");
        int n = sc.nextInt();

        double total = 0;

        System.out.println("\nAvailable types: BOOK, DVD, MAGAZINE");

        for (int i = 1; i <= n; i++) {
            System.out.println("\nItem " + i);

            System.out.print("Enter item type: ");
            String type = sc.next().toUpperCase();

            System.out.print("Enter title (one word): ");
            String title = sc.next();

            System.out.print("Enter days late: ");
            int days = sc.nextInt();

            if (days < 0) {
                System.out.println("Days late cannot be negative!");
                return;
            }

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title, days);
                    break;

                case "DVD":
                    item = new DVD(title, days);
                    break;

                case "MAGAZINE":
                    item = new Magazine(title, days);
                    break;

                default:
                    System.out.println("Invalid item type!");
                    return;
            }

            double fine = item.calculateFine();
            total += fine;

            System.out.printf(Locale.US,
                "%s: %.2f%n", item.title, fine);
        }

        System.out.printf(Locale.US,
            "\nTotal Fines: %.2f%n", total);

        sc.close();
    }
}
