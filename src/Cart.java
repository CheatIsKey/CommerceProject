import exception.NoSuchCartItems;
import exception.NoSuchQuantityException;
import exception.NoSuchRemovedProductId;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    /**
     * 장바구니에 담기 전에 요청 수량이 잔여 재고량보다 많은 지 확인한다.
     * @param product : 물건 그 자체
     * @param requestQuantity : 사용자가 희망하는 물건 수량
     */
    public void addProduct(Product product, int requestQuantity) {
        int stockQuantity = product.getQuantity();

        for (CartItem item : items) {
            if (item.getProduct().getName().equals(product.getName())) {
                int sumQuantity = item.getQuantity() + requestQuantity;

                if (sumQuantity > stockQuantity) {
                    throw new NoSuchQuantityException("상품의 총 재고량보다 많이 담을 수 없습니다.\n");
                }

                item.addQuantity(requestQuantity);
                return;
            }
        }

        if (requestQuantity > stockQuantity) {
            throw new NoSuchQuantityException("상품의 총 재고량보다 많이 담을 수 없습니다.\n");
        }

        items.add(new CartItem(product, requestQuantity));
    }

    public void removeProduct(int productId) {
        if (items.isEmpty()) {
            throw new NoSuchCartItems("장바구니가 현재 비어있습니다.");
        } else if (productId < 0 || productId > items.size()) {
            throw new NoSuchRemovedProductId("삭제할 상품 번호가 잘못 입력되었습니다.\n");
        }
        CartItem removed = items.remove(productId);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public long getTotalAmount() {
        return items.stream()
                .mapToLong(CartItem::calculateTotalAmount)
                .sum();
    }
}
