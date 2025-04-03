package cv2_and_cv5;

import java.util.List;
import java.util.Scanner;

public class LexicalAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        //cv 2
        /*
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
        */ 
        //cv 5
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            Lexer lexer = new Lexer(line);
            List<Token> tokens = lexer.tokenize();

            try {
                Parser parser = new Parser(tokens);
                List<Integer> ruleNumbers = parser.parse();
                for (int num : ruleNumbers) {
                    System.out.print(num + " ");
                }
                System.out.println();
            } catch (Exception e) {
                System.out.println("ERROR");
            }
        }

        scanner.close();
    }
}
