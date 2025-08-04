import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptGenerator {

    public static void saveReceipt(ShoppingCart cart, String customerName) {
        try {
            FileWriter writer = new FileWriter("receipt.txt");
            writer.write("====== SmartShop Receipt ======\n");
            writer.write("Customer: " + customerName + "\n");
            writer.write("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n\n");

            double total = 0.0;

            for (CartItem item : cart.getItems()) {
                String line = item.getProduct().getName() + " x" + item.getQuantity() + " - $" + (item.getProduct().getPrice() * item.getQuantity()) + "\n";
                writer.write(line);
                total += item.getProduct().getPrice() * item.getQuantity();
            }

            writer.write("\nTotal: $" + total + "\n");
            writer.write("Thank you for shopping with us!\n");
            writer.close();

            System.out.println("Receipt saved to receipt.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the receipt.");
            e.printStackTrace();
        }
    }
}