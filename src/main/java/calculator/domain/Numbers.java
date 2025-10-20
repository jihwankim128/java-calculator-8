package calculator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Numbers<T extends Number & Comparable<T>> {

    private final List<PositiveNumber<T>> numbers = new ArrayList<>();

    public void add(PositiveNumber<T> number) {
        numbers.add(number);
    }

    public T sum(T base, BinaryOperator<T> operator) {
        T result = base;
        for (PositiveNumber<T> number : numbers) {
            T operation = number.getValue();
            result = operator.apply(result, operation);
        }
        return result;
    }
}
