package calculator;

import calculator.application.Controller;
import calculator.ui.View;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        controller.run();

        Console.close();
    }
}
