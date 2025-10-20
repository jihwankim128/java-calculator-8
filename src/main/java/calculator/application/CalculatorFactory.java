package calculator.application;

import calculator.domain.Calculator;
import calculator.domain.calculator.BigNumberTextCalculator;
import calculator.domain.parser.TextBigNumberParser;
import calculator.domain.tokenizer.SimpleDelimiterTokenizer;

public class CalculatorFactory {

    public Calculator getTextCalculator() {
        return new BigNumberTextCalculator(
                new SimpleDelimiterTokenizer(),
                new TextBigNumberParser()
        );
    }
}
