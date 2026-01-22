// CartItem 클래스는 Cart를 몰라야 한다.
public class CartItem {
    private final Product product;
//    사용자가 원하는 물품 수량
    private final int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * 장바구니의 총 금액
     * @return : 장바구니에 담겨져 있는 총 가격을 반환한다.
     */
    public long calculateTotalAmount() {
        return (long) product.getPrice() * this.quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
