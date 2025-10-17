package calculator;

import java.math.BigInteger;

public class Calculator {

    private final DelimiterTokenizer delimiterTokenizer;
    private final NumberParser numberParser;

    public Calculator(DelimiterTokenizer delimiterTokenizer, NumberParser numberParser) {
        this.delimiterTokenizer = delimiterTokenizer;
        this.numberParser = numberParser;
    }

    public BigInteger calculate(String expression) {
        Numbers numbers = new Numbers();
        String[] values = delimiterTokenizer.tokenize(expression);
        for (String value : values) {
            BigInteger number = numberParser.parse(value);
            PositiveNumber positiveNumber = PositiveNumber.of(number);
            numbers.add(positiveNumber);
        }
        return numbers.sum();
    }
}
