package calculator.application;

import calculator.domain.DefaultTextCalculator;
import calculator.domain.TextCalculator;
import calculator.domain.parser.TextNumberParser;
import calculator.domain.toknizer.SimpleDelimiterTokenizer;

public class CalculatorFactory {

    public TextCalculator getTextCalculator() {
        return new DefaultTextCalculator(
                new SimpleDelimiterTokenizer(),
                new TextNumberParser()
        );
    }
}
