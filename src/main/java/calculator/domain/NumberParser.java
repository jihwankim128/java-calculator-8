package calculator.domain;

@FunctionalInterface
public interface NumberParser<T extends Number> {

    T parse(String value);
}
