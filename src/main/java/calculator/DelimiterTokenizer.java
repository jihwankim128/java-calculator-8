package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterTokenizer {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    private DelimiterTokenizer() {}

    public static String[] tokenize(String expression) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(expression);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String pureExpression = matcher.group(2);
            String delimiterRegex = DEFAULT_DELIMITER_REGEX + "|" + Pattern.quote(customDelimiter);
            return pureExpression.split(delimiterRegex, -1);
        }
        return expression.split(DEFAULT_DELIMITER_REGEX, -1);
    }
}
