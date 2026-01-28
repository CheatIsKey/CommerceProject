import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<CartItem> orderItems;
    private final long totalAmount;

    public Order(List<CartItem> orderItems) {
//        장바구니는 주문 즉시, clear를 수행하므로 복사를 한다.
        this.orderItems = new ArrayList<>(orderItems);
        this.totalAmount = calculateTotalAmount();
    }

    private long calculateTotalAmount() {
        return orderItems.stream()
                .mapToLong(CartItem::calculateTotalAmount)
                .sum();
    }

    public List<CartItem> getOrderItems() {
        return orderItems;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public void cancelOrder() {
        for (CartItem item : orderItems) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            product.addStock(quantity);

            System.out.printf("%s 상품이 %d개 복구되었습니다.%n", product.getName(), quantity);
        }
    }
}
