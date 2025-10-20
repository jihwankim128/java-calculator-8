package calculator.fixture.spy;

import static calculator.fixture.CallName.FACTORY_GET_TEXT_CALCULATOR;

import calculator.application.CalculatorFactory;
import calculator.domain.DelimiterTokenizer;
import calculator.domain.NumberParser;
import calculator.domain.TextCalculator;
import calculator.fixture.ControllerRecorder;
import calculator.fixture.stub.DelimiterTokenizerStub;
import java.math.BigInteger;

public class SpyCalculatorFactory extends CalculatorFactory {

    private final ControllerRecorder recorder;
    
    public SpyCalculatorFactory(ControllerRecorder recorder) {
        this.recorder = recorder;
    }
    
    @Override
    public TextCalculator<BigInteger> getTextCalculator() {
        recorder.record(FACTORY_GET_TEXT_CALCULATOR);
        DelimiterTokenizer tokenizer = new DelimiterTokenizerStub();
        NumberParser<BigInteger> parser = value -> BigInteger.TEN;
        return new SpyTextCalculator(recorder, tokenizer, parser);
    }
}