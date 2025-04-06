package cv1;
// contains utility methods for checking operators and their precedence
public class OperatorUtil {
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    public static int precedence(char ch) {
        return (ch == '+' || ch == '-') ? 1 : (ch == '*' || ch == '/') ? 2 : -1;
    }

    public static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}
