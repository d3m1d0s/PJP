package cv2_and_cv5;

import java.util.*;
import java.util.regex.*;

public class Lexer {
    private static final Pattern TOKEN_PATTERN = Pattern.compile(
        "(?<DIV>\\bdiv\\b)|" +
        "(?<MOD>\\bmod\\b)|" +
        "(?<NUMBER>\\b\\d+\\b)|" +
        "(?<OPERATOR>[+\\-*/])|" +
        "(?<LPAREN>\\()|" +
        "(?<RPAREN>\\))|" +
        "(?<SEMICOLON>;)|" +
        "(?<IDENTIFIER>\\b[a-zA-Z][a-zA-Z0-9]*\\b)|" +
        "(?<COMMENT>//.*)|" +
        "(?<WHITESPACE>\\s+)"                 
    );

    private final Matcher matcher;
    private final List<Token> tokens = new ArrayList<>();

    public Lexer(String input) {
        String inputWithoutComments = removeComments(input);
        this.matcher = TOKEN_PATTERN.matcher(inputWithoutComments);
    }

    public List<Token> tokenize() {
        while (matcher.find()) {
            if (matcher.group("NUMBER") != null) {
                tokens.add(new Token(TokenType.NUMBER, matcher.group("NUMBER")));
            } else if (matcher.group("DIV") != null) {
                tokens.add(new Token(TokenType.DIV, "div"));
            } else if (matcher.group("MOD") != null) {
                tokens.add(new Token(TokenType.MOD, "mod"));
            } else if (matcher.group("OPERATOR") != null) {
                tokens.add(new Token(TokenType.OPERATOR, matcher.group("OPERATOR")));
            } else if (matcher.group("LPAREN") != null) {
                tokens.add(new Token(TokenType.LPAREN, "("));
            } else if (matcher.group("RPAREN") != null) {
                tokens.add(new Token(TokenType.RPAREN, ")"));
            } else if (matcher.group("SEMICOLON") != null) {
                tokens.add(new Token(TokenType.SEMICOLON, ";"));
            } else if (matcher.group("IDENTIFIER") != null) {
                tokens.add(new Token(TokenType.IDENTIFIER, matcher.group("IDENTIFIER")));
            }
        }
        return tokens;
    }

    private static String removeComments(String input) {
        StringBuilder result = new StringBuilder();
        String[] lines = input.split("\n");
        for (String line : lines) {
            int index = line.indexOf("//");
            if (index != -1) {
                line = line.substring(0, index); 
            }
            result.append(line).append("\n");
        }
        return result.toString();
    }    

}

