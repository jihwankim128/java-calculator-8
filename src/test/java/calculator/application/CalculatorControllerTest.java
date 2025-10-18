package calculator.application;

import calculator.fixture.CallName;
import calculator.fixture.ControllerRecorder;
import calculator.fixture.spy.SpyCalculatorFactory;
import calculator.fixture.spy.SpyCalculatorView;
import calculator.ui.CalculatorView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorControllerTest {

    ControllerRecorder recorder;
    CalculatorFactory factory;
    CalculatorView view;

    @BeforeEach
    void setUp() {
        recorder = new ControllerRecorder();
        factory = new SpyCalculatorFactory(recorder);
        view = new SpyCalculatorView(recorder);
    }

    @Test
    void 어플리케이션의_전체_흐름이_순서대로_수행된다() {
        // given
        CalculatorController controller = new CalculatorController(view, factory);

        // when
        controller.run();

        // then
        recorder.verifyCalled(CallName.FACTORY_GET_TEXT_CALCULATOR);
        recorder.verifyCalled(CallName.VIEW_PRINT_INPUT_PROMPT);
        recorder.verifyCalled(CallName.VIEW_READ_EXPRESSION);
        recorder.verifyCalled(CallName.CALCULATOR_CALCULATE);
        recorder.verifyCalled(CallName.VIEW_PRINT_RESULT);
    }
}