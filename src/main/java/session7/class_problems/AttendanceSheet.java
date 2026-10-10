
import java.util.Scanner;

class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    AttendanceSheet(int capacity) {
        if (capacity < 0) {
            capacity = 0;
        }
        presentStudents = new String[capacity];
        presentCount = 0;
    }

    void markPresent(String name) {
        if (isPresent(name)) {
            System.out.println(name + " is already marked present");
            return;
        }

        if (presentCount < presentStudents.length) {
            presentStudents[presentCount] = name;
            presentCount++;
            System.out.println(name + " marked present");
        } else {
            System.out.println("Attendance sheet is full");
        }
    }

    int getPresentCount() {
        return presentCount;
    }

    boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum class size: ");
        int capacity = sc.nextInt();
        sc.nextLine();

        if (capacity < 0) {
            System.out.println("Invalid class size");
            sc.close();
            return;
        }

        AttendanceSheet sheet = new AttendanceSheet(capacity);

        System.out.print("Enter number of attendance entries: ");
        int entries = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < entries; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            sheet.markPresent(name);
        }

        System.out.println("Present count: " + sheet.getPresentCount());

        System.out.print("Enter name to check: ");
        String searchName = sc.nextLine();

        System.out.println("Is present: " + sheet.isPresent(searchName));

        sc.close();
    }
}
