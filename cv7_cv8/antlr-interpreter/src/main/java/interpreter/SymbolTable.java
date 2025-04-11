package interpreter;

import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private final Map<String, Type> variables = new HashMap<>();

    public boolean declare(String name, Type type) {
        if (variables.containsKey(name)) return false;
        variables.put(name, type);
        return true;
    }

    public boolean isDeclared(String name) {
        return variables.containsKey(name);
    }

    public Type getType(String name) {
        return variables.getOrDefault(name, Type.ERROR);
    }

    public void assign(String name, Type type) {
        variables.put(name, type);
    }
}
