import java.util.List;

public class Main {
    public static void main(String[] args) {
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


        CommerceSystem commerceSystem = new CommerceSystem(List.of(electronics, kitchen));
        commerceSystem.start();
    }
}
