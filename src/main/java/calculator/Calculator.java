package calculator;

import java.math.BigInteger;

public class Calculator {

    private final DelimiterTokenizer delimiterTokenizer = new CustomDelimiterTokenizer();
    private final NumberParser numberParser = new DefaultNumberParser();
    private final Numbers numbers = new Numbers();

    public Calculator(String expression) {
        if (expression == null || expression.isEmpty()) {
            return;
        }

        String[] values = delimiterTokenizer.tokenize(expression);
        for (String value : values) {
            BigInteger number = numberParser.parse(value);
            PositiveNumber positiveNumber = PositiveNumber.of(number);
            numbers.add(positiveNumber);
        }
    }

    public BigInteger calculate() {
        return numbers.sum();
    }
}
