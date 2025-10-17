package calculator.domain.toknizer;

import calculator.domain.DelimiterTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefaultDelimiterTokenizer implements DelimiterTokenizer {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    private static String[] splitByDelimiter(String expression, Matcher matcher) {
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String pureExpression = matcher.group(2);
            String delimiterRegex = DEFAULT_DELIMITER_REGEX + "|" + Pattern.quote(customDelimiter);
            return pureExpression.split(delimiterRegex, -1);
        }
        return expression.split(DEFAULT_DELIMITER_REGEX, -1);
    }

    @Override
    public String[] tokenize(String expression) {
        if (expression == null || expression.isEmpty()) {
            return new String[0];
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(expression);
        return splitByDelimiter(expression, matcher);
    }
}
