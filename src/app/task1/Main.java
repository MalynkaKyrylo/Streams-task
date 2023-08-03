package app.task1;

import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        getOutput(filterData(getInitData(), getLetter()));
    }

    private static Stream<String> getInitData() {
        return Stream.of("Tom", "Bob", "Lisa", "John", "Jack", "Steve", "Linda", "Mike", "Morgan");
    }

    private static Stream<String> filterData(Stream<String> names, Character firstLetter) {
        return names
                .filter(Objects::nonNull)
                .filter(name -> firstLetter.equals(name.charAt(0)));
    }

    private static char getLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first letter of the name to find: ");
        String input = scanner.nextLine();
        if (input.length() > 1) {
            System.out.println("Wrong value");
            getLetter();
            }
        char firstLetter = input.toUpperCase().charAt(0);
        return firstLetter;
    }

    private static void getOutput(Stream<String> names) {
        AtomicInteger counter = new AtomicInteger(0);
        names.forEach(name -> System.out.println(counter.incrementAndGet() + ") " + name));
        if (counter.intValue() == 0) {
            System.out.println("There is no name starting with this letter");
        }
    }





}
