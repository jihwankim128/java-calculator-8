package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigInteger;

public class View {
    public void showStringInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String readStringExpression() {
        return Console.readLine();
    }

    public void showResult(BigInteger result) {
        System.out.println("결과 : " + result);
    }
}
