package cv2;

import java.util.List;
import java.util.Scanner;

public class LexicalAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder input = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            input.append(scanner.nextLine()).append("\n");
        }
        scanner.close();
        
        Lexer lexer = new Lexer(input.toString());
        List<Token> tokens = lexer.tokenize();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }
}
