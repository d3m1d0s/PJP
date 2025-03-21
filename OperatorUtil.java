// содержит вспомогательные методы для проверки операторов и их приоритетов
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
