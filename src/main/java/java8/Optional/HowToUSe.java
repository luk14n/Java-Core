package java8.Optional;

import java.util.Optional;

public class HowToUSe {
    public static void main(String[] args) {
        // Optional in use
        // - ifPresent
        Db db = new Db();
        Optional<User> optionalUser = db.getById(10L);
        optionalUser.ifPresent(System.out::println);

        // - orElse
        Optional<User> dbById11 = db.getById(11L);
        User alice = dbById11.orElse(new User("Alice", 22));
        // or Else returns default value in case our passed data
        // is null (11L there is no user with such ID), so it
        //returns alice as plan B
        System.out.println(alice);

        // - orElseGet

        Optional<User> optional = db.getById(11L);
        System.out.println(optional.orElseGet(HowToUSe::getDeafaultUser));


        // - orElseThrow
        Optional<User> optionalUser1 = db.getById(11L);
        optionalUser1.orElseThrow(() -> new RuntimeException(
                "Can't find user"));
    }

    private static User getDeafaultUser() {
        return new User("Bill", 22);
    }

}
