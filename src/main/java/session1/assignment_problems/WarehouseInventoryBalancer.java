import java.util.Scanner;

public class WarehouseInventoryBalancer {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {

        int totalA = 0;
        int totalB = 0;

        // Calculate totals
        for (int quantity : sectionA) {
            totalA += quantity;
        }

        for (int quantity : sectionB) {
            totalB += quantity;
        }

        // Find highest quantity
        int highest = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {

            if (sectionA[i] > highest) {
                highest = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }

            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        String status;

        if (totalA == totalB)
            status = "Balanced";
        else
            status = "Not Balanced";

        System.out.println("\n==================================================");
        System.out.println("          WAREHOUSE INVENTORY REPORT");
        System.out.println("==================================================");

        System.out.println("Section A Total : " + totalA);
        System.out.println("Section B Total : " + totalB);
        System.out.println("Status          : " + status);

        System.out.println("-----------------------------------------------");

        System.out.println("Highest Quantity: " + highest);
        System.out.println("Section         : " + highestSection);
        System.out.println("Item Number     : " + (highestIndex + 1));

        System.out.println("==================================================");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("==============================================");
        System.out.println("        WAREHOUSE INVENTORY BALANCER");
        System.out.println("==============================================");

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] sectionA = new int[n];
        int[] sectionB = new int[n];

        System.out.println("\nEnter quantities for Section A:");

        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            sectionA[i] = sc.nextInt();
        }

        System.out.println("\nEnter quantities for Section B:");

        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + ": ");
            sectionB[i] = sc.nextInt();
        }

        analyzeInventory(sectionA, sectionB);

        sc.close();
    }
}