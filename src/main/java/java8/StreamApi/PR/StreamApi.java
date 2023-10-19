package java8.StreamApi.PR;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        System.out.println(getOddNumsSum(List.of(1, 2, 3, 4)));
        System.out.println(calculateOccurrences(List.of("1", "1", "2", "3"), "1"));
        System.out.println(getFirstElement(List.of("1", "1", "2", "3")));
        System.out.println(getThreeSmallestNumbers(new int[]{4, 1, 10, 20, 11, 3}));
    }

    /**
     * Given a List of Integer numbers,
     * return a sum of odd numbers or 0, if there are no odd numbers in the List.
     */
    public static Integer getOddNumsSum(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * Given a List of Strings,
     * return a number of times the `element` String occurs in the List.
     */
    public static Long calculateOccurrences(List<String> elements, String element) {
        return elements.stream()
                .filter(s -> s.equals(element))
                .count();
    }

    /**
     * Given a List of Strings, return the Optional of its first element.
     */
    public static Optional<String> getFirstElement(List<String> elements) {
        return elements.stream()
                .findFirst();
    }

    /**
     * Given an array of ints, return three smallest numbers as list in sorted manner.
     * For example for input {4, 1, 10, 20, 11, 3} output will be {1, 3, 4};
     */
    public static List<Integer> getThreeSmallestNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * Given a List of Strings,
     * find the String equal to the passed `element` or throw NoSuchElementException.
     */
    public String findElement(List<String> elements, String element) {
        return elements.stream()
                .filter(e -> e.equals(element))
                .findAny().orElseThrow(NoSuchElementException::new);
    }
}
