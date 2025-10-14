package calculator.v1;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public void showStringInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String readStringExpression() {
        return Console.readLine();
    }

    public void showResult(long result) {
        System.out.println("결과 : " + result);
    }
}
