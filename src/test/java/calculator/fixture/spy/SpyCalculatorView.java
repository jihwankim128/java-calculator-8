package calculator.fixture.spy;

import static calculator.fixture.CallName.VIEW_PRINT_INPUT_PROMPT;
import static calculator.fixture.CallName.VIEW_PRINT_RESULT;
import static calculator.fixture.CallName.VIEW_READ_EXPRESSION;

import calculator.fixture.ControllerRecorder;
import calculator.ui.CalculatorView;
import java.math.BigInteger;

public class SpyCalculatorView extends CalculatorView {

    private final ControllerRecorder recorder;
    
    public SpyCalculatorView(ControllerRecorder recorder) {
        this.recorder = recorder;
    }

    @Override
    public void printInputPrompt() {
        recorder.record(VIEW_PRINT_INPUT_PROMPT);
    }

    @Override
    public String readExpression() {
        recorder.record(VIEW_READ_EXPRESSION);
        return "";
    }

    @Override
    public void printResult(BigInteger result) {
        recorder.record(VIEW_PRINT_RESULT);
    }
}