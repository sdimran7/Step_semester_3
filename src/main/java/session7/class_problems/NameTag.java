
import java.util.Scanner;

class NameTag {
    private final String firstName;
    private final String lastName;

    NameTag(String fullName) {
        String[] names = fullName.split(" ");
        firstName = names[0];
        lastName = names[1];
    }

    String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full name: ");
        String fullName = sc.nextLine();

        NameTag tag = new NameTag(fullName);

        System.out.println("Nickname: " + tag.getNickname());

        sc.close();
    }
}
