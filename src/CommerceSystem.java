import java.util.List;

public class CommerceSystem {
//    private final List<Product> products;
    private final List<Category> categories;

    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    void start() {
        int idx = 1;

        System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
        for (Category category : categories) {
            System.out.println(idx++ + ". " + category.getCategoryName());
        }



//        System.out.printf("%d. %-14s | " + "%,9d원 | %s%n" , idx++, category.product.getName(), product.getPrice(), product.getDescription());

        System.out.printf("0. %-12s | 프로그램 종료%n", "종료");
    }
}
