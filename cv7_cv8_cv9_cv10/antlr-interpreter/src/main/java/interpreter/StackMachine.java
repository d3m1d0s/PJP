package interpreter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class StackMachine {
    private Stack<Object> stack = new Stack<>();
    private Map<String, Object> variables = new HashMap<>();

    public void execute(List<String> instructions) {
        for (String instruction : instructions) {
            handleInstruction(instruction.trim());
        }
    }

    private void handleInstruction(String instructionLine) {
        if (instructionLine.isEmpty()) return;
    
        String[] parts = instructionLine.split("\\s+");
        String command = parts[0];
    
        switch (command) {
            case "PUSH":
                if (parts.length < 3) {
                    throw new RuntimeException("Invalid PUSH instruction: " + instructionLine);
                }
                push(parts[1], parts[2]);
                break;
            case "LOAD":
                if (parts.length < 2) {
                    throw new RuntimeException("Invalid LOAD instruction: " + instructionLine);
                }
                load(parts[1]);
                break;
            case "SAVE":
                if (parts.length < 3) {
                    throw new RuntimeException("Invalid SAVE instruction: " + instructionLine);
                }
                save(parts[1], parts[2]);
                break;
            case "PRINT":
                if (parts.length < 2) {
                    throw new RuntimeException("Invalid PRINT instruction: " + instructionLine);
                }
                print(parts[1]);
                break;
            case "ADD":
            case "SUB":
            case "MUL":
            case "DIV":
            case "MOD":
                binaryOperation(command);
                break;
            default:
                throw new RuntimeException("Unknown instruction: " + instructionLine);
        }
    }
    

    private void push(String type, String value) {
        if (type.equals("I")) {
            stack.push(Integer.parseInt(value));
        } else if (type.equals("F")) {
            stack.push(Float.parseFloat(value));
        } else {
            throw new RuntimeException("Unknown PUSH type: " + type);
        }
    }

    private void load(String varName) {
        if (!variables.containsKey(varName)) {
            throw new RuntimeException("Variable not defined: " + varName);
        }
        stack.push(variables.get(varName));
    }

    private void save(String type, String varName) {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty on SAVE");
        }
        Object value = stack.pop();
        if (type.equals("I")) {
            if (value instanceof Float) {
                value = ((Float) value).intValue();
            }
            variables.put(varName, (Integer) value);
        } else if (type.equals("F")) {
            if (value instanceof Integer) {
                value = ((Integer) value).floatValue();
            }
            variables.put(varName, (Float) value);
        } else {
            throw new RuntimeException("Unknown SAVE type: " + type);
        }
    }

    private void print(String type) {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty on PRINT");
        }
        Object value = stack.pop();
        if (type.equals("I")) {
            if (value instanceof Float) {
                value = ((Float) value).intValue();
            }
            System.out.println((Integer) value);
        } else if (type.equals("F")) {
            if (value instanceof Integer) {
                value = ((Integer) value).floatValue();
            }
            System.out.println((Float) value);
        } else {
            throw new RuntimeException("Unknown PRINT type: " + type);
        }
    }

    private void binaryOperation(String op) {
        if (stack.size() < 2) {
            throw new RuntimeException("Stack has fewer than two elements for operation " + op);
        }

        Object b = stack.pop();
        Object a = stack.pop();

        if (a instanceof Integer && b instanceof Float) {
            a = ((Integer) a).floatValue();
        } else if (a instanceof Float && b instanceof Integer) {
            b = ((Integer) b).floatValue();
        }

        Object result;

        if (a instanceof Integer && b instanceof Integer) {
            int ia = (Integer) a;
            int ib = (Integer) b;
            switch (op) {
                case "ADD": result = ia + ib; break;
                case "SUB": result = ia - ib; break;
                case "MUL": result = ia * ib; break;
                case "DIV": result = ia / ib; break;
                case "MOD": result = ia % ib; break;
                default: throw new RuntimeException("Unknown operation: " + op);
            }
        } else {
            float fa = (a instanceof Integer) ? (Integer) a : (Float) a;
            float fb = (b instanceof Integer) ? (Integer) b : (Float) b;
            switch (op) {
                case "ADD": result = fa + fb; break;
                case "SUB": result = fa - fb; break;
                case "MUL": result = fa * fb; break;
                case "DIV": result = fa / fb; break;
                case "MOD": throw new RuntimeException("MOD not supported for floats");
                default: throw new RuntimeException("Unknown operation: " + op);
            }
        }

        stack.push(result);
    }
}