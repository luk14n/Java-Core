package java8.FunctionInterface.AutoType;

import java8.FunctionInterface.AutoType.AutoType;

import java.util.function.Function;

//Реалізуй відповідний функціональний інтерфейс та перевизнач його метод, який:
//
//приймає значення Integer — вагу автомобіля;
//повертає певний AutoType залежно від цієї ваги.
//Якщо вага менше 1500, поверни AutoType.CAR, інакше — AutoType.TRUCK.
public class FindAutoType implements Function<Integer, AutoType> {
    private static final int CAR_WEIGHT_LIMIT = 1500;
    @Override
    public AutoType apply(Integer autoWeight) {
        return autoWeight < CAR_WEIGHT_LIMIT ? AutoType.CAR : AutoType.TRUCK;
    }
}
