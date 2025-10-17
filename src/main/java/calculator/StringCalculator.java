package calculator;

import static calculator.DelimiterTokenizer.tokenize;
import static calculator.NumberParser.parse;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private final List<BigInteger> numbers = new ArrayList<>();

    public StringCalculator(String expression) {
        if (expression == null || expression.isEmpty()) {
            return;
        }

        String[] stringNumbers = tokenize(expression);
        for (String stringNumber : stringNumbers) {
            BigInteger number = parse(stringNumber);
            validatePositive(number);
            numbers.add(number);
        }
    }

    private static void validatePositive(BigInteger number) {
        if (number.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public BigInteger sum() {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }
}
