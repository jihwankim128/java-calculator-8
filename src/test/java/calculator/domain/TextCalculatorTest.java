package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.domain.calculator.BigNumberTextCalculator;
import calculator.fixture.stub.DelimiterTokenizerStub;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class TextCalculatorTest {

    DelimiterTokenizer delimiterTokenizerStub = new DelimiterTokenizerStub();
    NumberParser<BigInteger> numberParserStub = value -> BigInteger.TEN;
    TextCalculator<BigInteger> textCalculator = new BigNumberTextCalculator(delimiterTokenizerStub, numberParserStub);

    @Test
    void 표현식이_주어졌을_때_계산처리_시_토큰화와_파싱_과정을_거치고_계산_결과를_반환한다() {
        // given
        String expression = "mockExpression";

        // when
        Number result = textCalculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(BigInteger.valueOf(30));
    }
}