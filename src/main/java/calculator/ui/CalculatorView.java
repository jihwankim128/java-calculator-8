package calculator.ui;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class CalculatorView {
    public void printInputPrompt() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String readExpression() {
        return Console.readLine();
    }

    public void printResult(BigInteger result) {
        System.out.println("결과 : " + result);
    }
}
