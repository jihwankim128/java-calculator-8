package calculator;

import java.math.BigInteger;

public class Controller {

    private final Calculator calculator;
    private final View view;

    public Controller(View view) {
        this.view = view;
        this.calculator = new Calculator(new DefaultDelimiterTokenizer(), new DefaultNumberParser());
    }

    public void run() {
        view.showStringInput();
        String expression = view.readStringExpression();
        BigInteger result = calculator.calculate(expression);
        view.showResult(result);
    }
}
