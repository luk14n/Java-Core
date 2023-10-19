package java8.Optional;

import java.util.Optional;

//Optional was invented in order to minimize occurrence of NPE
public class Main {
    public static void main(String[] args) {
        User[] users = new User[] {new User("Bob", 22)};
        Optional<User> Optional = getElementByIndex(users, 10);
        Optional.ifPresent(System.out::println);
    }
    private static Optional<User> getElementByIndex(User[] values, int index) {
        if (index >= values.length || index < 0) {
            return Optional.empty();
        }
        return Optional.of(values[index]);
    }
}
