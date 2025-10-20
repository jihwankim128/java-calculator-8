package calculator.domain;

import calculator.domain.calculator.Numbers;

public abstract class TextCalculator<T extends Number & Comparable<T>> implements Calculator {

    protected final NumberParser<T> numberParser;
    private final DelimiterTokenizer delimiterTokenizer;

    public TextCalculator(DelimiterTokenizer delimiterTokenizer, NumberParser<T> numberParser) {
        this.delimiterTokenizer = delimiterTokenizer;
        this.numberParser = numberParser;
    }

    @Override
    public Number calculate(String expression) {
        String[] tokens = delimiterTokenizer.tokenize(expression);
        Numbers<T> numbers = parseNumbers(tokens);
        return sum(numbers);
    }

    protected abstract Numbers<T> parseNumbers(String[] tokens);
    protected abstract T sum(Numbers<T> numbers);
}
