
import java.util.Scanner;

class Character {
    private int health;
    private final int maxHealth;

    Character(int maxHealth) {
        this.maxHealth = Math.max(0, maxHealth);
        this.health = this.maxHealth;
    }

    void takeDamage(int amount) {
        if (amount < 0) {
            System.out.println("Invalid damage amount");
            return;
        }

        health = Math.max(0, health - amount);
        System.out.println("Current health: " + health);
    }

    void heal(int amount) {
        if (amount < 0) {
            System.out.println("Invalid healing amount");
            return;
        }

        health = Math.min(maxHealth, health + amount);
        System.out.println("Current health: " + health);
    }

    int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter maximum health: ");
        int maxHealth = sc.nextInt();

        Character c = new Character(maxHealth);

        System.out.println("Initial health: " + c.getHealth());

        System.out.print("Enter damage amount: ");
        c.takeDamage(sc.nextInt());

        System.out.print("Enter healing amount: ");
        c.heal(sc.nextInt());

        System.out.print("Enter damage amount: ");
        c.takeDamage(sc.nextInt());

        System.out.println("Final health: " + c.getHealth());

        sc.close();
    }
}
