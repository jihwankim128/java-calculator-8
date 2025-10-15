package calculator.v1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    private final List<BigInteger> numbers = new ArrayList<>();

    public StringCalculator(String expression) {
        if (expression == null || expression.isEmpty()) {
            return;
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(expression);
        String delimiterRegex = "[,:]";
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            expression = matcher.group(2);
            delimiterRegex = delimiterRegex + "|" + Pattern.quote(customDelimiter);
        }

        String[] stringNumbers = expression.split(delimiterRegex, -1);
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
