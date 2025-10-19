package calculator.application;

import calculator.domain.DefaultTextCalculator;
import calculator.domain.TextCalculator;
import calculator.domain.parser.TextBigNumberParser;
import calculator.domain.tokenizer.SimpleDelimiterTokenizer;

public class CalculatorFactory {

    public TextCalculator getTextCalculator() {
        return new DefaultTextCalculator(
                new SimpleDelimiterTokenizer(),
                new TextBigNumberParser()
        );
    }
}
