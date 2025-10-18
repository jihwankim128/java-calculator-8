package calculator.stub;

import calculator.domain.DelimiterTokenizer;

public class DelimiterTokenizerStub extends DelimiterTokenizer {

    @Override
    protected String[] parseExpression(String expression) {
        return new String[]{"dummy1", "dummy2", "dummy3"};
    }
}
