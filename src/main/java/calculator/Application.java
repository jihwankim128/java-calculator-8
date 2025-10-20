package calculator;

import calculator.application.CalculatorController;
import calculator.domain.Calculator;
import calculator.domain.calculator.BigNumberTextCalculator;
import calculator.domain.parser.TextBigNumberParser;
import calculator.domain.tokenizer.SimpleDelimiterTokenizer;
import calculator.ui.CalculatorView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        CalculatorView calculatorView = new CalculatorView();
        Calculator textCalculator = getTextCalculator();
        CalculatorController calculatorController = new CalculatorController(calculatorView, textCalculator);

        calculatorController.run();

        Console.close();
    }

    private static BigNumberTextCalculator getTextCalculator() {
        return new BigNumberTextCalculator(
                new SimpleDelimiterTokenizer(),
                new TextBigNumberParser()
        );
    }
}
