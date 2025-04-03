package cv2_cv5_cv6;

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

