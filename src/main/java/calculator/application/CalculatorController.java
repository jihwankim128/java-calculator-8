package calculator.application;

import calculator.domain.DelimiterTokenizer;
import calculator.domain.NumberParser;
import calculator.domain.TextCalculator;
import calculator.domain.parser.TextNumberParser;
import calculator.domain.toknizer.SimpleDelimiterTokenizer;
import calculator.ui.CalculatorView;
import java.math.BigInteger;

public class CalculatorController {

    private final TextCalculator textCalculator;
    private final CalculatorView calculatorView;

    public CalculatorController(CalculatorView calculatorView) {
        DelimiterTokenizer delimiterTokenizer = new SimpleDelimiterTokenizer();
        NumberParser numberParser = new TextNumberParser();
        this.textCalculator = new TextCalculator(delimiterTokenizer, numberParser);
        this.calculatorView = calculatorView;
    }

    public void run() {
        calculatorView.printInputPrompt();
        String expression = calculatorView.readExpression();
        BigInteger result = textCalculator.calculate(expression);
        calculatorView.printResult(result);
    }
}
