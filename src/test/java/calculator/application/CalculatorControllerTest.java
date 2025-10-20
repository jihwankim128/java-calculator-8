package calculator.application;

import calculator.domain.Calculator;
import calculator.fixture.CallName;
import calculator.fixture.ControllerRecorder;
import calculator.fixture.spy.SpyCalculatorView;
import calculator.fixture.spy.SpyTextCalculator;
import calculator.fixture.stub.DelimiterTokenizerStub;
import calculator.ui.CalculatorView;
import java.math.BigInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest {

    ControllerRecorder recorder;
    Calculator calculator;
    CalculatorView view;

    @BeforeEach
    void setUp() {
        recorder = new ControllerRecorder();
        calculator = new SpyTextCalculator(recorder, new DelimiterTokenizerStub(), value -> BigInteger.TEN);
        view = new SpyCalculatorView(recorder);
    }

    @Test
    void 어플리케이션의_전체_흐름이_순서대로_수행된다() {
        // given
        CalculatorController controller = new CalculatorController(view, calculator);

        // when
        controller.run();

        // then
        recorder.verifyCalled(CallName.VIEW_PRINT_INPUT_PROMPT);
        recorder.verifyCalled(CallName.VIEW_READ_EXPRESSION);
        recorder.verifyCalled(CallName.CALCULATOR_CALCULATE);
        recorder.verifyCalled(CallName.VIEW_PRINT_RESULT);
    }
}