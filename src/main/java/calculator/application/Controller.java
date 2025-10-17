package calculator.application;

import calculator.domain.Calculator;
import calculator.domain.DelimiterTokenizer;
import calculator.domain.NumberParser;
import calculator.domain.parser.DefaultNumberParser;
import calculator.domain.toknizer.DefaultDelimiterTokenizer;
import calculator.ui.View;
import java.math.BigInteger;

public class Controller {

    private final Calculator calculator;
    private final View view;

    public Controller(View view) {
        DelimiterTokenizer delimiterTokenizer = new DefaultDelimiterTokenizer();
        NumberParser numberParser = new DefaultNumberParser();
        this.calculator = new Calculator(delimiterTokenizer, numberParser);
        this.view = view;
    }

    public void run() {
        view.showStringInput();
        String expression = view.readStringExpression();
        BigInteger result = calculator.calculate(expression);
        view.showResult(result);
    }
}
