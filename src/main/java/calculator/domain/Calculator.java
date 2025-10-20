package calculator.domain;

@FunctionalInterface
public interface Calculator {

    Number calculate(String expression);
}
