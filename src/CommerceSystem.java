import exception.NoPermissionOrderMenuException;
import exception.NoSuchMenuNumberException;
import exception.NoSuchProductNumberException;
import exception.NoSuchQuantityException;

import java.util.List;

public class CommerceSystem {
    private final List<Category> categories;
    private final Cart cart;

    public CommerceSystem(List<Category> categories) {
        this.categories = categories;
        this.cart = new Cart();
    }

    void start() {
        boolean isVisibleOrderMenu = false;

        while (true) {
            int selectCategoryMenuNum;

            try {
                selectCategoryMenuNum = selectCategoryMenu(isVisibleOrderMenu);
            } catch (NoSuchMenuNumberException | NoPermissionOrderMenuException e) {
                System.out.println(e.getMessage());
                continue;
            }

            if (selectCategoryMenuNum == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (selectCategoryMenuNum == 4) {

                continue;
            } else if (selectCategoryMenuNum == 5) {

                continue;
            }

            Category category = categories.get(selectCategoryMenuNum - 1);
            List<Product> products = category.getProducts();

            int selectProductNum;

            try {
                selectProductNum = selectProductsList(category, products);
            } catch (NoSuchProductNumberException e) {
                System.out.println(e.getMessage());
                continue;
            }

            if (selectProductNum == 0) continue;

            try {
                selectProduct(products, selectProductNum);
                isVisibleOrderMenu = true;
            } catch (NoSuchQuantityException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 실행할 때 출력되는 초기 화면과 입력 검증
     * @param isVisibleOrderMenu : OrderMenu는 장바구니에 상품이 담겨져 있어야 볼 수 있다.
     * @return : 선택한 메뉴 번호
     */
    private int selectCategoryMenu(boolean isVisibleOrderMenu) {
        System.out.println("\n[ 실시간 커머스 플랫폼 메인 ]");
        for (int i = 0; i < categories.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, categories.get(i).getCategoryName());
        }
        System.out.printf("0. %-12s | 프로그램 종료%n", "종료");

        if (isVisibleOrderMenu) {
            System.out.println("\n[ 주문 관리 ]");
            System.out.printf("4. %-12s | 장바구니를 확인 후 주문합니다.%n", "장바구니 확인");
            System.out.printf("5. %-12s | 진행중인 주문을 취소합니다.%n", "주문 취소");
        }

        int selectMenuNum = InputUtils.parser(Integer::parseInt);

        if (selectMenuNum == 0) return 0;

        if (selectMenuNum == 4 ||  selectMenuNum == 5) {
            if (!isVisibleOrderMenu) {
                throw new NoPermissionOrderMenuException("장바구니가 비어있는 상태로 접근할 수 없습니다.");
            }
            return selectMenuNum;
        }

        if (selectMenuNum < 1 || selectMenuNum > categories.size()) {
            throw new NoSuchMenuNumberException("잘못된 메뉴 번호가 입력되었습니다.");
        }

        return selectMenuNum;
    }

    /**
     * 카테고리 내에 등록되어 있는 물건들을 출력하고 그 중 하나 선택하는 메소드
     * @param category : 카테고리들 중에서 선택된 단일 객체
     * @param products : 카테고리에 등록된 물건 정보
     * @return : 물건들 중 선택한 물건 번호
     */
    private int selectProductsList(Category category, List<Product> products) {
        System.out.println("\n[ " + category.getCategoryName() + " 카테고리 ]");

        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getName();
            int price = products.get(i).getPrice();
            String description = products.get(i).getDescription();

            System.out.printf("%d. %-14s | " + "%,9d원 | %s%n", i + 1, name, price, description);
        }
        System.out.printf("0. %s %n", "뒤로가기");

        int selectProductNum = InputUtils.parser(Integer::parseInt);

        if (selectProductNum < 0 || selectProductNum > products.size()) {
            throw new NoSuchProductNumberException("입력하신 번호에 해당하는 상품은 존재하지 않습니다.");
        }

        return selectProductNum;
    }

    /**
     * 선택한 물건에 대한 정보와 장바구니에 담을지 확인하는 메서드를 가짐
     * @param products : 특정 카테고리에 포함되어 있는 물건들 목록
     * @param selectProductNum : 물건들 중에서 선택된 물건
     */
    private void selectProduct(List<Product> products, int selectProductNum) {
        Product product = products.get(selectProductNum - 1);
        String name = product.getName();
        int price = product.getPrice();
        String description = product.getDescription();
        int quantity = product.getQuantity();

        System.out.printf("선택한 상품: %s | " + "%,9d원 | %s | 재고: %,2d개%n%n", name, price, description, quantity);

        addProductToCart(product, name, price, description);
    }

    /**
     * 선택했던 물건을 장바구니에 담을 건지, 담을 수 있는지(수량 체크) 확인하는 메서드
     * @param product : 물건 그 자체
     * @param name : 선택된 물건의 이름
     * @param price : 선택된 물건의 가격
     * @param description : 선택된 물건의 설명
     */
    private void addProductToCart(Product product, String name, int price, String description) {
        System.out.printf("\"%s | %,9d원 | %s\"%n", name, price, description);
        System.out.println("위 상품을 장바구니에 추가하시겠습니까?");
        System.out.printf("%-10s %s%n", "1. 확인", "2. 취소");

        int selectCartMenu = InputUtils.parser(Integer::parseInt);

        if (selectCartMenu == 1) {
            System.out.println("\n담을 수량을 입력해 주세요.");
            System.out.print("수량 : ");
            int inputQuantity = InputUtils.parser(Integer::parseInt);

            this.cart.addProduct(product, inputQuantity);

            System.out.printf("%n%s가 %,d개 장바구니에 추가되었습니다.%n", name, inputQuantity);
        }
    }
}