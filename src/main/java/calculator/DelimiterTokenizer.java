package calculator;

@FunctionalInterface
public interface DelimiterTokenizer {

    String[] tokenize(String expression);
}
