
import java.util.Scanner;

class HallTicket {
    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        HallTicket priya = new HallTicket(name, 0);
        HallTicket copy = priya;

        System.out.print("Enter updated seat number: ");
        copy.seatNumber = sc.nextInt();

        HallTicket separate = new HallTicket(priya.studentName, copy.seatNumber);

        System.out.println(priya.studentName + "'s seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));

        sc.close();
    }
}
