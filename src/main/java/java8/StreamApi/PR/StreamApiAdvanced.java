package java8.StreamApi.PR;
//Подивимося, як ти впораєшся із цим завданням. Реалізуй методи класу StreamApiAdvanced за допомогою стрімів.
//
//У цих методах використай об’єкти класів Person та Cat. Кожен об’єкт Person має список об’єктів Cat.
//
//Зауваж, що змінювати сигнатури методів та використовувати цикли не можна.
import java.util.*;
import java.util.stream.Collectors;

public class StreamApiAdvanced {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 25};
    System.out.println(filterAndReverse(arr));
  }

  /**
   * Given array of numbers, your task is to sort them in the reverse order and return only those
   * numbers that can be divided by 5 without a remainder.
   */
  public static List<Integer> filterAndReverse(int[] inputNumbers) {
    List<Integer> collected = Arrays.stream(inputNumbers)
            .boxed()
            .filter(n -> n % 5 == 0)
            .sorted()
            .collect(Collectors.toList());
    Collections.reverse(collected);
    return collected;
  }


  /**
   * We want to gather some statistics: we have list of people and we want to know
   * distribution among the age of women who have cats and are older than 18
   * Result should have the following view: Map.of(19 - List.of(person1, person2, ...),
   * 21 - List.of(person3, person7, ...);
   */
  public Map<Integer, List<Person>> groupByAge(List<Person> people) {
    Map<Integer, List<Person>> result = people
            .stream()
            .filter(p -> p.getSex() == Person.Sex.WOMAN && !p.getCatList().isEmpty() && p.getAge() > 18)
            .collect(Collectors.groupingBy(
                    Person::getAge,
                    Collectors.toList()
            ));

    return result;
  }

  /**
   * Given a list of random strings, group all of them by the last letter from the
   * string. If last char is a number or punctuation - skip the word.
   */
  public Map<Character, List<String>> groupWordsByLastChar(List<String> words) {
    Map<Character, List<String>> result = words
            .stream()
            .filter(word -> Character.isLetter(word.charAt(word.length() - 1)))
            .collect(Collectors.groupingBy(word -> word.charAt(word.length() - 1), Collectors.toList()));
    return result;
   /* Map<Character, List<String>> result = words
            .stream()
            .filter(l -> l.endsWith(String.valueOf(Character.isDigit(l.charAt(words.size() - 1)))))
            .collect(Collectors.groupingBy(words.get(words.size() - 1), Collectors.toList());
    return result;*/
  }
}
