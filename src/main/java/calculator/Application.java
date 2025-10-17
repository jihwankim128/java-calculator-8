package calculator;

import calculator.application.CalculatorController;
import calculator.ui.CalculatorView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        CalculatorView calculatorView = new CalculatorView();
        CalculatorController calculatorController = new CalculatorController(calculatorView);
        calculatorController.run();

        Console.close();
    }
}
