package calculator.domain;

import java.math.BigInteger;

public class DefaultTextCalculator extends TextCalculator {

    private final NumberParser<BigInteger> numberParser;

    public DefaultTextCalculator(DelimiterTokenizer delimiterTokenizer, NumberParser<BigInteger> numberParser) {
        super(delimiterTokenizer);
        this.numberParser = numberParser;
    }

    @Override
    protected Numbers parseNumbers(String[] tokens) {
        Numbers numbers = new Numbers();
        for (String token : tokens) {
            BigInteger number = numberParser.parse(token);
            PositiveNumber positiveNumber = PositiveNumber.of(number);
            numbers.add(positiveNumber);
        }
        return numbers;
    }
}
