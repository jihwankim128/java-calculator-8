package calculator.domain.tokenizer;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SimpleDelimiterTokenizerTest {

    SimpleDelimiterTokenizer tokenizer = new SimpleDelimiterTokenizer();

    @Test
    void 기본_구분자가_포함된_표현식이_주어지면_구분자로_분리한다() {
        // given
        String expression = "1,2:3";

        // when
        String[] result = tokenizer.tokenize(expression);

        // then
        assertThat(result).contains("1", "2", "3");
    }

    @Test
    void 구분자가_마지막에_포함된_경우_마지막에_빈_값을_포함하여_분리한다() {
        // given
        String expression = "1,2,";

        // when
        String[] result = tokenizer.tokenize(expression);

        // then
        assertThat(result).contains("1", "2", "");
    }

    @Test
    void 커스텀_구분자가_포함된_표현식이_주어지면_기본_구분자를_포함해_구분한다() {
        // given
        String expressionWithCustomDelimiter = "//.\\n1.2";
        
        // when
        String[] result = tokenizer.tokenize(expressionWithCustomDelimiter);

        // then
        assertThat(result).contains("1", "2");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "//-.\\n1",         // 1. Custom 구분자로 '문자'가 아닌 '문자열'이 입력된 경우
            "//-\\n//.\\n1"     // 2. Custom 구분자 입력이 2개 이상인 경우
    })
    void 잘못된_커스텀_구분자_입력시_예외가_발생한다(String invalidExpression) {
        // when & then
        assertThatThrownBy(() -> tokenizer.tokenize(invalidExpression))
                .isInstanceOf(IllegalArgumentException.class);
    }
}