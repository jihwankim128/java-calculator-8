package calculator.domain;

public abstract class DelimiterTokenizer {

    public final String[] tokenize(String expression) {
        if (expression == null || expression.isEmpty()) {
            return new String[0];
        }
        return parseExpression(expression);
    }

    protected abstract String[] parseExpression(String expression);
}
