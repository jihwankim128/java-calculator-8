package calculator.domain;

import java.math.BigInteger;

public class PositiveNumber<T extends Number & Comparable<T>> {

    private final T value;

    private PositiveNumber(T value, T zero) {
        if (value.compareTo(zero) <= 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
        this.value = value;
    }

    public static PositiveNumber<BigInteger> of(BigInteger number) {
        return new PositiveNumber<>(number, BigInteger.ZERO);
    }

    public static PositiveNumber<Integer> of(Integer number) {
        return new PositiveNumber<>(number, 0);
    }

    public static PositiveNumber<Long> of(Long number) {
        return new PositiveNumber<>(number, 0L);
    }

    public T getValue() {
        return value;
    }
}