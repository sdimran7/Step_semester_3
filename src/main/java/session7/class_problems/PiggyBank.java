
import java.util.Scanner;

class PiggyBank {
    private double savings;
    private final String id;

    PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive");
        } else {
            savings += amount;
            System.out.println("Savings: " + savings);
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be positive");
        } else if (amount > savings) {
            System.out.println("Withdrawal rejected: insufficient savings");
        } else {
            savings -= amount;
            System.out.println("Savings: " + savings);
        }
    }

    double getSavings() {
        return savings;
    }

    String getId() {
        return id;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter piggy bank ID: ");
        String id = sc.nextLine();

        PiggyBank pb = new PiggyBank(id);

        System.out.print("Enter deposit amount: ");
        pb.deposit(sc.nextDouble());

        System.out.print("Enter withdrawal amount: ");
        pb.withdraw(sc.nextDouble());

        System.out.print("Enter another withdrawal amount: ");
        pb.withdraw(sc.nextDouble());

        System.out.println("Piggy Bank ID: " + pb.getId());
        System.out.println("Final savings: " + pb.getSavings());

        sc.close();
    }
}
