package calculator.fixture.spy;

import static calculator.fixture.CallName.CALCULATOR_CALCULATE;

import calculator.domain.DelimiterTokenizer;
import calculator.domain.NumberParser;
import calculator.domain.calculator.BigNumberTextCalculator;
import calculator.fixture.ControllerRecorder;
import java.math.BigInteger;

public class SpyTextCalculator extends BigNumberTextCalculator {

    private final ControllerRecorder recorder;
    
    public SpyTextCalculator(
            ControllerRecorder recorder,
            DelimiterTokenizer tokenizer,
            NumberParser<BigInteger> parser
    ) {
        super(tokenizer, parser);
        this.recorder = recorder;
    }

    @Override
    public Number calculate(String expression) {
        recorder.record(CALCULATOR_CALCULATE);
        return super.calculate(expression);
    }
}