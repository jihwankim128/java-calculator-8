package calculator.application;

import calculator.domain.TextCalculator;
import calculator.domain.parser.TextNumberParser;
import calculator.domain.toknizer.SimpleDelimiterTokenizer;

public class CalculatorFactory {

    public TextCalculator getTextCalculator() {
        return new TextCalculator(
                new SimpleDelimiterTokenizer(),
                new TextNumberParser()
        );
    }
}
