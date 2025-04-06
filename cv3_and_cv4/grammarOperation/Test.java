package cv3_and_cv4.grammarOperation;

import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import cv3_and_cv4.grammar.Grammar;
import cv3_and_cv4.grammar.GrammarException;
import cv3_and_cv4.grammar.GrammarReader;
import cv3_and_cv4.grammar.Nonterminal;
import cv3_and_cv4.grammar.Rule;
import cv3_and_cv4.grammar.Symbol;

public class Test {

    public static void main(String[] args) {
        Grammar grammar;

        try {
            GrammarReader inp = new GrammarReader(new FileReader(args[0]));
            grammar = inp.read();
        } catch (GrammarException e) {
            System.err.println("Error(" + e.getLineNumber() + ") " + e.getMessage());
            return;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return;
        }

        grammar.dump(System.out);

        GrammarOps go = new GrammarOps(grammar);

        // print FIRST set for each rule
        System.out.println("\nFIRST sets:");
        for (Rule r : grammar.getRules()) {
            System.out.print("first[" + r.getLHS().getName() + ":");
            for (Symbol s : r.getRHS()) {
                System.out.print(s.getName());
            }
            System.out.print("] = ");
            Set<String> result = new LinkedHashSet<>();
            boolean nullable = true;
            for (Symbol s : r.getRHS()) {
                Set<String> fs = go.getFirst(s);
                result.addAll(fs);
                if (!fs.contains("{e}")) {
                    nullable = false;
                    break;
                }
            }
            if (nullable) result.add("{e}");
            System.out.println(result);
        }

        // print FOLLOW set for each nonterminal
        System.out.println("\nFOLLOW sets:");
        for (Nonterminal nt : grammar.getNonterminals()) {
            System.out.println("follow[" + nt.getName() + "] = " + go.getFollow(nt));
        }

        if (go.isLL1()) {
            System.out.println("\nIt is LL1 grammar");
        } else {
            System.out.println("\nIt is not LL1 grammar");
        }
        

    }
}

