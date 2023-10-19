package java8.FunctionInterface;

import java.util.function.BinaryOperator;

//У цьому завданні реалізуй відповідний функціональний інтерфейс
// та перевизнач його метод, який:
//
//приймає 2 значення Integer — потужності двох двигунів;
//повертає різницю між ними як Integer.
//Зверни увагу: функціональний інтерфейс, який потрібно реалізувати,
// має бути параметризований лише одним дженеріком.
public class CompareEngineVolumes implements BinaryOperator<Integer> {
    @Override
    public Integer apply(Integer integer, Integer integer2) {
        return integer - integer2;
    }
    //write your code here
}


