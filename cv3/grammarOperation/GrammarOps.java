package cv3.grammarOperation;

import cv3.grammar.*;
import java.util.*;

public class GrammarOps {
    Grammar g;
    Set<Nonterminal> emptyNonterminals;
    Map<Symbol, Set<String>> first = new HashMap<>();
    Map<Nonterminal, Set<String>> follow = new HashMap<>();

    public GrammarOps(Grammar g) {
        this.g = g;
        compute_empty();
        compute_first();
        compute_follow();
    }

    // 1: вычисляем нетерминалы, выводящие эпсилон
    private void compute_empty() {
        emptyNonterminals = new TreeSet<>();
        boolean changed;
        do {
            changed = false;
            for (Rule rule : g.getRules()) {
                Nonterminal lhs = rule.getLHS();
                if (!emptyNonterminals.contains(lhs)) {
                    boolean emptyRule = true;
                    for (Symbol s : rule.getRHS()) {
                        if (s instanceof Terminal || !emptyNonterminals.contains(s)) {
                            emptyRule = false;
                            break;
                        }
                    }
                    if (emptyRule) {
                        emptyNonterminals.add(lhs);
                        changed = true;
                    }
                }
            }
        } while (changed);
    }

    // 2: вычисляем множества FIRST
    private void compute_first() {
        // инициализация FIRST для терминалов
        for (Terminal t : g.getTerminals()) {
            first.put(t, new HashSet<>(Set.of(t.getName())));
        }

        // инициализация FIRST для нетерминалов
        for (Nonterminal nt : g.getNonterminals()) {
            first.put(nt, new HashSet<>());
        }

        boolean changed;
        do {
            changed = false;
            for (Rule rule : g.getRules()) {
                Set<String> currentSet = first.get(rule.getLHS());
                int prevSize = currentSet.size();

                boolean nullable = true;
                for (Symbol s : rule.getRHS()) {
                    currentSet.addAll(first.get(s));
                    currentSet.remove("{e}");
                    if (!(s instanceof Nonterminal && emptyNonterminals.contains(s))) {
                        nullable = false;
                        break;
                    }
                }

                if (nullable) currentSet.add("{e}");

                if (currentSet.size() != prevSize) {
                    changed = true;
                }
            }
        } while (changed);
    }

    // 3: вычисляем множества FOLLOW
    private void compute_follow() {
        for (Nonterminal nt : g.getNonterminals()) {
            follow.put(nt, new HashSet<>());
        }
        follow.get(g.getStartNonterminal()).add("$");

        boolean changed;
        do {
            changed = false;
            for (Rule rule : g.getRules()) {
                List<Symbol> rhs = rule.getRHS();
                for (int i = 0; i < rhs.size(); i++) {
                    if (rhs.get(i) instanceof Nonterminal) {
                        Nonterminal current = (Nonterminal) rhs.get(i);
                        Set<String> followCurrent = follow.get(current);
                        int prevSize = followCurrent.size();

                        boolean allNullable = true;
                        for (int j = i + 1; j < rhs.size(); j++) {
                            Symbol next = rhs.get(j);
                            Set<String> firstNext = new HashSet<>(first.get(next));
                            followCurrent.addAll(firstNext);
                            followCurrent.remove("{e}");
                            if (!(next instanceof Nonterminal && emptyNonterminals.contains(next))) {
                                allNullable = false;
                                break;
                            }
                        }

                        if (allNullable || i == rhs.size() - 1) {
                            followCurrent.addAll(follow.get(rule.getLHS()));
                        }

                        if (followCurrent.size() != prevSize) {
                            changed = true;
                        }
                    }
                }
            }
        } while (changed);
    }

    // методы для получения FIRST и FOLLOW
    public Set<String> getFirst(Symbol s) {
        return first.getOrDefault(s, Set.of());
    }

    public Set<String> getFollow(Nonterminal nt) {
        return follow.getOrDefault(nt, Set.of());
    }

    public Set<Nonterminal> getEmptyNonterminals() {
        return emptyNonterminals;
    }
    
}
