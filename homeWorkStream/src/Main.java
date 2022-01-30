import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> allProducts = ListsGenerator.createProducts();
        List<Order> allOrders = ListsGenerator.allOrders();

        System.out.println("Упражнение 1. Получите список товаров (Product), " +
                "относящихся к категории \"Книги\" с ценой > 100.");
        allProducts.stream()
                .filter(x -> x.getCategory().equals("Book"))
                .filter(x -> x.getPrice() > 100)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Упражнение 2. Получите список заказов с товарами (Order), относящимися к категории Детские");

        allOrders.stream()
                .filter(x -> x.getProducts().stream()
                        .anyMatch(y -> y.getCategory().equals("Children")))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Упражнение 3. Получите список товаров (Product) с категорией" +
                " \"Игрушки\" и скидкой 10% для каждого товара.");

        allProducts.stream()
                .filter(x -> x.getCategory().equals("Toys"))
                .map(y -> y.getPrice() * 0.9)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Упражнение 4. Получите список товаров (Product), заказанных клиентом уровня 2 " +
                "(поле tier класса Customer) в период с 01.10.2021. по 01.11.2021.");

        allOrders.stream()
                .filter(o -> o.getCustomer().getTier() == 2)
                .filter(o -> o.getOrderData().compareTo(LocalDate.of(2021, 10, 1)) >= 0)
                .filter(o -> o.getOrderData().compareTo(LocalDate.of(2021, 11, 1)) <= 0)
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Упражнение 5. Получите самый дешевый товар (Product) категории \"Книги\".");
        System.out.println(allProducts.stream()
                .filter(x -> x.getCategory().equals("Book"))
                .sorted(Comparator.comparing(Product::getPrice))
                .findFirst());

        System.out.println();


        System.out.println("Упражнение 6. Получите 3 последних размещенных заказа (Order).");
        allOrders.stream()
                .sorted(Comparator.comparing(Order::getOrderData).reversed())
                .limit(3)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Упражнение 7. Получите список заказов (Order), которые были заказаны 15.11.2021 года, " +
                "выведите заказы в консоль и затем верните список продуктов, заказанных в этот день..");
        allOrders.stream()
                .filter(o -> o.getOrderData().isEqual(LocalDate.of(2021, 11, 15)))
                .peek(o -> System.out.println(o.toString()))
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Упражнение 8. Получите Map<Order, Double> с заказами и общей суммой стоимости продуктов.");

        Map<Order, Double> map = new HashMap<>();
        for (Order order : allOrders) {
            map.put(order, order.getProducts().stream().map(Product::getPrice).reduce((double) 0, Double::sum));
        }
        System.out.println(map);


    }

}
