package cv3;

import java.util.*;
import java.util.regex.*;

public class Grammar {
    public final Map<String, List<GrammarRule>> rules = new HashMap<>();
    public final Set<String> nonTerminals = new HashSet<>();
    public final Set<String> terminals = new HashSet<>();
    public String startSymbol;

    public Grammar(String input) {
        parseGrammar(input);
    }

    private void parseGrammar(String input) {
        String[] lines = input.split(";");
        Pattern comment = Pattern.compile("\\{.*?}");

        for (String line : lines) {
            line = comment.matcher(line).replaceAll(""); // удаляем {комментарии}
            line = line.trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(":");
            String left = parts[0].trim();
            if (startSymbol == null) startSymbol = left;
            nonTerminals.add(left);

            String[] alternatives = parts[1].split("\\|");
            for (String alt : alternatives) {
                List<String> symbols = new ArrayList<>();
                for (String token : alt.trim().split("\\s+")) {
                    if (token.isEmpty()) continue;
                    if (Character.isUpperCase(token.charAt(0))) nonTerminals.add(token);
                    else if (!token.equals("{e}")) terminals.add(token);
                    symbols.add(token);
                }
                rules.computeIfAbsent(left, k -> new ArrayList<>())
                     .add(new GrammarRule(left, symbols));
            }
        }

        terminals.add("$"); // символ конца ввода
    }

    public List<GrammarRule> getRules(String nonTerminal) {
        return rules.getOrDefault(nonTerminal, new ArrayList<>());
    }

    public Set<String> getNonTerminals() {
        return nonTerminals;
    }

    public Set<String> getTerminals() {
        return terminals;
    }

    public String getStartSymbol() {
        return startSymbol;
    }
}
