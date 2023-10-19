package java8.Optional;

import java.util.Optional;

public class Db {
    public Optional<User> getById(Long id) {
        if (id == 10) {
            return Optional.of(new User("Bob", 22));
        }
        return Optional.empty();
    }
}
