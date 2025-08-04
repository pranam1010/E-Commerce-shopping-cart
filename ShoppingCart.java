import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<CartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public void removeProduct(Product product) {
        items.removeIf(item -> item.getProduct().equals(product));
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    public List<CartItem> getItems() {
        return items;
    }
}