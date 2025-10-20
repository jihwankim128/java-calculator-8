package calculator.domain.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.domain.NumberParser;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

class TextBigNumberParserTest {

    private final NumberParser<BigInteger> numberParser = new TextBigNumberParser();
    
    @Test
    void 문자열_숫자가_주어지면_큰_숫자로_타입으로_변환한다() {
        // given
        String bigNumber = "1".repeat(100);
        
        // when
        BigInteger result = numberParser.parse(bigNumber);

        // then
        assertThat(result).isEqualTo(new BigInteger(bigNumber));
    }

    @Test
    void 문자열_숫자가_아니라면_변환과정에서_예외가_발생한다() {
        // given
        String invalidNumber = "a";
        
        // when & then
        assertThatThrownBy(() -> numberParser.parse(invalidNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}