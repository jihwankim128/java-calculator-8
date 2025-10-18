package calculator.application;

import calculator.domain.Calculator;
import calculator.domain.DelimiterTokenizer;
import calculator.domain.NumberParser;
import calculator.domain.parser.TextNumberParser;
import calculator.domain.toknizer.DefaultDelimiterTokenizer;
import calculator.ui.CalculatorView;
import java.math.BigInteger;

public class CalculatorController {

    private final Calculator calculator;
    private final CalculatorView calculatorView;

    public CalculatorController(CalculatorView calculatorView) {
        DelimiterTokenizer delimiterTokenizer = new DefaultDelimiterTokenizer();
        NumberParser numberParser = new TextNumberParser();
        this.calculator = new Calculator(delimiterTokenizer, numberParser);
        this.calculatorView = calculatorView;
    }

    public void run() {
        calculatorView.printInputPrompt();
        String expression = calculatorView.readExpression();
        BigInteger result = calculator.calculate(expression);
        calculatorView.printResult(result);
    }
}
