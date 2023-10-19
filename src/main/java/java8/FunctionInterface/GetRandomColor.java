package java8.FunctionInterface;

import java.util.Random;
import java.util.function.Supplier;

public class GetRandomColor implements Supplier<String> {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = new GetRandomColor();
        System.out.println(stringSupplier.get());
    }

    private static final String[] COLORS = {"red", "green", "blue", "yellow", "pink",
            "black", "white"};

    @Override
    public String get() {
        return COLORS[new Random().nextInt(COLORS.length)];
    }

}
