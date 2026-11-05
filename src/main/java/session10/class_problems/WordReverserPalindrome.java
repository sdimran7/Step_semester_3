
import java.util.Scanner;

public class WordReverserPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String word = sc.next();

        StringBuilder reversed = new StringBuilder(word);
        reversed.reverse();

        System.out.println("Reversed word: " + reversed);

        if (word.equalsIgnoreCase(reversed.toString())) {
            System.out.println(word + " - palindrome");
        } else {
            System.out.println(word + " - not a palindrome");
        }

        sc.close();
    }
}
