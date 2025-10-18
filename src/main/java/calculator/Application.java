package calculator;

import calculator.application.CalculatorController;
import calculator.application.CalculatorFactory;
import calculator.ui.CalculatorView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        CalculatorView calculatorView = new CalculatorView();
        CalculatorFactory calculatorFactory = new CalculatorFactory();
        CalculatorController calculatorController = new CalculatorController(calculatorView, calculatorFactory);

        calculatorController.run();

        Console.close();
    }
}
