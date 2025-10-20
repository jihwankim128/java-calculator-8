package calculator.domain;

import java.math.BigInteger;

public class DefaultTextCalculator extends TextCalculator<BigInteger> {

    public DefaultTextCalculator(DelimiterTokenizer delimiterTokenizer, NumberParser<BigInteger> numberParser) {
        super(delimiterTokenizer, numberParser);
    }

    @Override
    protected Numbers<BigInteger> parseNumbers(String[] tokens) {
        Numbers<BigInteger> numbers = new Numbers<>();
        for (String token : tokens) {
            BigInteger number = numberParser.parse(token);
            PositiveNumber<BigInteger> positiveNumber = PositiveNumber.of(number);
            numbers.add(positiveNumber);
        }
        return numbers;
    }

    @Override
    protected BigInteger sum(Numbers<BigInteger> numbers) {
        return numbers.sum(BigInteger.ZERO, BigInteger::add);
    }
}
