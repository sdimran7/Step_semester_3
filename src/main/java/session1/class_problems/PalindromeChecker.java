import java.util.Scanner;

public class PalindromeChecker {

    // 1. Iterative approach
    static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    // 2. Recursive approach
    static boolean isPalindromeRecursive(String text) {
        return checkRecursive(text, 0, text.length() - 1);
    }

    static boolean checkRecursive(String text, int left, int right) {

        if (left >= right)
            return true;

        if (text.charAt(left) != text.charAt(right))
            return false;

        return checkRecursive(text, left + 1, right - 1);
    }

    // 3. Array reversal approach
    static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return text.equals(new String(reversed));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("          PALINDROME CHECKER");
        System.out.println("======================================");

        System.out.print("Enter a word or text: ");
        String text = sc.nextLine();

        boolean result1 = isPalindromeIterative(text);
        boolean result2 = isPalindromeRecursive(text);
        boolean result3 = isPalindromeArrayReversal(text);

        System.out.println("\n--------------- RESULTS --------------");

        System.out.println("Iterative      : " +
                (result1 ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive      : " +
                (result2 ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal : " +
                (result3 ? "Palindrome" : "Not Palindrome"));

        System.out.println("--------------------------------------");

        if (result1 == result2 && result2 == result3)
            System.out.println("All three approaches agree.");

        System.out.println("======================================");

        sc.close();
    }
}