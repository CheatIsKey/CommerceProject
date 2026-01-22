import java.util.ArrayList;
import java.util.List;

public class ProductData {

    public List<Category> createdData() {
        Category electronics = new Category("전자제품");
        electronics.addProduct(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 10));
        electronics.addProduct(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 20));
        electronics.addProduct(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 30));
        electronics.addProduct(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 40));
        electronics.addProduct(new Product("Galaxy Buds 4", 500000, "새로 나온 버즈4", 50));

        Category kitchen = new Category("주방용품");
        kitchen.addProduct(new Product("중식도", 25000, "무엇이든 쉽게 자를 수 있는 칼", 50));
        kitchen.addProduct(new Product("국자", 5000, "가성비 아이템", 100));
        kitchen.addProduct(new Product("앞치마", 8000, "옷을 지켜주는 물건", 35));
        kitchen.addProduct(new Product("행주", 5000, "다회용으로 쓸 수 있는 아이템", 1000));
        kitchen.addProduct(new Product("믹서기", 100000, "브랜드 평판이 높은 아이템", 5));

        Category foods = new Category("식품");
        foods.addProduct(new Product("만두", 3500, "닭가슴살로 만들어 부담이 적은 만두", 1000));
        foods.addProduct(new Product("컵라면", 1500, "한 끼로 든든하게 먹을 수 있는 라면", 10000));
        foods.addProduct(new Product("제로 음료", 2500, "당과 칼로리가 제로여서 건강에 좋은 음료", 3500));
        foods.addProduct(new Product("맥반석 구운 계란", 350, "건강과 다이어트를 동시에 챙기는 달걀", 50000));

        return new ArrayList<>(List.of(electronics, kitchen, foods));
    }
}
