package calculator.v1;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private final List<Long> numbers = new ArrayList<>();

    public StringCalculator(String expression) {
        if (expression == null || expression.isEmpty()) {
            return;
        }
        String[] stringNumbers = expression.split(DEFAULT_DELIMITER_REGEX);
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
