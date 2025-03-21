import java.util.*;

// ввод и обработка выражений
public class ArithmeticInterpreter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine().trim());

        StringBuilder output = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
            String expression = scanner.nextLine().replaceAll("\\s+", ""); // убираем пробелы
            try {
                List<String> postfix = ExpressionParser.infixToPostfix(expression);
                int result = ExpressionEvaluator.evaluatePostfix(postfix);
                output.append(result).append("\n");
            } catch (Exception e) {
                output.append("ERROR\n");
            }
        }
        scanner.close();
        System.out.print(output.toString());
    }
}
