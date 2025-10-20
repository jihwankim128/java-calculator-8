package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class DelimiterTokenizerTest {
    
    DelimiterTokenizer tokenizer = new DelimiterTokenizer() {
        @Override
        protected String[] parseExpression(String expression) {
            return new String[] {"Dummy"};
        }
    };

    @ParameterizedTest
    @NullAndEmptySource
    void DelimiterTokenizer는_빈_표현식이_주어지면_무조건_빈_문자열_배열을_반환한다(String emptyExpression) {
        // when
        String[] result = tokenizer.tokenize(emptyExpression);

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void 빈_표현식이_아니라면_구현에_따라_다른_문자_배열을_반환한다() {
        // given
        String expression = "anyExpression";

        // when
        String[] result = tokenizer.tokenize(expression);

        // then
        assertThat(result).hasSize(1);
        assertThat(result[0]).isEqualTo("Dummy");
    }
}