package calculator.domain;

@FunctionalInterface
public interface DelimiterTokenizer {

    String[] tokenize(String expression);
}
