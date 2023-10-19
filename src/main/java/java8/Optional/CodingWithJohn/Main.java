package java8.Optional.CodingWithJohn;

import java8.Optional.User;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Optional<User> user = findUserByName("Lol");
        System.out.println(user.map(User::getName) // can transform optional as a Stream
                .orElseThrow(() -> new RuntimeException("Fu*k you")));
    }
    private static Optional<User> findUserByName(String name) {
        User user = new User(name, 22);
        return Optional.ofNullable(user); // If you 100% know that passed
        // object can't be null that use .of

        // OPTIONALS WERE ONLY INTENDED TO BE USED THEM AS A RETURN PARAMETER TO AVOID NPE
    }
}
