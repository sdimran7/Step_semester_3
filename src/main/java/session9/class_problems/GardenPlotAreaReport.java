
import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double calculateArea();
    abstract String getShape();
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }

    String getShape() {
        return "CIRCLE";
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }

    String getShape() {
        return "RECTANGLE";
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }

    String getShape() {
        return "TRIANGLE";
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== GARDEN PLOT AREA REPORT =====");

        System.out.print("Enter number of plots: ");
        int n = sc.nextInt();

        double total = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("\nPlot " + i);
            System.out.println("Available: CIRCLE, RECTANGLE, TRIANGLE");

            System.out.print("Enter shape: ");
            String shape = sc.next().toUpperCase();

            System.out.print("Enter owner name: ");
            String owner = sc.next();

            Plot plot;

            switch (shape) {
                case "CIRCLE":
                    System.out.print("Enter radius: ");
                    plot = new Circle(owner, sc.nextDouble());
                    break;

                case "RECTANGLE":
                    System.out.print("Enter length: ");
                    double length = sc.nextDouble();

                    System.out.print("Enter width: ");
                    double width = sc.nextDouble();

                    plot = new Rectangle(owner, length, width);
                    break;

                case "TRIANGLE":
                    System.out.print("Enter base: ");
                    double base = sc.nextDouble();

                    System.out.print("Enter height: ");
                    double height = sc.nextDouble();

                    plot = new Triangle(owner, base, height);
                    break;

                default:
                    System.out.println("Invalid shape!");
                    return;
            }

            double area = plot.calculateArea();
            total += area;

            System.out.printf(Locale.US,
                "%s (%s): %.2f%n",
                plot.owner, plot.getShape(), area);
        }

        System.out.printf(Locale.US,
            "\nTotal Area: %.2f%n", total);

        sc.close();
    }
}
