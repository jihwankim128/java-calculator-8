package calculator.domain;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<PositiveNumber> numbers = new ArrayList<>();

    public void add(PositiveNumber number) {
        numbers.add(number);
    }

    public BigInteger sum() {
        BigInteger result = BigInteger.ZERO;
        for (PositiveNumber number : numbers) {
            result = result.add(number.getValue());
        }
        return result;
    }
}
