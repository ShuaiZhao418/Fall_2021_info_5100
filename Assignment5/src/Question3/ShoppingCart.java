package Question3;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    Map<String, Integer> hashmap;
    int total;

    public ShoppingCart() {
        hashmap = new HashMap<String, Integer>();
        total = 0;
    }
    public void addItem(Item item) {
        hashmap.put(item.id, item.price);
        total += item.price;
    }
    public void removeItem(Item item) {
        hashmap.remove(item.id);
        total -= item.price;
    }
    public int calculateTotal() {
        return total;
    }
    public void pay(PaymentStrategy strategy) {
        strategy.pay(total);
    }
}
