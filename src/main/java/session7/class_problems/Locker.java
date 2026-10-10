
import java.util.Scanner;

class Locker {
    private String combination;
    private final int lockerNumber;

    Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    void changeCode(String currentCode, String newCode) {
        if (combination.equals(currentCode)) {
            combination = newCode;
            System.out.println("Combination changed successfully");
        } else {
            System.out.println("Change rejected: incorrect current code");
        }
    }

    int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter locker number: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Set initial combination: ");
        String initialCode = sc.nextLine();

        Locker locker = new Locker(number, initialCode);

        System.out.print("Enter current code: ");
        String currentCode = sc.nextLine();

        System.out.print("Enter new code: ");
        String newCode = sc.nextLine();

        locker.changeCode(currentCode, newCode);

        System.out.print("Enter current code again: ");
        currentCode = sc.nextLine();

        System.out.print("Enter another new code: ");
        newCode = sc.nextLine();

        locker.changeCode(currentCode, newCode);

        System.out.println("Locker number: " + locker.getLockerNumber());

        sc.close();
    }
}
