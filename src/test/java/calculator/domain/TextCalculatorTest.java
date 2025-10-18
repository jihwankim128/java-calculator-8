package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.stub.DelimiterTokenizerStub;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class TextCalculatorTest {

    DelimiterTokenizer delimiterTokenizerStub = new DelimiterTokenizerStub();
    NumberParser numberParserStub = value -> BigInteger.TEN;
    TextCalculator textCalculator = new TextCalculator(delimiterTokenizerStub, numberParserStub);

    @Test
    void 표현식이_주어졌을_때_계산처리_시_토큰화와_파싱_과정을_거치고_계산_결과를_반환한다() {
        // given
        String expression = "mockExpression";

        // when
        BigInteger result = textCalculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(BigInteger.valueOf(30));
    }
}