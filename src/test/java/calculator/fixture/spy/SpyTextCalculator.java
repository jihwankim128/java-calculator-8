package calculator.fixture.spy;

import static calculator.fixture.CallName.CALCULATOR_CALCULATE;

import calculator.domain.DelimiterTokenizer;
import calculator.domain.NumberParser;
import calculator.domain.TextCalculator;
import calculator.fixture.ControllerRecorder;

public class SpyTextCalculator extends TextCalculator {

    private final ControllerRecorder recorder;
    
    public SpyTextCalculator(ControllerRecorder recorder, DelimiterTokenizer tokenizer, NumberParser parser) {
        super(tokenizer, parser);
        this.recorder = recorder;
    }
    
    @Override
    public Number calculate(String expression) {
        recorder.record(CALCULATOR_CALCULATE);
        return super.calculate(expression);
    }
}