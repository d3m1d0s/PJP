package cv1;
import java.util.*;

// парсинг инфиксного выражения и преобразование его в постфиксное (RPN) - Reverse Polish notation
public class ExpressionParser {
    public static List<String> infixToPostfix(String expression) throws Exception {
        Stack<Character> operators = new Stack<>();
        List<String> output = new ArrayList<>();
        int i = 0;

        while (i < expression.length()) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                StringBuilder number = new StringBuilder();
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    number.append(expression.charAt(i++));
                }
                output.add(number.toString());
                continue;
            } 
            else if (ch == '(') {
                operators.push(ch);
            } 
            else if (ch == ')') {
                while (!operators.isEmpty() && operators.peek() != '(') {
                    output.add(String.valueOf(operators.pop()));
                }
                if (operators.isEmpty()) throw new Exception("ERROR"); // некорректные скобки
                operators.pop(); // убираем '('
            } 
            else if (OperatorUtil.isOperator(ch)) {
                while (!operators.isEmpty() && OperatorUtil.precedence(operators.peek()) >= OperatorUtil.precedence(ch)) {
                    output.add(String.valueOf(operators.pop()));
                }
                operators.push(ch);
            } 
            else {
                throw new Exception("ERROR"); // некорректный символ
            }
            i++;
        }

        while (!operators.isEmpty()) {
            if (operators.peek() == '(') throw new Exception("ERROR"); // некорректные скобки
            output.add(String.valueOf(operators.pop()));
        }

        return output;
    }
}
