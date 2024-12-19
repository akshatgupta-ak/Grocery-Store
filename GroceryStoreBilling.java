import java.util.ArrayList;
import java.util.Scanner;

class Product {
    String name;
    double price;
    int quantity;

    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

class ShoppingCart {
    ArrayList<Product> cart;

    ShoppingCart() {
        cart = new ArrayList<>();
    }

    void addProduct(Product product) {
        cart.add(product);
    }

    void removeProduct(String productName) {
        cart.removeIf(product -> product.name.equalsIgnoreCase(productName));
    }

    double calculateTotal() {
        double total = 0;
        for (Product product : cart) {
            total += product.price * product.quantity;
        }
        return total;
    }

    void printInvoice() {
        System.out.println("Invoice:");
        for (Product product : cart) {
            System.out.println(product.name + " - " + product.quantity + " x " + product.price + " = " + (product.price * product.quantity));
        }
        System.out.println("Total: " + calculateTotal());
    }
}

public class GroceryStoreBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. View Cart");
            System.out.println("4. Generate Invoice");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    cart.addProduct(new Product(name, price, quantity));
                    break;
                case 2:
                    System.out.print("Enter product name to remove: ");
                    String productName = scanner.nextLine();
                    cart.removeProduct(productName);
                    break;
                case 3:
                    cart.printInvoice();
                    break;
                case 4:
                    cart.printInvoice();
                    return;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
