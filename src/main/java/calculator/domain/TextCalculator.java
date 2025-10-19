package calculator.domain;

public abstract class TextCalculator {

    private final DelimiterTokenizer delimiterTokenizer;

    public TextCalculator(DelimiterTokenizer delimiterTokenizer) {
        this.delimiterTokenizer = delimiterTokenizer;
    }

    public Number calculate(String expression) {
        String[] tokens = delimiterTokenizer.tokenize(expression);
        Numbers numbers = parseNumbers(tokens);
        return numbers.sum();
    }

    protected abstract Numbers parseNumbers(String[] tokens);
}
