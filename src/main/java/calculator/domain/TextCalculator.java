package calculator.domain;

import java.math.BigInteger;

public class TextCalculator {

    private final DelimiterTokenizer delimiterTokenizer;
    private final NumberParser numberParser;

    public TextCalculator(DelimiterTokenizer delimiterTokenizer, NumberParser numberParser) {
        this.delimiterTokenizer = delimiterTokenizer;
        this.numberParser = numberParser;
    }

    public BigInteger calculate(String expression) {
        String[] tokens = delimiterTokenizer.tokenize(expression);
        Numbers numbers = parseNumbers(tokens);
        return numbers.sum();
    }

    private Numbers parseNumbers(String[] tokens) {
        Numbers numbers = new Numbers();
        for (String token : tokens) {
            BigInteger number = numberParser.parse(token);
            PositiveNumber positiveNumber = PositiveNumber.of(number);
            numbers.add(positiveNumber);
        }
        return numbers;
    }
}
