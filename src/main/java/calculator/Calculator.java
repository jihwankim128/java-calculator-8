package calculator;

import java.math.BigInteger;

public class Calculator {

    private final Numbers numbers = new Numbers();
    private final DelimiterTokenizer delimiterTokenizer = new CustomDelimiterTokenizer();

    public Calculator(String expression) {
        if (expression == null || expression.isEmpty()) {
            return;
        }

        String[] values = delimiterTokenizer.tokenize(expression);
        for (String value : values) {
            PositiveNumber number = PositiveNumber.from(value);
            numbers.add(number);
        }
    }

    public BigInteger calculate() {
        return numbers.sum();
    }
}
