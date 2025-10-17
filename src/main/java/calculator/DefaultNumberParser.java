package calculator;

import java.math.BigInteger;

public class DefaultNumberParser implements NumberParser {

    public BigInteger parse(String value) {
        try {
            return new BigInteger(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다.");
        }
    }
}