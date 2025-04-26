package interpreter;

public class Instruction {
    public enum OpCode {
        PUSH_I, PUSH_F,
        ADD, SUB, MUL, DIV, MOD,
        LOAD, SAVE_I, SAVE_F,
        PRINT_I, PRINT_F
    }

    private final OpCode opCode;
    private final String operand;  // number or name

    public Instruction(OpCode opCode, String operand) {
        this.opCode = opCode;
        this.operand = operand;
    }

    public Instruction(OpCode opCode) {
        this(opCode, null);
    }

    @Override
    public String toString() {
        if (operand != null) {
            return opCode.name().replace('_', ' ') + " " + operand;
        }
        return opCode.name().replace('_', ' ');
    }
}
