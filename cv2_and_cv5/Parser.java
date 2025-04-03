package cv2_and_cv5;

import java.util.*;

/*
  Grammar for the recursive descent:
  E  :  T E1;        (1)
  E1 :  '+' T E1     (2)
     |  '-' T E1     (3)
     |  {e};         (4)
  T  :  F T1;        (5)
  T1 :  '*' F T1     (6)
     |  '/' F T1     (7)
     |  {e}          (8)
  F  :  '(' E ')'    (9)
     |  num          (10)
 */

public class Parser {
    private final List<Token> tokens;
    private int index = 0;
    private final List<Integer> rulesUsed = new ArrayList<>();

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Integer> parse() {
        E(); // стартовая точка
        if (index < tokens.size()) throw new RuntimeException("Unexpected token");
        return rulesUsed;
    }

    private void E() {
        rulesUsed.add(1);
        T();
        E1();
    }

    private void E1() {
        if (match("+")) {
            rulesUsed.add(2);
            T();
            E1();
        } else if (match("-")) {
            rulesUsed.add(3);
            T();
            E1();
        } else {
            rulesUsed.add(4); // пустое e
        }
    }

    private void T() {
        rulesUsed.add(5);
        F();
        T1();
    }

    private void T1() {
        if (match("*")) {
            rulesUsed.add(6);
            F();
            T1();
        } else if (match("/")) {
            rulesUsed.add(7);
            F();
            T1();
        } else {
            rulesUsed.add(8);
        }
    }

    private void F() {
        if (match("(")) {
            rulesUsed.add(9);
            E();
            if (!match(")")) throw new RuntimeException("Expected )");
        } else if (peek().type == TokenType.NUMBER) {
            rulesUsed.add(10);
            advance();
        } else {
            throw new RuntimeException("Unexpected token in F()");
        }
    }

    private boolean match(String symbol) {
        if (index < tokens.size() && tokens.get(index).value.equals(symbol)) {
            index++;
            return true;
        }
        return false;
    }

    private Token peek() {
        return tokens.get(index);
    }

    private void advance() {
        index++;
    }
}

