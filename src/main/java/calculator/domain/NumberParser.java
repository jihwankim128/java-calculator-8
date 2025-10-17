package calculator.domain;

import java.math.BigInteger;

@FunctionalInterface
public interface NumberParser {

    BigInteger parse(String value);
}
