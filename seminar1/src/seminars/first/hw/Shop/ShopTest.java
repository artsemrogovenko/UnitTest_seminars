package seminars.first.hw.Shop;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class ShopTest {
    private static Shop myshop=new Shop();

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
    public static void main(String[] args) {
       // 1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).

        assertThat(myshop.getProducts()).isNull();

        myshop.setProducts(List.of(
                new Product(0.63, "Провод ШВВП 2х0,5"),
                new Product(2.35, "Кабель ВВГнг-LS 2х2,5"),
                new Product(6.05, "ВВГ-Пнг(А)-LS 3х4 "),
                new Product(1.43, "ПВС 2*1,0 провод белый"),
                new Product(5.40, "Кабель КГтп-ХЛ 3*2,5") ));

        assertThat(myshop.getProducts()).isNotNull();

        // 2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
        assert 6.05 == myshop.getMostExpensiveProduct().getCost();
        assertThat(myshop.getMostExpensiveProduct().getCost()).isNotZero();
        assertThat(myshop.getMostExpensiveProduct().getCost()).isGreaterThanOrEqualTo(2);


        //3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
        System.out.println("\n"+myshop.getProducts());//до сортировки
        assertThat(myshop.sortProductsByPrice().get(myshop.getProducts().size()-1).getCost()).isEqualTo(6.05);
        assertThat(myshop.sortProductsByPrice().get(myshop.getProducts().size()-1).getCost()).isNotZero();
        System.out.println("\n"+myshop.sortProductsByPrice()); // отсортирован
    }
}