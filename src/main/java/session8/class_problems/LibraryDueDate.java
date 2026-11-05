
import java.util.*;
import java.time.LocalDate;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getBorrowingDays();

    LocalDate calculateDueDate() {
        return LocalDate.of(2023, 10, 26)
                .plusDays(getBorrowingDays());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    int getBorrowingDays() {
        return 3;
    }
}

public class LibraryDueDate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();

            int space = line.indexOf(' ');
            String type = line.substring(0, space);
            String title = line.substring(space + 1)
                    .replace("\"", "");

            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title);
                    break;

                case "DVD":
                    item = new DVD(title);
                    break;

                default:
                    item = new Magazine(title);
            }

            System.out.println(item.title + ": " +
                    item.calculateDueDate());
        }

        sc.close();
    }
}
