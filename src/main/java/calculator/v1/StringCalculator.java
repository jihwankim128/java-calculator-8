package calculator.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");

    private final List<Long> numbers = new ArrayList<>();

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

        String[] stringNumbers = expression.split(delimiterRegex);
        for (String stringNumber : stringNumbers) {
            try {
                long number = Long.parseLong(stringNumber.trim());
                if (number <= 0) {
                    throw new IllegalArgumentException();
                }

                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    public long sum() {
        long sum = 0;
        for (Long number : numbers) {
            sum += number;
        }
        return sum;
    }
}
