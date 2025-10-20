package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void 큰_양수_값들이_주어지면_합산을_구한다() {
        // given
        Numbers<BigInteger> numbers = new Numbers<>();
        numbers.add(PositiveNumber.of(BigInteger.ONE));
        numbers.add(PositiveNumber.of(BigInteger.TWO));
        numbers.add(PositiveNumber.of(BigInteger.TEN));

        // when
        BigInteger result = numbers.sum(BigInteger.ZERO, BigInteger::add);

        // then
        assertThat(result).isEqualTo(BigInteger.valueOf(13));
    }

    @Test
    void 양의_정수_값들이_주어지면_합산을_구한다() {
        // given
        Numbers<Integer> numbers = new Numbers<>();
        numbers.add(PositiveNumber.of(1));
        numbers.add(PositiveNumber.of(10));
        numbers.add(PositiveNumber.of(100));

        // when
        Integer result = numbers.sum(0, Integer::sum);

        // then
        assertThat(result).isEqualTo(111);
    }

    @Test
    void 큰_범위의_양의_정수_값들이_주어지면_합산을_구한다() {
        // given
        Numbers<Long> numbers = new Numbers<>();
        numbers.add(PositiveNumber.of(1L));
        numbers.add(PositiveNumber.of(10L));
        numbers.add(PositiveNumber.of(100L));

        // when
        Long result = numbers.sum(0L, Long::sum);

        // then
        assertThat(result).isEqualTo(111L);
    }
}