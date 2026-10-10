
import java.util.Scanner;

class TrafficLight {
    private String color;
    private final String id;

    TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    void next() {
        if (color.equals("RED")) {
            color = "GREEN";
        } else if (color.equals("GREEN")) {
            color = "YELLOW";
        } else {
            color = "RED";
        }

        System.out.println("Current color: " + color);
    }

    String getColor() {
        return color;
    }

    String getId() {
        return id;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter traffic light ID: ");
        String id = sc.nextLine();

        TrafficLight t = new TrafficLight(id);

        System.out.println("Initial color: " + t.getColor());

        System.out.print("Enter number of transitions: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            t.next();
        }

        System.out.println("Traffic light ID: " + t.getId());
        System.out.println("Final color: " + t.getColor());

        sc.close();
    }
}
