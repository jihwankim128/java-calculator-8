package calculator.application;

import calculator.domain.Calculator;
import calculator.ui.CalculatorView;

public class CalculatorController {

    private final Calculator textCalculator;
    private final CalculatorView calculatorView;

    public CalculatorController(CalculatorView calculatorView, Calculator textCalculator) {
        this.textCalculator = textCalculator;
        this.calculatorView = calculatorView;
    }

    public void run() {
        calculatorView.printInputPrompt();
        String expression = calculatorView.readExpression();

        Number result = textCalculator.calculate(expression);
        calculatorView.printResult(result);
    }
}
