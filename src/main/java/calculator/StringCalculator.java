package calculator;

import static calculator.DelimiterTokenizer.tokenize;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private final List<PositiveNumber> numbers = new ArrayList<>();

    public StringCalculator(String expression) {
        if (expression == null || expression.isEmpty()) {
            return;
        }

        String[] values = tokenize(expression);
        for (String value : values) {
            PositiveNumber number = PositiveNumber.from(value);
            numbers.add(number);
        }
    }

    public BigInteger sum() {
        if (numbers.isEmpty()) {
            return BigInteger.ZERO;
        }

        return numbers.stream()
                .map(PositiveNumber::getValue)
                .reduce(BigInteger.ZERO, BigInteger::add);
    }
}
