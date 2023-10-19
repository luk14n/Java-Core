package java8.Optional;

import java.util.Optional;

public class Main1 {
    public static void main(String[] args) {
        //How to create Optional?
        //of
        //empty
        //ofNullable

        Optional<String> of = Optional.of("abc");
        Optional<String> empty = Optional.empty();
        Optional<Object> ofNullable = Optional.ofNullable(null);
        Optional<String> elementByIndex = Optional
                .ofNullable(getElementByIndex(new String[]{}, 2));
        System.out.println(of.get());
        System.out.println(empty.get());
        System.out.println(ofNullable.get());
        System.out.println(elementByIndex.get());
    }

    private static String getElementByIndex(String[] values, int index) {
        if (index >= values.length || index < 0) {
            return null;
        }
        return values[index];
    }
}