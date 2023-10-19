package java8.Optional.PR;

import java.util.NoSuchElementException;
import java.util.Optional;
//У цьому завданні заверши реалізацію методів generateRandomOptional() та getOptionalValue().
//
//Метод generateRandomOptional() має повернути:
//
//Optional зі значенням randomNumber, якщо randomNumber є непарним;
//пустий Optional, якщо randomNumber є парним.
//Метод getOptionalValue() має викликати generateRandomOptional(), прийняти Optional та повернути його значення,
// а якщо значення відсутнє — повернути NoSuchElementException.
public class GetOptionalValue {
  public static void main(String[] args) {
    System.out.println(getOptionalValue(5));
  }
  public static Integer getOptionalValue(int randomNumber) {
    Optional<Integer> optional = generateRandomOptional(randomNumber);
      return optional.orElseThrow(NoSuchElementException::new).intValue();
  }

  public static Optional<Integer> generateRandomOptional(int randomNumber) {
    if (randomNumber % 2 != 0) {
      return Optional.of(randomNumber);
    }
    return Optional.empty();
  }
}
