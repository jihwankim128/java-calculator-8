package calculator.domain.tokenizer;

import calculator.domain.DelimiterTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleDelimiterTokenizer extends DelimiterTokenizer {

    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\\\\n(.*)");
    private static final Pattern MULTIPLE_DELIMITER_PATTERN = Pattern.compile("//.*\\\\n//");
    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    
    @Override
    protected String[] parseExpression(String expression) {
        validateNotMultipleDelimiters(expression);
        
        if (expression.startsWith(CUSTOM_DELIMITER_PREFIX)) {
            return parseWithCustomDelimiter(expression);
        }
        return expression.split(DEFAULT_DELIMITER_REGEX, -1);
    }

    private String[] parseWithCustomDelimiter(String expression) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(expression);
        validateCustomDelimiterFormat(matcher);

        String customDelimiter = matcher.group(1);
        String numbersExpression = matcher.group(2);
        String delimiterRegex = DEFAULT_DELIMITER_REGEX + "|" + Pattern.quote(customDelimiter);
        return numbersExpression.split(delimiterRegex, -1);
    }

    private void validateNotMultipleDelimiters(String expression) {
        Matcher multiplePattern = MULTIPLE_DELIMITER_PATTERN.matcher(expression);
        if (multiplePattern.find()) {
            throw new IllegalArgumentException("커스텀 구분자는 한 개만 사용할 수 있습니다.");
        }
    }

    private void validateCustomDelimiterFormat(Matcher matcher) {
        if (!matcher.find()) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다. (올바른 형식: //;\\\\n1,2,3)");
        }
    }
}
