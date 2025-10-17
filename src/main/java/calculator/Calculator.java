package calculator;

import static calculator.DelimiterTokenizer.tokenize;

import java.math.BigInteger;

public class Calculator {

    private final Numbers numbers = new Numbers();

    public Calculator(String expression) {
        if (expression == null || expression.isEmpty()) {
            return;
        }

        String[] values = tokenize(expression);
        for (String value : values) {
            PositiveNumber number = PositiveNumber.from(value);
            numbers.add(number);
        }
    }

    public BigInteger calculate() {
        return numbers.sum();
    }
}
