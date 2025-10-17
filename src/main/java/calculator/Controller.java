package calculator;

import java.math.BigInteger;

public class Controller {

    private final View view;

    public Controller(View view) {
        this.view = view;
    }

    public void run() {
        view.showStringInput();
        String expression = view.readStringExpression();
        Calculator calculator = new Calculator(expression);
        BigInteger result = calculator.calculate();
        view.showResult(result);
    }
}
