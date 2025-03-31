package cv3;

import java.util.*;

public class Computer {
    private final Grammar grammar;

    private final Map<List<String>, Set<String>> firstSets = new HashMap<>();
    private final Map<String, Set<String>> firstTable = new HashMap<>();
    private final Map<String, Set<String>> followTable = new HashMap<>();
    private final Set<String> nullable = new HashSet<>();

    public Computer(Grammar grammar) {
        this.grammar = grammar;
        computeNullable();
        computeFirstSets();
        computeFollowSets();
    }

    private void computeNullable() {
        boolean changed;
        do {
            changed = false;
            for (String nt : grammar.getNonTerminals()) {
                for (GrammarRule rule : grammar.getRules(nt)) {
                    boolean allNullable = true;
                    for (String sym : rule.right) {
                        if (!sym.equals("{e}") && !nullable.contains(sym)) {
                            allNullable = false;
                            break;
                        }
                    }
                    if (allNullable && nullable.add(nt)) {
                        changed = true;
                    }
                }
            }
        } while (changed);
    }

    private void computeFirstSets() {
        // 1. Инициализация firstTable для всех нетерминалов
        for (String nt : grammar.getNonTerminals()) {
            firstTable.put(nt, new HashSet<>());
        }

        boolean changed;
        do {
            changed = false;
            for (String nt : grammar.getNonTerminals()) {
                for (GrammarRule rule : grammar.getRules(nt)) {
                    List<String> rhs = rule.right;
                    Set<String> first = computeFirstOfSymbols(rhs);
                    Set<String> currentSet = firstTable.get(nt);
                    if (currentSet.addAll(first)) {
                        changed = true;
                    }

                    // Сохраняем first для конкретного правила
                    firstSets.put(rhs, first);
                }
            }
        } while (changed);
    }

    private Set<String> computeFirstOfSymbols(List<String> symbols) {
        Set<String> result = new HashSet<>();
        if (symbols.isEmpty()) {
            result.add("{e}");
            return result;
        }

        for (String sym : symbols) {
            if (sym.equals("{e}")) {
                result.add("{e}");
                break;
            }
            if (grammar.getTerminals().contains(sym)) {
                result.add(sym);
                break;
            }
            Set<String> firstNt = new HashSet<>(firstTable.getOrDefault(sym, Set.of()));
            result.addAll(firstNt);
            if (!nullable.contains(sym)) {
                break;
            }
        }

        // Если все символы nullable
        boolean allNullable = true;
        for (String sym : symbols) {
            if (!nullable.contains(sym) && !sym.equals("{e}")) {
                allNullable = false;
                break;
            }
        }
        if (allNullable) result.add("{e}");

        return result;
    }

    private void computeFollowSets() {
        // инициализация follow
        for (String nt : grammar.getNonTerminals()) {
            followTable.put(nt, new HashSet<>());
        }
        followTable.get(grammar.getStartSymbol()).add("$");

        boolean changed;
        do {
            changed = false;
            for (String nt : grammar.getNonTerminals()) {
                for (GrammarRule rule : grammar.getRules(nt)) {
                    List<String> rhs = rule.right;
                    for (int i = 0; i < rhs.size(); i++) {
                        String sym = rhs.get(i);
                        if (!grammar.getNonTerminals().contains(sym)) continue;

                        List<String> beta = rhs.subList(i + 1, rhs.size());
                        Set<String> firstBeta = computeFirstOfSymbols(beta);
                        Set<String> followSym = followTable.get(sym);

                        Set<String> before = new HashSet<>(followSym);
                        for (String f : firstBeta) {
                            if (!f.equals("{e}")) {
                                followSym.add(f);
                            }
                        }

                        if (firstBeta.contains("{e}") || beta.isEmpty()) {
                            followSym.addAll(followTable.get(nt));
                        }

                        if (!before.equals(followSym)) {
                            changed = true;
                        }
                    }
                }
            }
        } while (changed);
    }

    public void printResults() {
        // Вывод FIRST для правых частей
        for (String nt : grammar.getNonTerminals()) {
            for (GrammarRule rule : grammar.getRules(nt)) {
                Set<String> first = firstSets.get(rule.right);
                System.out.printf("first[%s:%s] = %s%n", nt, String.join("", rule.right), formatSet(first));
            }
        }

        // Вывод FOLLOW для нетерминалов
        for (String nt : grammar.getNonTerminals()) {
            Set<String> follow = followTable.get(nt);
            System.out.printf("follow[%s] = %s%n", nt, formatSet(follow));
        }
    }

    private String formatSet(Set<String> set) {
        return String.join(" ", new TreeSet<>(set));
    }
}

