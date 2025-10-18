package calculator.fixture;

import java.util.ArrayList;
import java.util.List;

public class ControllerRecorder {

    private final List<CallName> calls = new ArrayList<>();

    public void record(CallName callName) {
        calls.add(callName);
    }

    public void verifyCalled(CallName callName) {
        if (calls.isEmpty() || calls.getFirst() != callName) {
            throw new IllegalArgumentException("실행 순서가 올바르지 않습니다.");
        }
        calls.removeFirst();
    }
}