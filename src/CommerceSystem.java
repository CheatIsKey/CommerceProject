import java.util.List;
import java.util.Scanner;

public class CommerceSystem {
    //    private final List<Product> products;
    private final List<Category> categories;

    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
    }

    void start() {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n[ 실시간 커머스 플랫폼 메인 ]");
            for (int i = 0; i < categories.size(); i++) {
                System.out.printf("%d. %s%n", i + 1, categories.get(i).getCategoryName());
            }
            System.out.printf("0. %-12s | 프로그램 종료%n", "종료");

            int selectMenuNum = scan.nextInt();

            if (selectMenuNum == 0) {
                return;
            }

            if (selectMenuNum < 1 || selectMenuNum > categories.size()) {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            Category category = categories.get(selectMenuNum - 1);
            List<Product> products = category.getProducts();

            System.out.println("\n[ " + category.getCategoryName() + " 카테고리 ]");

            for (int i = 0; i < products.size(); i++) {
                String name = products.get(i).getName();
                int price = products.get(i).getPrice();
                String description = products.get(i).getDescription();

                System.out.printf("%d. %-14s | " + "%,9d원 | %s%n" , i + 1, name, price, description);
            }

            System.out.printf("0. %s %n", "뒤로가기");

            int selectProductNum = scan.nextInt();

            if (selectProductNum == 0) {
                continue;
            } else {
                String name = products.get(selectProductNum - 1).getName();
                int price = products.get(selectProductNum - 1).getPrice();
                String description = products.get(selectProductNum - 1).getDescription();
                int quantity = products.get(selectProductNum - 1).getQuantity();

                System.out.printf("선택한 상품: %s | " + "%,9d원 | %s | 재고: %,2d개%n" , name, price, description, quantity);
            }
        }
    }
}
