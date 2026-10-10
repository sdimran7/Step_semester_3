
import java.util.Scanner;

class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    Cart(String cartId, int capacity) {
        this.cartId = cartId;
        this.prices = new double[Math.max(0, capacity)];
        this.itemCount = 0;
    }

    void addItem(double price) {
        if (price < 0) {
            System.out.println("Invalid price");
        } else if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
            System.out.println("Item added successfully");
        } else {
            System.out.println("Cart is full");
        }
    }

    double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    int getItemCount() {
        return itemCount;
    }

    String getCartId() {
        return cartId;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cart ID: ");
        String id = sc.nextLine();

        System.out.print("Enter cart capacity: ");
        int capacity = sc.nextInt();

        if (capacity < 0) {
            System.out.println("Invalid capacity");
            sc.close();
            return;
        }

        Cart cart = new Cart(id, capacity);

        System.out.print("Enter number of items to add: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Invalid number of items");
            sc.close();
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Enter item price: ");
            cart.addItem(sc.nextDouble());
        }

        System.out.println("Cart ID: " + cart.getCartId());
        System.out.println("Total price: " + cart.getTotal());
        System.out.println("Total items: " + cart.getItemCount());

        sc.close();
    }
}