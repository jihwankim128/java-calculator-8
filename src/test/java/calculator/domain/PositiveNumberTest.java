package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.domain.calculator.PositiveNumber;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberTest {

    @Test
    void 양수가_주어지면_PositiveNumber를_생성할_수_있다() {
        // given
        BigInteger positiveNumber = BigInteger.valueOf(1);

        // when
        PositiveNumber result = PositiveNumber.of(positiveNumber);

        // then
        assertThat(result.getValue()).isEqualTo(positiveNumber);
    }

    @ParameterizedTest
    @ValueSource(longs = {0, -1})
    void 양수가_아니라면_PositiveNumber_생성시_예외가_발생한다(long value) {
        // given
        BigInteger negativeNumber = BigInteger.valueOf(value);

        // when & then
        assertThatThrownBy(() -> PositiveNumber.of(negativeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}