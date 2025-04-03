package cv2_and_cv5;

public class Token {
    final TokenType type;
    final String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return type + (value.isEmpty() ? "" : ":" + value);
    }
}

