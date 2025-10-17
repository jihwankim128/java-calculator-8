package calculator;

import static calculator.DelimiterTokenizer.tokenize;

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
            BigInteger number = parseNumber(stringNumber);
            numbers.add(number);
        }
    }

    private static void validatePositive(BigInteger number) {
        if (number.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    private BigInteger parseNumber(String stringNumber) {
        try {
            BigInteger number = new BigInteger(stringNumber);
            validatePositive(number);
            return number;
        } catch (NumberFormatException e) {
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
