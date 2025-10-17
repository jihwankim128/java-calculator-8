package calculator.domain;

import java.math.BigInteger;

public class PositiveNumber {

    private final BigInteger value;

    private PositiveNumber(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("양수만 입력 가능합니다.");
        }
        this.value = value;
    }

    public static PositiveNumber of(BigInteger number) {
        return new PositiveNumber(number);
    }

    public BigInteger getValue() {
        return value;
    }
}