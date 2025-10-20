package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {
    
    @Test
    void 기본_구분자_사용() {
        assertSimpleTest(() -> {
            run("1,2:3");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 빈_값_입력() {
        assertSimpleTest(() -> {
            run("\n");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1,2,3", " ", "1,2,", "1, 2, 3", "//.-\\n1", "//.\\n//-\\n1", "a//.-\\n1"})
    void 예외_테스트(String invalidExpression) {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(invalidExpression))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 큰_수_입력_테스트() {
        // given : 큰 수가 주어진다면,
        String maxLongValue = String.valueOf(Long.MAX_VALUE);
        int maxLongLength = maxLongValue.length();
        String firstBigNumber = "1".repeat(maxLongLength + 1);
        String secondBigNumber = "2".repeat(maxLongLength + 1);
        String bigNumberExpression = firstBigNumber + "," + secondBigNumber;

        // when & then : 큰수에 대한 연산 결과가 출력된다.
        String bigNumberSumResult = "3".repeat(maxLongLength + 1);
        assertSimpleTest(() -> {
            run(bigNumberExpression);
            assertThat(output()).contains("결과 : " + bigNumberSumResult);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
