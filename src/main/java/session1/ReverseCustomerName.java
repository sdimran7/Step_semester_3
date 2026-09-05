import java.util.Scanner;

public class ReverseCustomerName {

    static String reverseCustomerName(String customerName) {

        return new StringBuilder(customerName).reverse().toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("       CUSTOMER NAME REVERSER");
        System.out.println("======================================");

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println("\n--------------- RESULT --------------");
        System.out.println("Original Name : " + customerName);
        System.out.println("Reversed Name : " + reversedName);
        System.out.println("======================================");

        sc.close();
    }
}