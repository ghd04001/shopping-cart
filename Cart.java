import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Cart {

    private final Map<Product, Integer> items = new HashMap<>();

    public void showItems() {
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().getName() + " : " + entry.getValue() + "개");
        }
    }

    public Map<String, Integer> showItemsStream() {
        return items.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey().getName(), Map.Entry::getValue));
    }

    public void addProduct(Product product, int amount) {
        items.merge(product, amount, Integer::sum);
    }

    public void removeProduct(Product product, int amount) {
        if (items.get(product) != null) {
            items.merge(product, amount, ((integer, integer2) -> Math.max(0, integer - integer2)));
        }
    }

}
