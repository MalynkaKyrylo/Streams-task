package app.task3;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        getOutput(filterData(getInitData()));
    }

    private static Map<String, Integer> getInitData() {
        return Map.of(
                "Monday", 15,
                "Tuesday", 12,
                "Wednesday", 10,
                "Thursday", 8,
                "Friday", 9,
                "Saturday", 11,
                "Sunday", 13);
    }

    private static Stream<String> filterData(Map<String, Integer> data) {
        return data.entrySet().stream()
                .filter(entry -> entry.getValue() >= 10 && entry.getValue() <= 13)
                .map(Map.Entry::getKey);
    }

    private static void getOutput(Stream<String> data) {
        System.out.println("Days with temperature from +10 to +13 were following:");
        AtomicInteger counter = new AtomicInteger(1);
        data.forEach(day -> System.out.println(counter.getAndIncrement() + ") " + day));
    }
}








