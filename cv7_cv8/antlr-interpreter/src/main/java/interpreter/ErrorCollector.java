package interpreter;

import java.util.ArrayList;
import java.util.List;

public class ErrorCollector {
    private final List<String> errors = new ArrayList<>();

    public void addError(int line, int column, String message) {
        errors.add(String.format("%d:%d - %s", line, column, message));
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void printErrors() {
        for (String error : errors) {
            System.err.println(error);
        }
    }
}
