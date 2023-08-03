package app.task2;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        getOutput(filterData(getInitData()));
    }
    private static Map<String, Double> getInitData() {
        return Map.of(
                "onion", 1.25,
                "potato", 1.05,
                "tomato", 3.05,
                "cucumber", 1.4,
                "red pepper", 2.50,
                "carrot", 1.70,
                "greens", 1.50);
    }

    private static void getOutput(Stream<String> products) {
        System.out.println("Products with price lower than 2.00:");
        AtomicInteger counter = new AtomicInteger(1);
        products.forEach(name -> System.out.println(counter.getAndIncrement() + ") " + name));
    }

    private static Stream<String> filterData(Map<String, Double> products) {
        return products.entrySet().stream()
                .filter(product -> product.getValue() <= 2.0)
                .map(Map.Entry::getKey);
    }
}
