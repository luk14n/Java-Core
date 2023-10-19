package java8.StreamApi.PR;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiMedium {
    private static final int YEAR_INDEX = 0;

    public static void main(String[] args) {
        System.out.println(getVisitorsPerYear(List.of("John Stevenson:2020", "John Stevenson:2020", "Andrew Ferguson:2020", "Andrew Ferguson:2013"), 2020));
        System.out.println(getCompanies(Map.of("Sun.ltd", 20_000, "Micro", -5_200, "Clarity", 0, "Odyssey", 9_640)));
        System.out.println(convertAndModifyNumbers(List.of(-533, 121, 44, 11, 27, 450)));
        System.out.println(charsIncrementation("abc", 2));
        System.out.println(getOldestPersonAge(List.of("99:Johny", "20:Brad")));
    }

    /**
     * Given list strings representing records of patients' visits to a Hospital
     * {"John Stevenson:2020", "Andrew Ferguson:2012", "Andrew Ferguson:2013"}.
     * Return number of unique persons who have visited hospital during the given year (second input param).
     * Be careful, because one person may visit a hospital several times per year and for each visit new record
     * will be generated. Result shouldn't contain duplicates.
     */
    public static Long getVisitorsPerYear(List<String> records, int year) {
        return records.stream()
                .filter(e -> e.contains(String.valueOf(year)))
                .distinct()
                .count();

    }

    /**
     * Given a map with the following view : "company name" - "monthly income delta"  (String/Integer)
     * Return list of the companies with positive delta. Their names should be sorted alphabetically
     * Example input : {"Sun.ltd" : 20_000}, {"Micro" : -5_200}, {"Clarity": 0}, {"Odyssey": 9_640};
     * Output : {"Odyssey", "Sun.ltd"}
     */
    public static List<String> getCompanies(Map<String, Integer> input) {
        return input.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .map(Map.Entry::getKey)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Given a list of integer numbers, convert each integer into it's binary representation in string format
     * and join all of them into a single string and putting each value into brackets, it should look like this:
     * Input: {1, 20, 33}
     * Output:
     * (1)
     * (10100)
     * (100001)
     */
    public static String convertAndModifyNumbers(List<Integer> numbers) {
        StringBuilder builder = new StringBuilder();
        numbers.stream()
                .map(n -> "(" + Integer.toBinaryString(n) + ")\n")
                .forEach(builder::append);
        return builder.toString();
    }

    /**
     * Given string value. Your task is
     * to increment char value of each symbol from the string. Amount to increment is
     * passed with the second input param - 'increment'
     */
    public static String charsIncrementation(String string, int increment) {
        StringBuilder builder = new StringBuilder();
        string.chars()
                .boxed()
                .map(c -> c + increment)
                .forEach(builder::append);
        return builder.toString();
    }

    /**
     * Given List of string where each element represents persons' age and name:
     * {"99:Johny", "20:Brad", ...} return the age of the oldest person
     */
    public static Long getOldestPersonAge(List<String> people) {
        return (long) people.stream()
                .map(s -> s.substring(0, s.indexOf(":")))
                .mapToInt(Integer::parseInt)
                .max().getAsInt();
    }
}
