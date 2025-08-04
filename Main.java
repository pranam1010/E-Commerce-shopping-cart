import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        Product laptop = new Product("Laptop", 999.99, 5);
        Product shirt = new Product("Shirt", 29.99, 10);

        System.out.println("Welcome to SmartShop!");
        System.out.println("1. Add Laptop to cart");
        System.out.println("2. Add Shirt to cart");
        System.out.println("3. View total and checkout");
        System.out.print("Enter your choice: ");
        
        int choice = scanner.nextInt();
        switch (choice) {
            case 1 -> cart.addProduct(laptop, 1);
            case 2 -> cart.addProduct(shirt, 1);
            case 3 -> {
                System.out.println("Total: $" + cart.calculateTotal());
                ReceiptGenerator.saveReceipt(cart, "John Doe");
            }
            default -> System.out.println("Invalid option.");
        }
    }
}