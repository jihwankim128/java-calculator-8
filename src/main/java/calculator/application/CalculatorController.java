package calculator.application;

import calculator.domain.Calculator;
import calculator.ui.CalculatorView;

public class CalculatorController {

    private final CalculatorFactory calculatorFactory;
    private final CalculatorView calculatorView;

    public CalculatorController(CalculatorView calculatorView, CalculatorFactory calculatorFactory) {
        this.calculatorFactory = calculatorFactory;
        this.calculatorView = calculatorView;
    }

    public void run() {
        Calculator textCalculator = calculatorFactory.getTextCalculator();

        calculatorView.printInputPrompt();
        String expression = calculatorView.readExpression();

        Number result = textCalculator.calculate(expression);
        calculatorView.printResult(result);
    }
}
