package cv3_and_cv4.grammar;

public class GrammarException extends Exception {

    public GrammarException(String msg, int lineNo) {
        super(msg);
        this.lineNumber = lineNo;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    private final int lineNumber;
}
