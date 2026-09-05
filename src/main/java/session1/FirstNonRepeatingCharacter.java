import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    static char findFirstNonRepeatingChar(String text) {

        Map<Character, Integer> frequency = new HashMap<>();

        // Count each character
        for (char ch : text.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        // Find first character with frequency 1
        for (char ch : text.toCharArray()) {
            if (frequency.get(ch) == 1)
                return ch;
        }

        return '\0';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("    FIRST NON-REPEATING CHARACTER");
        System.out.println("======================================");

        System.out.print("Enter a word or sentence: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeatingChar(text);

        System.out.println("\n--------------- RESULT --------------");

        if (result != '\0')
            System.out.println("First Non-Repeating Character: '" + result + "'");
        else
            System.out.println("No Non-Repeating Character Found");

        System.out.println("======================================");

        sc.close();
    }
}