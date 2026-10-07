import java.util.Scanner;

public class RotateArray {

    static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;

        if (n == 0) {
            return nums;
        }

        k = k % n;

        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter number of rotations: ");
        int k = sc.nextInt();

        int[] result = rotateArray(nums, k);

        System.out.println("Rotated Array:");

        for (int value : result) {
            System.out.print(value + " ");
        }

        sc.close();
    }
}