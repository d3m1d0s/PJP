package cv1;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// parsing an infix expression and converting it to postfix (RPN) - Reverse Polish Notation
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
                if (operators.isEmpty()) throw new Exception("ERROR"); // invalid parentheses
                operators.pop(); // remove '('
            } 
            else if (OperatorUtil.isOperator(ch)) {
                while (!operators.isEmpty() && OperatorUtil.precedence(operators.peek()) >= OperatorUtil.precedence(ch)) {
                    output.add(String.valueOf(operators.pop()));
                }
                operators.push(ch);
            } 
            else {
                throw new Exception("ERROR"); // invalid character
            }
            i++;
        }

        while (!operators.isEmpty()) {
            if (operators.peek() == '(') throw new Exception("ERROR"); // invalid parentheses
            output.add(String.valueOf(operators.pop()));
        }

        return output;
    }
}
