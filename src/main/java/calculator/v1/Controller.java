package calculator.v1;

import java.math.BigInteger;

public class Controller {

    private final View view;

    public Controller(View view) {
        this.view = view;
    }

    public void run() {
        view.showStringInput();
        String expression = view.readStringExpression();
        StringCalculator stringCalculator = new StringCalculator(expression);
        BigInteger result = stringCalculator.sum();
        view.showResult(result);
    }
}
