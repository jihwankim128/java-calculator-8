package calculator.application;

import calculator.domain.TextCalculator;
import calculator.ui.CalculatorView;

public class CalculatorController {

    private final CalculatorFactory calculatorFactory;
    private final CalculatorView calculatorView;

    public CalculatorController(CalculatorView calculatorView, CalculatorFactory calculatorFactory) {
        this.calculatorFactory = calculatorFactory;
        this.calculatorView = calculatorView;
    }

    public void run() {
        TextCalculator textCalculator = calculatorFactory.getTextCalculator();

        calculatorView.printInputPrompt();
        String expression = calculatorView.readExpression();

        Number result = textCalculator.calculate(expression);
        calculatorView.printResult(result);
    }
}
