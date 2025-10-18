package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void PositiveNumber들이_주어지면_PositiveNumber들의_합산을_구한다() {
        // given
        Numbers numbers = new Numbers();
        numbers.add(PositiveNumber.of(BigInteger.ONE));
        numbers.add(PositiveNumber.of(BigInteger.TWO));
        numbers.add(PositiveNumber.of(BigInteger.TEN));

        // when
        BigInteger result = numbers.sum();

        // then
        assertThat(result).isEqualTo(BigInteger.valueOf(13));
    }

}