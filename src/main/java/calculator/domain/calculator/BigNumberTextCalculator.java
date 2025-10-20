package calculator.domain.calculator;

import calculator.domain.DelimiterTokenizer;
import calculator.domain.NumberParser;
import calculator.domain.TextCalculator;
import java.math.BigInteger;

public class BigNumberTextCalculator extends TextCalculator<BigInteger> {

    public BigNumberTextCalculator(DelimiterTokenizer delimiterTokenizer, NumberParser<BigInteger> numberParser) {
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
